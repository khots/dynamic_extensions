package edu.common.dynamicextensions.query;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.common.dynamicextensions.domain.nui.DataType;
import edu.common.dynamicextensions.nutility.DEApp;
import edu.common.dynamicextensions.query.ast.ExpressionNode;
import edu.common.dynamicextensions.query.ast.QueryExpressionNode;
import edu.common.dynamicextensions.query.ast.SelectListNode;

public class ColumnSummaryPostProc implements ResultPostProc {
	private Map<Integer, BigDecimal> columnTotals = new HashMap<Integer, BigDecimal>();
	
	private Map<Integer, BigDecimal> columnAvgs = new HashMap<Integer, BigDecimal>();
	
	private QueryExpressionNode queryExpr;
	
	private QueryResultData qrd;
	
	public ColumnSummaryPostProc(QueryExpressionNode queryExpr) {
		this.queryExpr = queryExpr;
		
		int columnCount = queryExpr.getSelectList().getElements().size();
		List<String> args = queryExpr.getResultPostProc().getArgs();
		for (int i = 0; i < args.size(); ) {
			String summaryType = args.get(i++);
			
			int numArgs = 0;
			if (i < args.size()) {
				numArgs = Integer.parseInt(args.get(i++));
			}
			
			for (int j = 0; j < numArgs && (j + i) < args.size(); ++j) {
				int columnIdx = Integer.parseInt(args.get(j + i));
				if (columnIdx <= 0 || columnIdx > columnCount) {
					throw new IllegalArgumentException("Invalid column index: " + columnIdx);
				}

				ExpressionNode exprNode = queryExpr.getSelectList().getElements().get(columnIdx - 1);
				if (exprNode.getType() != DataType.INTEGER && exprNode.getType() != DataType.FLOAT) {
					throw new IllegalArgumentException(
						"Invalid data type. Only integer or float can be summarised. " +
						"Column Index: " + columnIdx);
				}
				
				if (summaryType.equals("sum")) {
					columnTotals.put(columnIdx, BigDecimal.ZERO);
				} else if (summaryType.equals("avg")){
					columnAvgs.put(columnIdx, BigDecimal.ZERO);
				}
			}
			
			i += numArgs;
		}
	}

	@Override
	public int processResultSet(ResultSet rs) {		
		qrd = new QueryResultData(getResultColumns(queryExpr), DEApp.getDateFormat(), DEApp.getTimeFormat());
		qrd.dataSource(rs);
			
		for (Object[] row : qrd.getRows()) {
			for (int columnIdx : columnTotals.keySet()) {
				Number num = (Number)row[columnIdx - 1];
				if (num == null) {
					continue;
				}
				
				columnTotals.put(columnIdx, columnTotals.get(columnIdx).add(new BigDecimal(num.toString())));
			}
			
			for (int columnIdx : columnAvgs.keySet()) {
				Number num = (Number)row[columnIdx - 1];
				if (num == null) {
					continue;
				}
				
				columnAvgs.put(columnIdx, columnAvgs.get(columnIdx).add(new BigDecimal(num.toString())));
			}
		}
		
		BigDecimal numRows = new BigDecimal(qrd.getRows().size());
		Object[] row = new Object[queryExpr.getSelectList().getElements().size()];
		for (int i = 0; i < row.length; ++i) {
			if (columnTotals.containsKey(i + 1)) {
				row[i] = columnTotals.get(i + 1);
			} else if (columnAvgs.containsKey(i + 1)) {				
				row[i] = columnAvgs.get(i + 1).divide(numRows, 2, RoundingMode.HALF_UP);
			}
		}
		
		qrd.getRows().add(row);
		return qrd.getDbRowsCount();
	}

	@Override
	public List<ResultColumn> getResultColumns() {
		return qrd.getResultColumns(); 
	}

	@Override
	public List<Object[]> getRows() {
		return qrd.getRows();
	}

	@Override
	public void cleanup() {
		qrd.close();
		qrd = null;
		columnTotals.clear();
		columnTotals = null;
		columnAvgs.clear();
		columnAvgs = null;
	}

    private List<ResultColumn> getResultColumns(QueryExpressionNode queryExpr) {
        SelectListNode selectList = queryExpr.getSelectList();
        List<ResultColumn> columns = new ArrayList<ResultColumn>();
        
        for (ExpressionNode node : selectList.getElements()) {
            columns.add(new ResultColumn(node, 0));
        }
        
        return columns;
    }	
}

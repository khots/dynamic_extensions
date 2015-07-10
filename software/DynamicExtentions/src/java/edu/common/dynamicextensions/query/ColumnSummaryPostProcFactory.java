package edu.common.dynamicextensions.query;

import edu.common.dynamicextensions.query.ast.QueryExpressionNode;

public class ColumnSummaryPostProcFactory implements ResultPostProcFactory {

	public static ColumnSummaryPostProcFactory getInstance() {
		return new ColumnSummaryPostProcFactory();
	}
	
	@Override
	public ResultPostProc create(QueryExpressionNode queryExpr) {
		return new ColumnSummaryPostProc(queryExpr);
	}
}

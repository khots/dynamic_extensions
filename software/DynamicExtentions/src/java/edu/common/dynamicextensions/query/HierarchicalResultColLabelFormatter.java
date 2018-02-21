package edu.common.dynamicextensions.query;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * User: mahesh
 * Date: 5/11/15
 * Time: 12:11 PM
 */
public class HierarchicalResultColLabelFormatter implements ResultColumnLabelFormatter {
    private String separator = "# ";

    private Map<String, Integer> instanceCntMap = new HashMap<String, Integer>();

    public HierarchicalResultColLabelFormatter(String separator) {
        this.separator = separator;
    }

    @Override
    public String format(String[] nodeCaptions, int instance) {
        StringBuilder heading = new StringBuilder();

        for (int j = 0; j < nodeCaptions.length - 1; ++j) {
            heading.append(nodeCaptions[j]).append(separator);
        }
        heading.append(nodeCaptions[nodeCaptions.length - 1]);

        String headingStr = heading.toString();
        Integer instanceCnt = instanceCntMap.get(headingStr);
        if (instanceCnt == null) {
            instanceCnt = 0;
        }

        String result = "";
        if (nodeCaptions.length > 0) {
            result = nodeCaptions[0];
        }

        if (nodeCaptions.length > 1 && nodeCaptions[1].startsWith("$$_") && nodeCaptions[1].endsWith("_$$")) {
            result += separator + nodeCaptions[2];
        }

        if (nodeCaptions.length > 1) {
            result += separator + nodeCaptions[nodeCaptions.length - 1];
        }

        if (instanceCnt > 0) {
            result += separator + instanceCnt;
        }

        instanceCntMap.put(headingStr, instanceCnt + 1);
        return result;
    }

    /**
     * For generating column labels based on seprator
     * @param result
     * @return column labels
     */
    public String[] getColumnLabels(QueryResultData result){
        String []columns=new String[result.getResultColumns().size()];
        int i=0;
        for(ResultColumn resultColumn:result.getResultColumns()){
            String columnNames[]=resultColumn.toString().split("#");
            StringBuffer columnName=new StringBuffer();
            for(String tokenName:columnNames){
                if(!StringUtils.contains(tokenName,"_Extensions")&&!StringUtils.equals(tokenName,columnNames[columnNames.length-1])){
                    if(!StringUtils.equals(tokenName,columnNames[0])){
                        columnName.append(this.separator);
                    }
                    if(StringUtils.equals(this.separator,"# ")){
                       columnName.append(" ");
                    }
                     columnName.append(tokenName);
                }
            }
            if(StringUtils.isNotBlank(resultColumn.getName())){
                if(resultColumn.getName().startsWith("(P")||resultColumn.getName().startsWith("(C")){
                    columns[i]= resultColumn.getName().split(" ")[0]+columnName.toString();
                }
                else {
                    columns[i]=columnName.toString().replaceFirst(" ","");
                }
            }
            else{
                columns[i]= resultColumn.getColumnLabel(this);
            }
            i++;
        }
        return columns;
    }
}
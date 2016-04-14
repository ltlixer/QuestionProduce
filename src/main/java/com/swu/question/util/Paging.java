package com.swu.question.util;

public class Paging
{
    /**
     * <p>Discription:[分页显示，返回的int[0]为数据开始行，int[1]为数据结束行]</p>
     * @param rows
     * @param page
     * @param datanum
     * @return
     */
    public static int[] paging(int rows, int page, int datanum)
    {

        int result[] = new int[2];
        
        int max = 0;

        int min = 0;
        
        if(rows*page<=datanum){
            min =(page-1)*rows;
            max = rows*page;
        }else if(rows*page>datanum&&(page-1)*rows<datanum){
            min =(page-1)*rows;
            max = datanum;
        }
        
        result[0] = min;
        result[1] = max;

        return result;
    }
}
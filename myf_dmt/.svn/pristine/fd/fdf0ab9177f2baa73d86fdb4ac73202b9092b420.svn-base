package com.bjdreamtech.dmt.util;

/**
 * 计算页码
 * @author duanwu
 */
public class DMTPageNumPage {
    /**
     * 计算显示当前分页的起始页
     * @param pageNum 当前页码
     * @param pageCount 总页数
     * @param sideNum 分页系数  分页条中显示几个数字页码。
     * 显示数字页码个数 = 2 * sideNum + 1
     */
    public static int[] calcPage(int pageNum,int pageCount,int sideNum){
        int startNum = 0;
        int endNum = 0;
        if(pageCount<=sideNum){
            endNum = pageCount;
        }else{
            if((sideNum+pageNum)>=pageCount){
                endNum = pageCount;
            }else{
                endNum = sideNum+pageNum;
                if((sideNum+pageNum)<=(2*sideNum+1)){
                    if((2*sideNum+1)>=pageCount){
                        endNum = pageCount;
                    }else{
                        endNum = 2*sideNum+1;
                    }
                }else{
                    endNum = sideNum + pageNum;
                }
            }
        }

        if(pageNum<=sideNum){
            startNum = 1;
        }else{
            if((pageNum+sideNum)>=pageCount){
                if((2*sideNum+1)>=pageCount){
                    if((pageCount - 2*sideNum)>=1){
                        startNum = pageCount - 2*sideNum;
                    }else{
                        startNum = 1;
                    }
                }else{
                    startNum = pageCount - 2*sideNum;
                }
            }else{
                if((pageNum-sideNum)>=1){
                    startNum = pageNum - sideNum;
                }else{
                    startNum = 1;
                }
            }
        }
        return loopOut(startNum, endNum, pageNum);
    }

    /**
     * 输出计算出来的当前分页详情
     * @param startNum
     * @param endNum
     * @param pageNum
     */
    public static int[] loopOut(int startNum,int endNum,int pageNum){
        try {
            int nums[] = new int[endNum - startNum + 1];
            int j=0;
            for (int i = startNum; i <= endNum; i++) {
                nums[j] = i;
                j++;
            }
            return nums;
        }catch(Exception e){
            e.printStackTrace();
            return new int[0];
        }
    }

}

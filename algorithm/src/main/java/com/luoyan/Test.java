package com.luoyan;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //记录0的index
        List<Integer> rowIdx = new ArrayList();
        List<Integer> colIdx = new ArrayList();
        for(int row = 0 ; row < rows;row++){
            for(int col = 0; col < cols;col++){
                if(matrix[row][col] == 0){
                    rowIdx.add(row);
                    colIdx.add(col);
                }
            }
        }
        if(!rowIdx.isEmpty()){
            for(int i = 0 ; i < rowIdx.size();i++){
                int tempRow = rowIdx.get(i);
                for(int col = 0; col < cols;col++){
                    matrix[tempRow][col] = 0;
                }
            }
        }

        if(!colIdx.isEmpty()){
            for(int i = 0 ;i<colIdx.size();i++){
                int tempCol = colIdx.get(i);
                for(int row = 0; row < rows;row++){
                    matrix[row][tempCol] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {


    }

}

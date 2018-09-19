package com.how2java.springboot.test;

public class Main {

	public static int count = 0; 
	
	public static void main(String[] args) {
		long startTime=System.nanoTime();   //获取开始时间  
//		int[][] a = new int[][] { 
//			{ 9, 7, 8, 0, 4, 0, 0, 5, 0 }, 
//			{ 0, 0, 0, 0, 9, 8, 0, 0, 0 },
//			{ 1, 4, 0, 0, 2, 0, 0, 8, 0 }, 
//			{ 0, 0, 0, 0, 0, 9, 0, 0, 8 }, 
//			{ 4, 6, 0, 0, 0, 0, 5, 7, 0 },
//			{ 0, 0, 3, 0, 5, 0, 0, 0, 0 }, 
//			{ 3, 0, 0, 0, 0, 0, 2, 6, 0 }, 
//			{ 0, 0, 0, 0, 1, 2, 0, 0, 0 },
//			{ 5, 0, 0, 0, 0, 3, 8, 4, 1 }, 
//		};
		int[][] b = new int[][]{
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0}
		};
	//	for(int i=100;i>0;i--){
			new Main().calc(b);
			System.out.println(count);
		//	count=0;
	//	}
		long endTime=System.nanoTime(); //获取结束时间  
		System.out.println("程序运行时间： "+(endTime-startTime)/10+"ns"); 
	}

	public void calc(int[][] matrix) {
		System.out.println(count);
		int[][] result = matrix;
		int[] coordinate = getNextData(result);
		int m = coordinate[0];//横坐标
		int n = coordinate[1];//纵坐标

		for (int k = 9; k >= 1; k--) {
			if (checkNumber(result, m, n, k)) {
				result[m][n] = k;
				if (getNextData(result) == null) {
					//print(result);
					count++;
				} else {
					calc(result);
				}
			}
		}
		result[m][n] = 0;
	}

	private int[] getNextData(int[][] matrix) {//找到matrix自上而下，自左而右是第一个是0的位置

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (matrix[row][col] == 0) {
					int[] coordinateOfEmptySquare = { row, col };
					return coordinateOfEmptySquare;
				}
			}
		}
		return null;
	}

	private boolean checkNumber(int[][] matrix, int row, int col, int n) {//判断matrix中第row行，第col列数值为n的数是否和横向纵向9宫里的数重复
		
		for (int i = 0; i < 9; i++) {
			if (matrix[row][i] == n || matrix[i][col] == n) {
				return false;
			}
		}

		int[] leftTop = { row - (row % 3), col - (col % 3) };//取该位置所在9宫的左上角位置

		for (int r = leftTop[0]; r <= leftTop[0] + 2; r++) {
			for (int c = leftTop[1]; c <= leftTop[1] + 2; c++) {
				if (matrix[r][c] == n) {
					return false;
				}
			}
		}

		return true;
	}

	public void print(int[][] grid) {//打印2维数组
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

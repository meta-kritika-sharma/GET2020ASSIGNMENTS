/* @author Kritika Sharma
 * @date 19-01-2020
 * The class implements methods to solve the queens problem.
 */
import java.util.*;

public class QueensProblem {

	public static void createMatrix(int dimensionOfMatrix) throws Exception{
		if (dimensionOfMatrix<=3){
			throw new Exception ("The size of the matrix should be greater than 3");
		}
		int [][] userInputArray = new int[dimensionOfMatrix][dimensionOfMatrix];
		for (int i=0;i<dimensionOfMatrix;i++){
			for (int j=0;j<dimensionOfMatrix;j++){
				userInputArray[i][j] = 0;
			}
		}
		nQueen(userInputArray,0,dimensionOfMatrix);
		for (int i=0;i<dimensionOfMatrix;i++){
			for (int j=0;j<dimensionOfMatrix;j++){
				System.out.print(userInputArray[i][j]);
			}
			System.out.println();
		}
	}
	
	public static Boolean nQueen(int[][] userInputArray, int column,
			int dimensionOfMatrix) throws Exception {
		/*
		 * Recursive method to solve the queens problem
		 * @param userInputArray is the initial array containing all zeroes.
		 * @column is the value of the initial column.
		 * @dimensionOfMatrix is the value of the number of rows/columns in the matrix.
		 */
		if (dimensionOfMatrix == 0) {
			throw new Exception("The dimension should be non zero.");
		}
		if (column >= dimensionOfMatrix) {
			return true;
		}
		for (int i = 0; i < dimensionOfMatrix; i++) {
			if (checkIfQueenCanBePlaced(userInputArray, i, column,
					dimensionOfMatrix)) {
				userInputArray[i][column] = 1;
				if (nQueen(userInputArray, column + 1, dimensionOfMatrix)) {
					return true;
				}
				userInputArray[i][column] = 0;
			}
		}
		return false;

	}

	public static Boolean checkIfQueenCanBePlaced(int[][] userInputArray, int row, int column, int matrixDimension) {
		/* Method to check if queen can be placed in the cell.
		 * @param userInputArray is the initial array containing all zeroes.
		 * @param row is the value of row at which validity is to be checked.
		 * @param row is the value of column at which validity is to be checked.
		 * @param matrixDimension is the value of the number of rows/columns in the matrix.
		 */

		for (int i = 0; i < column; i++) {
			if (userInputArray[row][i] == 1) {
				return false;
			}
		}

		for (int i = row, j = column; i < matrixDimension && j >= 0; i++, j--) {
			if (userInputArray[i][j] == 1) {
				return false;
			}
		}

		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (userInputArray[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) throws Exception {
		QueensProblem object = new QueensProblem();
	}
}

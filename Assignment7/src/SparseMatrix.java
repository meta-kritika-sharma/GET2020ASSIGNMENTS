/* @author Kritika Sharma
 * @date 22-01-2020
 * Method to create an immutable class for representing two-dimensional sparse matrices. For space efficiency you should be storing only non zero elements of a matrix. It should support following methods: 
 * Method to return transpose of the matrix.
 * Method to check whether it is a symmetrical matrix.
 * Method to add two matrices.
 * Method to multiply two matrices.
*/
import java.util.*;

public class SparseMatrix {
	private int[][] sparseMatrixArray;
	private int row;
	private int column;
	
	public SparseMatrix(int[][] userArray) throws Exception{
		/* Constructor
		 * @param userArray is a two dimensional array representing sparse matrix given as input by the user.
		 * @throw exception when null value is entered.
		 */
		if (userArray==null){
			throw new Exception ("NUll Value Array Passed");
		}
		
		if (userArray.length == 0){
			throw new Exception ("Array is empty.");
		}
		int countOfNonZeroElements = 0;
		for (int i = 0; i < userArray.length; i++) {
			for (int j = 0; j < userArray[0].length; j++) {
				if (userArray[i][j] != 0) {
					countOfNonZeroElements++;
				}
			}
		}

		sparseMatrixArray = new int[3][countOfNonZeroElements];
		int k = 0;
		for (int i = 0; i < userArray.length; i++) {
			for (int j = 0; j < userArray[0].length; j++) {
				if (userArray[i][j] != 0) {
					sparseMatrixArray[0][k] = i;
					sparseMatrixArray[1][k] = j;
					sparseMatrixArray[2][k] = userArray[i][j];
					k++;
				}
			}
		}

 		this.row = userArray.length;
 		this.column = userArray[0].length;
 	}

	public int[][] transposeOfMatrix(SparseMatrix sparseMatrixArray1) {
		/* Method to find the transpose of given matrix.
		 * @sparseMatrixArray1 is the input of class SparseMatrix given by the user.
		 * @return transposeMatrix is the matrix containing transpose of original matrix;
		 */
		
		int[][] transposeMatrix = new int[column][row];
		int rowIndex, columnIndex, value;
		for (int i = 0; i < sparseMatrixArray1.sparseMatrixArray[0].length; i++) {
			rowIndex = sparseMatrixArray[0][i];
			columnIndex = sparseMatrixArray[1][i];
			value = sparseMatrixArray[2][i];
			transposeMatrix[columnIndex][rowIndex] = value;
		}
		return transposeMatrix;
	}

	public Boolean symmetricMatrix(SparseMatrix userArray) {
		/* Method to find if a matrix is symmetric or not.
		 * @userArray is  the input of class SparseMatrix given by the user.
		 * @return true if matrix is symmetric and false otherwise.
		 */
		
		int[][] transposeMatrix = transposeOfMatrix(userArray);

		for (int i = 0; i < transposeMatrix.length; i++) {
			for (int j = 0; j < transposeMatrix[0].length; j++) {
				if (transposeMatrix[i][j] != userArray.sparseMatrixArray[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public int[][] addTwoMatrices(SparseMatrix firstUserArray,
			SparseMatrix secondUserArray) throws Exception {
		/* Method to add two sparse matrices.
		 * @firstUserArray is the first input of class SparseMatrix given by the user.
		 * @secondUserArray is the second input of class SparseMatrix given by the user.
		 * @return matrix containing the sum of two matrices.
		 * @throw exception if the order of matrices is not equal.
		 */
		if ((firstUserArray.sparseMatrixArray.length != secondUserArray.sparseMatrixArray.length)
				|| (firstUserArray.row != secondUserArray.row || firstUserArray.column != secondUserArray.column)) {
			throw new Exception("Addition cannot be performed.");
		}
		int[][] sparseSumMatrix = new int[firstUserArray.sparseMatrixArray.length][firstUserArray.sparseMatrixArray[0].length];

		int[][] sumMatrix = new int[firstUserArray.row][firstUserArray.column];
		for (int i = 0; i < firstUserArray.sparseMatrixArray[0].length; i++) {
			sumMatrix[firstUserArray.sparseMatrixArray[0][i]][firstUserArray.sparseMatrixArray[1][i]] += firstUserArray.sparseMatrixArray[2][i];
		}
		for (int i = 0; i < secondUserArray.sparseMatrixArray[0].length; i++) {
			sumMatrix[secondUserArray.sparseMatrixArray[0][i]][secondUserArray.sparseMatrixArray[1][i]] += secondUserArray.sparseMatrixArray[2][i];
		}
		int count = 0;
		for (int i = 0; i < sumMatrix.length; i++) {
			for (int j = 0; j < sumMatrix[i].length; j++) {
				if (sumMatrix[i][j] != 0) {
					count++;
				}
			}
		}

		sparseSumMatrix = new int[3][count];
		for (int i = 0, index = 0; i < sumMatrix.length; i++) {
			for (int j = 0; j < sumMatrix[i].length; j++) {
				if (sumMatrix[i][j] != 0) {
					sparseSumMatrix[0][index] = i;
					sparseSumMatrix[1][index] = j;
					sparseSumMatrix[2][index] = sumMatrix[i][j];
					index++;
				}
			}
		}

 		return sumMatrix;
	}

	public int[][] multiplyTwoMatrix(SparseMatrix firstUserArray,
			SparseMatrix secondUserArray) throws Exception {
		/* Method to add two sparse matrices.
		 * @firstUserArray is the first input of class SparseMatrix given by the user.
		 * @secondUserArray is the second input of class SparseMatrix given by the user.
		 * @return matrix containing the product of two matrices.
		 * @throw exception if the order of matrices does not allow multiplication to be performed.
		 */

		if (firstUserArray.column != secondUserArray.row) {
			throw new Exception("Multiplication cannot be performed.");
		}

		int[][] sparseProductMatrix = new int[firstUserArray.row][secondUserArray.column];

		for (int i = 0; i < firstUserArray.sparseMatrixArray[0].length; i++) {
			for (int j = 0; j < secondUserArray.sparseMatrixArray[0].length; j++) {
				if (firstUserArray.sparseMatrixArray[1][i] == secondUserArray.sparseMatrixArray[0][j]) {
					int r = firstUserArray.sparseMatrixArray[0][i];
					int c = secondUserArray.sparseMatrixArray[1][j];
					int product = firstUserArray.sparseMatrixArray[2][i]
							* secondUserArray.sparseMatrixArray[2][j];
					;
					sparseProductMatrix[r][c] += firstUserArray.sparseMatrixArray[2][i]
							* secondUserArray.sparseMatrixArray[2][j];
				}
			}
		}

		for (int i = 0; i < sparseProductMatrix.length; i++) {
			for (int j = 0; j < sparseProductMatrix[0].length; j++) {
				System.out.print(sparseProductMatrix[i][j] + " ");
			}
			System.out.println();
		}

		return sparseProductMatrix;
	}

	public static void main(String args[]) throws Exception {
 
	}
}

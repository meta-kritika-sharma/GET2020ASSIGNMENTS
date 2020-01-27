import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;

public class SparseMatrixTest {

	// test for null value as input
	@Test
	public void testMatrixNullArray() {
		try {
			new SparseMatrix(null);
		} catch (Exception e) {
			assertEquals("NUll Value Array Passed", e.getMessage());
		}
	}

	// test for Empty Array input
	@Test
	public void testMatrixEmptyArray() {
		try {
			new SparseMatrix(new int[][] {});
		} catch (Exception e) {
			assertEquals("Array is empty.", e.getMessage());
		}
	}

	// Addition operation of two matrix of different size
	@Test
	public void testMatrixAdditionDifferentSizedMatrices() {
		try {
			SparseMatrix array1 = new SparseMatrix(new int[][] { { 2, 3 },
					{ 5, 6 }, { 6, 9 } });
			SparseMatrix array2 = new SparseMatrix(new int[][] {
					{ 2, 2, 2, 2 }, { 2, 2, 2, 2 } });
			array1.addTwoMatrices(array1, array2);
		} catch (Exception e) {
			assertEquals("Addition cannot be performed.", e.getMessage());
		}
	}

 	@Test
	public void test_addMatrix() throws Exception {
		SparseMatrix array1 = new SparseMatrix(new int[][] { { 2, 3 },
				{ 5, 6 }, { 6, 9 } });
		SparseMatrix array2 = new SparseMatrix(new int[][] { { 2, 2 },
				{ 2, 2 }, { 2, 2 } });
		int returnedArrOperation[][] = array1.addTwoMatrices(array1, array2);
		int[][] expectedArr = new int[][] { { 4, 5 }, { 7, 8 }, { 8, 11 } };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}

	// test for multiplication of two matrices with n x m and p x q size
	@Test
	public void testMatrixMultiplicationDifferentSizedMatrices() {
		try {
			SparseMatrix array1 = new SparseMatrix(new int[][] { { 1, 2, 3 },
					{ 4, 5, 6 }, { 7, 8, 9 } });
			SparseMatrix array2 = new SparseMatrix(new int[][] {
					{ 2, 2, 2, 2 }, { 2, 2, 2, 2 } });
			array1.multiplyTwoMatrix(array1, array2);
		} catch (Exception e) {
			assertEquals("Multiplication cannot be performed.", e.getMessage());
		}
	}

	// positive test case for matrix multiplication
	@Test
	public void test_multiplyMatrix() throws Exception {
		SparseMatrix array1 = new SparseMatrix(new int[][] { { 2, 3 },
				{ 5, 6 }, { 6, 9 } });
		SparseMatrix array2 = new SparseMatrix(new int[][] { { 2, 2, 2, 2 },
				{ 2, 2, 2, 2 } });
		int returnedArrOperation[][] = array1.multiplyTwoMatrix(array1, array2);
		int[][] expectedArr = new int[][] { { 10, 10, 10, 10 },
				{ 22, 22, 22, 22 }, { 30, 30, 30, 30 } };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}

	// test for transpose of matrix
	@Test
	public void testTransposeMatrix() throws Exception {
		SparseMatrix array1 = new SparseMatrix(new int[][] { { 2, 3 },
				{ 5, 6 }, { 6, 9 } });
		int returnedArrOperation[][] = array1.transposeOfMatrix(array1);
		int[][] expectedArr = new int[][] { { 2, 5, 6 }, { 3, 6, 9 } };
		Assert.assertArrayEquals(expectedArr, returnedArrOperation);
	}

	// negative test case for symmetric matrix where matrix is of n x m size
	@Test
	public void testSymmetricMatrix_Negative_Row_Column_Not_Same()
			throws Exception {
		SparseMatrix array1 = new SparseMatrix(new int[][] { { 2, 3 },
				{ 5, 4 }, { 4, 9 } });
		assertFalse(array1.symmetricMatrix(array1));
	}

	// negative test case for symmetric matrix where matrix is of n x n size
	@Test
	public void testSymmetricMatrix_Negative() throws Exception {
		SparseMatrix array1 = new SparseMatrix(new int[][] { { 2, 3, 1 },
				{ 5, 4, 6 }, { 7, 8, 9 } });
		assertFalse(array1.symmetricMatrix(array1));
	}
}
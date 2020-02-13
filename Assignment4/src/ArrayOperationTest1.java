import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class ArrayOperationTest1 {
	
	//Test cases for largest mirror section.
	@Test
	public void testLargestMirrorSection() {
		try { 
			ArrayOperation.largestMirrorSection(new int[]{ }); 
		}
		catch (Exception e) { 
			assertEquals("Array is empty.", e.getMessage());
		}
	}

	@Test
	public void testLargestMirrorSection1() throws Exception {  
		assertEquals(3,ArrayOperation.largestMirrorSection(new int[]{1, 2, 3, 8, 9, 3, 2, 1}));
	}
	
	@Test
	public void testLargestMirrorSection2() throws Exception{  
		assertEquals(2,ArrayOperation.largestMirrorSection(new int[]{7,1,4,9,7,4,1}));
	}
	
	@Test
	public void testLargestMirrorSection3() throws Exception{  
    assertEquals(3,ArrayOperation.largestMirrorSection(new int[]{1, 2, 1,4}));
	}
	
	@Test
	public void testLargestMirrorSection4() throws Exception{  
		assertEquals(7,ArrayOperation.largestMirrorSection(new int[]{1, 4, 5, 3, 5, 4, 1}));
	}
	
	//Test cases for split array function.
	@Test
	public void testSplitArray() {
		try {
			ArrayOperation.splitArray(new int[]{ }); 
		}
		catch (Exception e) { 
			assertEquals("Array is empty.", e.getMessage());
		}
	}

	@Test
	public void testSplitArray1() throws Exception{  
		assertEquals(3,ArrayOperation.splitArray(new int[]{ 1, 1, 1, 2, 1}));
	}

	@Test
	public void testSplitArray2() throws Exception{  
		assertEquals(-1,ArrayOperation.splitArray(new int[]{2, 1, 1, 2, 1}));
	}

	@Test
	public void testSplitArray3() throws Exception{  
		assertEquals(1,ArrayOperation.splitArray(new int[]{10,10}));
	}

	//Test cases for function to count number of clumps. 
	@Test
	public void testNumberOfClumps() {
		try { 
			ArrayOperation.numberOfClumps(new int[]{ }); 
		}
		catch (Exception e) { 
			assertEquals("Array is empty.", e.getMessage());
		}
	}
	
	@Test
	public void testNumberOfClumps1() throws Exception{  
		assertEquals(2,ArrayOperation.numberOfClumps(new int[]{1, 2, 2, 3, 4, 4}));
	}
  
	@Test
	public void testNumberOfClumps2() throws Exception{  
		assertEquals(2,ArrayOperation.numberOfClumps(new int[]{1, 1, 2, 1, 1}));
	}

	@Test
	public void testNumberOfClumps3() throws Exception{  
		assertEquals(1,ArrayOperation.numberOfClumps(new int[]{1,1,1,1,1}));
	}

	//Test cases for the FixXY problem.
	@Test
	public void testFixXYArray() {
		try { 
			ArrayOperation.solveFixXYProblem(new int[]{ },4,5); 
		}
		catch (Exception e) { 
			assertEquals("Array is empty.", e.getMessage());
		}
	}

	@Test
	public void testfixXYUnequal() {
		try { 
			ArrayOperation.solveFixXYProblem(new int[]{4,5,2,4,2},4,5); 
		}
		catch (Exception e) { 
			assertEquals("X and Y are unequal in number.", e.getMessage());
		}
	}
	
	@Test
	public void testfixXYAdjacent() {
		try { 
			ArrayOperation.solveFixXYProblem(new int[]{4,4,5,5,3,1 },4,5); 
		}
		catch (Exception e) { 
			assertEquals("Two adjacent X are present.", e.getMessage());
		}
	}
	
	@Test
	public void testfixXYLastX() {
		try { 
			ArrayOperation.solveFixXYProblem(new int[]{4,3,5,4,3,2,5,5,4},4,5); 
			}
		catch (Exception e) { 
			assertEquals("X is present at the last position.", e.getMessage());
		}
	}	
	
	@Test
	public void testfixXNotPresent() {
		try { 
			ArrayOperation.solveFixXYProblem(new int[]{4,3,5,4,3,2,5,5,4},8,5); 
			}
		catch (Exception e) { 
			assertEquals("Given value of X is not present in the array.", e.getMessage());
		}
	}	
	
	@Test
	public void testfixYNotPresent() {
		try { 
			ArrayOperation.solveFixXYProblem(new int[]{4,3,5,4,3,2,5,5,4},4,9); 
			}
		catch (Exception e) { 
			assertEquals("Given value of Y is not present in the array.", e.getMessage());
		}
	}	
	
	@Test
	public void testSolveFixXYProblem1() throws Exception{
		int returnedArrayOperation[] = ArrayOperation.solveFixXYProblem(new int[]{5, 4, 9, 4, 9, 5},4,5);
		int []expectedArr = new int[]{9, 4, 5, 4, 5, 9};
		Assert.assertArrayEquals( expectedArr, returnedArrayOperation );
	}
	
	@Test
	public void testSolveFixXYProblem2() throws Exception{
		int returnedArrayOperation[] = ArrayOperation.solveFixXYProblem(new int[]{1,4,1,5},4,5);
		int []expectedArr = new int[]{1,4,5,1};
		Assert.assertArrayEquals( expectedArr, returnedArrayOperation );
	}
	
	@Test
	public void testSolveFixXYProblem3() throws Exception{
		int returnedArrayOperation[] = ArrayOperation.solveFixXYProblem(new int[]{1,4,1,5,5,4,1},4,5);
		int []expectedArr = new int[]{1,4,5,1,1,4,5};
		Assert.assertArrayEquals( expectedArr, returnedArrayOperation );
	}


} 
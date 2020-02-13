
import static org.junit.Assert.*;

import org.junit.Test;


public class intSetTest {
	
	@Test
	public void testIntSet1() {
		try {
			new intSet(new int[]{});
		} catch (Exception e) {
			assertEquals("Array is empty.", e.getMessage());
		}
	}
	
	@Test
	public void testIntSet2() {
		try {
			intSet set = new intSet(new int[] {-1,0});
		} catch (Exception e) {
			assertEquals("Input Value should be between 0 and 1000", e.getMessage());
		}
	}
	
	@Test
	public void testIntSet3() {
		try {
			intSet set = new intSet(new int[] {1,10000});
		} catch (Exception e) {
			assertEquals("Input Value should be between 0 and 1000", e.getMessage());
		}
	}

	@Test
	public void testIntSet4() throws Exception{
		intSet set = new intSet(new int[] {1,2,3,4});
		assertTrue(set.isMember(4));
	}
	
	@Test
	public void testIntSet5() throws Exception{
		intSet set = new intSet(new int[] {1,2,3,4});
		assertFalse(set.isMember(5));
	}
	
	@Test
	public void testIntSet6() throws Exception{
		intSet set = new intSet(new int[] {1,2,3,4});
		intSet subset = new intSet(new int[] {2,3});
		assertTrue(set.isSubSet(subset));
	}

	@Test
	public void testIntSet7() throws Exception{
		intSet set = new intSet(new int[] {1,2,3,4});
		intSet subset = new intSet(new int[] {2,3,5});
		assertFalse(set.isSubSet(subset));
	}
	
	@Test
	public void testIntSet8() throws Exception{
		intSet set1 = new intSet(new int[] {1});
		intSet set2 = new intSet(new int[] {2});
		int[] resultSetExpected = new int[] {1,2};
		int[] resultSet = intSet.union(set1,set2);
		assertArrayEquals(resultSetExpected, resultSet);
	}
	
	

	

	
}

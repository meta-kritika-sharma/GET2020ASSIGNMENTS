import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

public class SearchTest {
	@Test
	public void testlinearSearch() {
		try {
			Search.linearSearch(new int[] {}, 0);
		} catch (Exception e) {
			assertEquals("Array is empty.", e.getMessage());
		}
	}

	@Test
	public void testlinearSearch1() throws Exception {
		assertEquals(1, Search.linearSearch(new int[] { 1, 2, 2, 3, 4, 4 }, 2));
	}

	@Test
	public void testlinearSearch2() throws Exception {
		assertEquals(6,
				Search.linearSearch(new int[] { 4, 4, 4, 6, 9, 1, 2, 3 }, 2));
	}

	@Test
	public void testlinearSearch3() throws Exception {
		assertEquals(0, Search.linearSearch(new int[] { 4, 4, -1, 6, 9, 0, 2, -2 }, 4));
	}

	@Test
	public void testlinearSearch4() throws Exception {
		assertEquals(1, Search.linearSearch(new int[] {0 ,4}, 4));
	}

	@Test
	public void testlinearSearch5() throws Exception {
		assertEquals(0, Search.linearSearch(new int[] {4}, 4));
	}

	@Test
	public void testbinarySearch() {
		try {
			Search.linearSearch(new int[] {}, 0);
		} catch (Exception e) {
			assertEquals("Array is empty.", e.getMessage());
		}
	}

	@Test
	public void testbinarySearch1() throws Exception {
		assertEquals(2, Search.binarySearch(new int[] { 1, 2, 2, 3, 4, 4 }, 2));
	}

	@Test
	public void testbinarySearch2() throws Exception {
		assertEquals(1,
				Search.binarySearch(new int[] { 1,2,3,4,5,6,7 }, 2));
	}
 
	@Test
	public void testbinarySearch4() throws Exception {
		assertEquals(1, Search.binarySearch(new int[] { 0, 4 }, 4));
	}

	@Test
	public void testbinarySearch5() throws Exception {
		assertEquals(-1, Search.binarySearch(new int[] { 4 }, 9));
	}

}
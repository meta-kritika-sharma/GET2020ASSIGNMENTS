import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Assert;

public class LcmAndHcfTest {
	
	//Test cases for function that generates HCF of two numbers.
	@Test 
	public void TestHcfOfTwonumbersPart1(){
		try { 
			LcmAndHcf.hcfOfTwoNumbers(0,0); 
		}
		catch (Exception e) { 
			assertEquals("Input should be a non zero number.", e.getMessage());
		}

	}

	@Test 
	public void TestHcfOfTwonumbersPart2(){
		try { 
			LcmAndHcf.hcfOfTwoNumbers(2,-1); 
		}
		catch (Exception e) { 
			assertEquals("Input should be a positive number.", e.getMessage());
		}
	}
	
	@Test
	public void TestHcfOfTwonumbers1() throws Exception{
		assertEquals(1,LcmAndHcf.hcfOfTwoNumbers(0,1));
	}
	
	@Test
	public void TestHcfOfTwonumbers2() throws Exception{
		assertEquals(1,LcmAndHcf.hcfOfTwoNumbers(1,0));
	}
	
	@Test
	public void TestHcfOfTwonumbers3() throws Exception{
		assertEquals(5,LcmAndHcf.hcfOfTwoNumbers(10,5));
	}
	
	@Test
	public void TestHcfOfTwonumbers4() throws Exception{
		assertEquals(5,LcmAndHcf.hcfOfTwoNumbers(5,10));
	}

	//Test cases for LCM function.
	@Test 
	public void TestLcmOfTwonumbersPart1(){
		try { 
			LcmAndHcf.lcmOfTwoNumbers(0,1); 
		}
		catch (Exception e) { 
			assertEquals("Input should be a non zero number.", e.getMessage());
		}

	}
	
	@Test 
	public void TestLcmOfTwonumbersPart2(){
		try { 
			LcmAndHcf.lcmOfTwoNumbers(1,0); 
		}
		catch (Exception e) { 
			assertEquals("Input should be a non zero number.", e.getMessage());
		}

	}
	
	@Test 
	public void TestHcfOfTwonumbersPart3(){
		try { 
			LcmAndHcf.hcfOfTwoNumbers(2,-1); 
		}
		catch (Exception e) { 
			assertEquals("Input should be a positive number.", e.getMessage());
		}

	}

	@Test 
	public void TestLcmOfTwonumbers1() throws Exception{
		assertEquals(10,LcmAndHcf.lcmOfTwoNumbers(5,10));
	}
}

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Assert;

public class QueensProblemTest {
	
	@Test
	public void QueensProblemTest1(){
		try{
			QueensProblem.createMatrix(1);
		}
		catch (Exception e){
			assertEquals("The size of the matrix should be greater than 3.",e.getMessage());
		}
	}
}

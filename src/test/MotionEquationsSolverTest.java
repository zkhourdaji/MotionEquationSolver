package test;

import mainPackage.MotionEquationsSolver;
import static org.junit.Assert.*;

import org.junit.Test;

public class MotionEquationsSolverTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void calculateTimeVoVATest(){
		
		assertEquals(2.0, MotionEquationsSolver.calculateTimeVoVA(0, 10, 5), 0.3);
	}

}

package test;

import org.junit.Test;

public class BestGymEverV2Test {

	CustomerTest cTest = new CustomerTest();
	CustomHandlerTest chTest = new CustomHandlerTest();
	
	@Test
	public void CustomerTest() {
		cTest.hasCustomerPaidTest();
		cTest.getNameTest();
		cTest.setNameTest();
	}
	
	@Test
	public void CustomHandlerTest() {
		chTest.getCustomerTest();
		chTest.checkIfCustomerExistTest();
	}

}

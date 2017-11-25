package test;

import junit.framework.TestCase;
import org.junit.Test;
import BestGym.CustomerHandler;


public class CustomHandlerTest {

	CustomerHandler customerTest = new CustomerHandler();

	
	@Test
	public void getCustomerTest() {
		TestCase.assertNull(customerTest.getCustomer("Kalle Kallesson"));
		TestCase.assertNull(customerTest.getCustomer("1234567890"));
		TestCase.assertNotNull(customerTest.getCustomer("Bear Belle"));
		TestCase.assertNotNull(customerTest.getCustomer("2222222222"));
	}
	
	@Test
	public void checkIfCustomerExistTest() {
		String aMemberThatExist = "Mitsuko Mayotte";
		String aMemberThatExist2 = "7805211234";
		String aMemberThatDoesntExist = "Kalle Kallesson";
		String aMemberThatDoesntExist2 = "1234567890";
		TestCase.assertEquals(customerTest.checkIfCustomerExist(aMemberThatExist), true);
		TestCase.assertEquals(customerTest.checkIfCustomerExist(aMemberThatExist2), true);
		TestCase.assertEquals(customerTest.checkIfCustomerExist(aMemberThatDoesntExist), false);
		TestCase.assertEquals(customerTest.checkIfCustomerExist(aMemberThatDoesntExist2), false);
	}
	
}
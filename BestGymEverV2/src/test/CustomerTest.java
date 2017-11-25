package test;

import junit.framework.TestCase;
import org.junit.Test;
import java.time.LocalDate;
import BestGym.Customer;

public class CustomerTest {
	
	LocalDate date1 = LocalDate.parse("2016-01-01");
	LocalDate date2 = LocalDate.parse("2016-12-02");
	LocalDate date3 = LocalDate.parse("2015-03-07");
	
	Customer kalle = new Customer("8201010433", "Kalle Nilsson", date1);
	Customer bear = new Customer("8104021234", "Bear Belle", date2);
	Customer ida = new Customer("2222222222", "Ida Idylle", date3);
	Customer null1 = new Customer(null, null, date3);
	
	@Test
	public void hasCustomerPaidTest() {
		TestCase.assertTrue(kalle.hasCustomerPaid() == false);
		TestCase.assertTrue(bear.hasCustomerPaid() == true);
		TestCase.assertTrue(ida.hasCustomerPaid() == false);
		TestCase.assertTrue(new Customer("8009090909", "Förnamn Efternamn", LocalDate.now().minusMonths(2)).hasCustomerPaid() == true);
	}
	
	@Test
	public void getNameTest() {
		TestCase.assertNull(null1.getName());
		TestCase.assertNotNull(bear.getName());
		TestCase.assertNotNull(ida.getName());		
	}
	
	@Test
	public void setNameTest() {
		ida.setName("Frida");
		TestCase.assertFalse(ida.getName().equals("Tina"));
		TestCase.assertTrue(ida.getName().equals("Frida"));
		
		Customer test = new Customer("222222333", "test", LocalDate.now());
		test.setName("Testnamn");
		TestCase.assertFalse(test.getName().equals("test"));
		TestCase.assertTrue(test.getName().equals("Testnamn"));
	}
	

}

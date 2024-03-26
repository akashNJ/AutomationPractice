package testngpractice;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
Assertions
----------
validations

Hard assertions
----
access though 'Assert' class
all methods are static
if hard assertion got failed then rest of the statement will not be executed.

Soft assertions
-----------
access through 'SoftAssert' object

SoftAssert sa=new SoftAssert();
sa.assertTrue()

if soft assertion got failed then rest of the statemetns still execute.
 */

public class AssertionDemo {

	//Hard assertion
	
	/*
	@Test (priority=1)
	void test() {
		System.out.println("this is test method");
		Assert.assertTrue(false);
	}

	@Test (priority=2, dependsOnMethods= {"test"})
	void demo() {
		System.out.println("this is demo method");
	}
	 */

	//Soft assertion

	@Test (priority=1)
	void test() {
		System.out.println("this is test method");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(true, false);
		System.out.println("after assertion");
		sa.assertAll();
	}

	@Test (priority=2, dependsOnMethods= {"test"})
	void demo() {
		System.out.println("this is demo method");
	}


}

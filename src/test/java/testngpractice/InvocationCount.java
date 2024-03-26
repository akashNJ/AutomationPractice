package testngpractice;

import org.testng.annotations.*;

public class InvocationCount {
 
	@Test (invocationCount=3)
	void test() {
		System.out.println("this is example for invocation count");
	}
}

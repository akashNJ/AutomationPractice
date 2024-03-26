package testngpractice;

import org.testng.Assert;
import org.testng.annotations.*;

public class DependsOnMethodsDemo {

	@Test (priority=1)
	void openApp(){
		System.out.println("this is openApp method");
		Assert.assertTrue(true);
	}

	@Test (priority=2, dependsOnMethods= {"openApp"})
	void login(){
		System.out.println("this is login method");
		Assert.assertTrue(false);
	}

	@Test (priority=3, dependsOnMethods= {"login"})
	void search(){
		System.out.println("this is search method");
		Assert.assertTrue(true);
	}

	@Test (priority=4)
	void closeApp(){
		System.out.println("this is closeApp method");
		Assert.assertTrue(false);
	}
}

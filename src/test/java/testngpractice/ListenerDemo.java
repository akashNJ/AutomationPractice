package testngpractice;

import org.testng.Assert;
import org.testng.annotations.*;

public class ListenerDemo {

	@Test
	void test1() {
		Assert.assertTrue(true);
	}

	@Test
	void test2() {
		Assert.assertTrue(true);
	}

	@Test
	void test3() {
		Assert.assertTrue(false);
	}

	@Test (dependsOnMethods= {"test3"})
	void test4() {
		Assert.assertTrue(true);
	}
}

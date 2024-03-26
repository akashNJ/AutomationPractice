package testngpractice;

import org.testng.annotations.Test;

public class Groups {

	@Test (priority=1, groups={"sanity"})
	void test1() {
		System.out.println("this is sanity");
	}

	@Test (priority=2, groups={"regression"})
	void test2() {
		System.out.println("this is regression");
	}

	@Test (priority=3, groups={"regression","sanity"})
	void test3() {
		System.out.println("this is sanity & regression");
	}

}

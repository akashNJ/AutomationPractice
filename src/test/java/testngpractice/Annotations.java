package testngpractice;

import org.testng.annotations.*;

/*
Annotations
----
@Test

@BeforeMethod
@AfterMethod

@BeforeClass
@AfterClass

@BeforeTest
@AfterTest

@BeforeSuite
@AfterSuite



Suite-->Tests--->Classes--->Methods

XML -- Tests----Classes--->Methods

TC1
----
1) Login - @BeforeMethod
2) Search  -   @Test
3) Logout - @AfterMethod
4) Login
5) Advanced search  -- @Test
6) Logout

TC1
----
1) Login - @BeforeClass
2) Search  - @Test
3) Advanced search  - @Test
4) Logout  - @AfterClass

 */


public class Annotations {

	@BeforeMethod
	void openAPP() {
		System.out.println("this is @BeforeMethod");
	}

	@Test
	void login() {
		System.out.println("this is @Test 1 method");
	}

	@Test
	void search() {
		System.out.println("this is @Test 2 method");
	}



	@AfterMethod
	void closeAPP() {
		System.out.println("this is @AfterMethod");
	}

	@BeforeTest
	void start_test(){
		System.out.println("this is @BeforeTest method");
	}

	@AfterTest
	void end_test() {
		System.out.println("this is @AfterTest method");
	}

	@BeforeClass
	void m() {
		System.out.println("this is @BeforeClass method");
	}

	@AfterClass
	void n() {
		System.out.println("this is @AfterClass method");
	}

	@BeforeSuite
	void x() {
		System.out.println("this is @BeforeSuite method");
	}

	@AfterSuite
	void y() {
		System.out.println("this is @AfterSuite method");
	}











}

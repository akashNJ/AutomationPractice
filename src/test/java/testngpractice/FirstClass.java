package testngpractice;

import org.testng.annotations.Test;

/*
Test Next Generation - java based unit testing tool.

Advantages:
-----
1) Test cases & test suites
2) Grouping of test cases.
3) Prioritize
4) Parameterization
5) parallel testing
6) Reports


java/maven project-->webdriver--> testng

1) by adding dependency
2) by installing testng plugin in eclipse


Install TestNG in eclipse
-------------
Help menu--> Eclipse market place-->Search for TestNG for eclipse--> Install

Window-->Preferences-->TestNG 

Add testng dependency to pom.xml.

TestSuite--->Test cases---->Test steps
Package/xml-->classes---->TestMethods

 ****  we do not have main method...

Test case
-
1) open app
2) Login
3) close

priority - control the order of execution

If you do not add @Test annotation then testng will not execute that method.

XML File
----
1) Create manually
2) Generate automatically
 */

public class FirstClass {

	@Test (priority=1)
	void openApp() {
		System.out.println("this is test1");
	}

	@Test (priority=2)
	void login() {
		System.out.println("this is test2");
	}

	@Test (priority=3)
	void close() {
		System.out.println("this is test2");
	}




}

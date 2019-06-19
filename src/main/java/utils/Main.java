package main.java.utils;

import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;

/**
 * Created by Adrian on 7/17/2018.
 */
public class Main {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("./resources/testNG.xml");//path to xml..
        //try with 2 test ngs files and with 4 threads
        testng.setTestSuites(suites);
        testng.run();
    }
}

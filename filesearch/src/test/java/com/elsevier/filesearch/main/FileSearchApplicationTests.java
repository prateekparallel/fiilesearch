package com.elsevier.filesearch.main;

import org.junit.Test;
//import org.junit.runner.RunWith;
import static org.junit.Assert.*;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import com.elsevier.filesearch.beans.*;
import com.elsevier.filesearch.exception.FileSearchException;
import com.elsevier.filesearch.services.FileSearchServices;
import com.elsevier.filesearch.services.BackEndServiceManager;
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class FileSearchApplicationTests {
/*
	@Test
	public void UnitTest_runBackEndProcess() {
		String executor = "C:\\Users\\prate\\AppData\\Local\\Programs\\Python\\Python37-32\\python";
		String pythonProgram = "C:\\Projects\\Python\\fileSearch\\runFileSearch.py";
		String outPutfile = "C:\\Projects\\test\\output.txt";
		String directoryPath = "C:\\Projects\\test";
		String fileNametoSearch = "CreditCard";
		String fileExtension = "";
		String wordToFind = "Pritam";
		String[] args ={ executor, pythonProgram, directoryPath, fileNametoSearch, fileExtension, wordToFind, outPutfile };
		BackEndServiceManager backEndServiceManager = new BackEndServiceManager();
		String outputfile = null;
		
		try {
				outputfile = backEndServiceManager.runBackEndProcess(args);
		}catch(Exception fe) {
			assertTrue("Test failed Exception caught", false);
		}
		
		System.out.println(outputfile);
		assertTrue("Test passed", true);
	}*/
	
	@Test
	public void UnitTest_processBackEndService() {
		String executor = "C:\\Users\\prate\\AppData\\Local\\Programs\\Python\\Python37-32\\python";
		String pythonProgram = "C:\\Projects\\Python\\fileSearch\\runFileSearch.py";
		String outPutfile = "C:\\Projects\\test\\output.txt";
		String directoryPath = "C:\\Projects\\test";
		String fileNametoSearch = "";
		String fileExtension = "java";
		String wordToFind = "Abhijit";
		String[] args ={ executor, pythonProgram, directoryPath, fileNametoSearch, fileExtension, wordToFind, outPutfile };
		BackEndServiceManager backEndServiceManager = new BackEndServiceManager();
		try {
			FileSearchResult result = backEndServiceManager.processBackEndService(args);
			System.out.println("File Name : " + result.getFileName());
			System.out.println("Number of Line : " + result.getWordFound());
			assertTrue("Test passed", true);
		}catch(FileSearchException e) {
			assertTrue("Test failed Exception caught", false);
		}
	}
	
	/*
	@Test
	public void UnitTest_validateParameters() {
		String executor = "C:\\Users\\prate\\AppData\\Local\\Programs\\Python\\Python37-32\\python";
		String pythonProgram = "C:\\Projects\\Python\\fileSearch\\runFileSearch.py";
		String outPutfile = "C:\\Projects\\test\\output.txt";
		String directoryPath = "C:\\Projects\\test";
		String fileNametoSearch = "";
		String fileExtension = "java";
		String wordToFind = "";
		String[] args ={ executor, pythonProgram, directoryPath, fileNametoSearch, fileExtension, wordToFind, outPutfile };
	}*/
			
}


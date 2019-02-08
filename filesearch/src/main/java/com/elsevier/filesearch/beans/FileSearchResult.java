package com.elsevier.filesearch.beans;
/**
 * This is a simpl java bean class to store file name
 * that has maximum number of the search word and number
 * of word count in that file
 * @author Abhijit Pritam Dutta
 *
 */
public class FileSearchResult {
	
	String fileName;
	Integer wordFound;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getWordFound() {
		return wordFound;
	}
	public void setWordFound(Integer wordFound) {
		this.wordFound = wordFound;
	}

}

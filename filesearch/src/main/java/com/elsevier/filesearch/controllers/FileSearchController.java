package com.elsevier.filesearch.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.elsevier.filesearch.services.FileSearchServices;

import com.elsevier.filesearch.exception.FileSearchException;
import com.elsevier.filesearch.beans.FileSearchResult;

/**
 * This the controller to handle all the HTTP GET request
 * and generate the appropriate result as response body
 * @author APD
 *
 */

@Controller
public class FileSearchController {
	private static final Logger LOGGER = Logger.getLogger(FileSearchController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/app/search/words/search.json")
	@ResponseBody
	/**
	 * This a method is to handle GET request to generate report
	 * with the name of the file which contains maximum occurance of a word 
	 * provided as query param
	 * @param wordToFind
	 * @return object of type FileSearchServices
	 * @throws FileSearchException
	 */
	public ResponseEntity<FileSearchResult> searchFileAndNumberOfWordInIt(
			@RequestParam(name = "wordToFind", required = true) String wordToFind) throws FileSearchException {

		LOGGER.info("In searchFileAndNumberOfWordInIt");

		FileSearchServices fileSearchServices = new FileSearchServices();

		return fileSearchServices.getFileAndWordCountResult(wordToFind);

	}

}

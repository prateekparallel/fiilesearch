package com.elsevier.filesearch.services;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.elsevier.filesearch.common.config.ApplicationConfig;
import com.elsevier.filesearch.exception.FileSearchException;
import com.elsevier.filesearch.validation.service.imp.FileSearchValidationServices;
import com.elsevier.filesearch.validation.service.imp.Result;
import com.elsevier.filesearch.beans.FileSearchResult;

/**
 * This is a backend service provided class
 * web service utilize this class as service 
 * provided to communicate and execute backend process
 * to generate reports
 * @author prate
 *
 */
public class FileSearchServices {

	private static final Logger LOGGER = Logger.getLogger(FileSearchServices.class);
	/**
	 * Below method is call from controller to execute a backend job
	 * and generate reports. Before calling backend process execution method
	 * it first verify all the parameter which are to be send to backend job.
	 * If it finds any validation issue, it will raised a validation Exception
	 * @param wordToFine
	 * @return ResponseEntity<FileSearchResult> object
	 * @throws FileSearchException
	 */
	public ResponseEntity<FileSearchResult> getFileAndWordCountResult(String wordToFine)  throws FileSearchException{
				
		BackEndServiceManager backEndServiceManager = new BackEndServiceManager();
		ArrayList<String> paramList = null;
		FileSearchResult fresult = null;
		
		try {
			paramList = loadParameterList();
		}catch(FileSearchException e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Exception", e.getMessage());
			responseHeaders.add("Error Code", e.getErrorCode().toString());
			return ResponseEntity.badRequest().headers(responseHeaders).body(null);
		}
		paramList.add(wordToFine);
		
		try {
				String[] args ={ paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3), 
						paramList.get(4), paramList.get(6), paramList.get(5) };
				
				FileSearchValidationServices fileSearchValidationServices = new FileSearchValidationServices();
				
				Result result = fileSearchValidationServices.validateParameters(args);
				if (!result.isAllGood()) {
					HttpHeaders responseHeaders = new HttpHeaders();
					responseHeaders.add("Exception", result.getMessage());
					responseHeaders.add("Error Code", "401");
					return ResponseEntity.badRequest().headers(responseHeaders).body(null);
				}
				
				fresult = backEndServiceManager.processBackEndService(args);
				
		}catch(FileSearchException e) {
			
			throw e;			
		}
		
		return new ResponseEntity<FileSearchResult>(fresult, HttpStatus.OK);
		
	}
	
	/**
	 * Below method load all the necessary parameter lists to backend
	 * process from configuration file 
	 * @return ArrayList<String> object contains all the parameters to back end job
	 * @throws FileSearchException
	 */
	
	private ArrayList<String> loadParameterList() throws FileSearchException{	
		
		ApplicationConfig config = ApplicationConfig.getInstance();
		String executor = config.getExecutorPath();
		String pythonProgram = config.getProgramPath();
		String outPutfile = config.getOutPutFilePath();
		String directoryPath = config.getDirectoryPath();
		String fileNametoSearch = config.getFileNametoSearchPath();
		String fileExtension = config.getFileExtension();
		ArrayList<String> args = new ArrayList<>();
		args.add(executor);
		args.add(pythonProgram);
		args.add(directoryPath);
		args.add(fileNametoSearch);
		args.add(fileExtension);
		args.add(outPutfile);
		return args;		
	}
	
	
}

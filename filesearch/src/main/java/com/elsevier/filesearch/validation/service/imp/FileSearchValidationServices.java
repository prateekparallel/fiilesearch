package com.elsevier.filesearch.validation.service.imp;

import org.apache.log4j.Logger;

import com.elsevier.filesearch.services.FileSearchServices;
import com.elsevier.filesearch.validation.service.FileSearchValidationService;

/**
 * This is a class which implements FileSearchValidationService to
 * facilitates validation service to validate parameters list
 * @author prate
 *
 */
public class FileSearchValidationServices implements FileSearchValidationService {
	
	private static final Logger LOGGER = Logger.getLogger(FileSearchServices.class);

	/**
	 * This method validate all the parameters read from config file
	 * which are to be send as parameters to backend job. Any successful
	 * or unsuccessful reports will be stored in a Result object which
	 * will be use to check the validation status by calling method
	 */
	@Override
	public Result validateParameters(String args[]) {
		
		String executor = args[0];
		String pythonProgram = args[1];
		String directoryPath = args[2];
		String fileNameToSearch = args[3];
		String fileExtension = args[4];
		String wordToFind = args[5];
		String outPutfile = args[6];
		Result result = new Result();
		
		if(executor == null || executor.isEmpty()) {
			result.setMessage("PYTHONPATHEXE must be configured in configuration file");
			result.setStatus(false);
			return result;
		}
		else if( pythonProgram == null || pythonProgram.isEmpty()) {
			result.setMessage("PROGRAMPATH must be configured in configuration file");
			result.setStatus(false);
			return result;
		}
		else if( directoryPath == null || directoryPath.isEmpty()) {
			result.setMessage("DIRECTORY_PATH must be configured in configuration file");
			result.setStatus(false);
			return result;
		}
		else if( wordToFind == null || wordToFind.isEmpty()) {
			result.setMessage("word must be provided in GET call URL");
			result.setStatus(false);
			return result;
		}
		else if( outPutfile == null || outPutfile.isEmpty()) {
			result.setMessage("OUTPUTFILENAME must be configured in configuration file");
			result.setStatus(false);
			return result;
		}
		else if( fileNameToSearch == null || fileNameToSearch.isEmpty()) {
			if( fileExtension == null || fileExtension.isEmpty()) {
				result.setMessage("Either FILENAME or FILETXTENSION must be configured in configuration file");
				result.setStatus(false);
				return result;
			}
		}
		else if( fileExtension == null || fileExtension.isEmpty()) {
			if( fileNameToSearch == null || fileNameToSearch.isEmpty()) {
				result.setMessage("Either FILENAME or FILETXTENSION must be configured in configuration file");
				result.setStatus(false);
				return result;
			}
		}
		result.setMessage("All good");
		result.setStatus(true);
		return result;
	}

	
	
}

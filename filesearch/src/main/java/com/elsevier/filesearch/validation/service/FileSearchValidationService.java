package com.elsevier.filesearch.validation.service;

import com.elsevier.filesearch.validation.service.imp.Result;

/**
 * This is an interface for providing validation service
 * to validate different parameters
 * @author prate
 *
 */

public interface FileSearchValidationService {
	
public Result validateParameters(String args[]);

}

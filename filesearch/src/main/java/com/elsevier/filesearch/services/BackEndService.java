package com.elsevier.filesearch.services;

import com.elsevier.filesearch.beans.FileSearchResult;
import com.elsevier.filesearch.exception.FileSearchException;

/**
 * This is interface for backend service
 * @author APD
 *
 */
public interface BackEndService {
	
	public String runBackEndProcess(String args []) throws Exception;
	
	public FileSearchResult processBackEndService(String args[]) throws FileSearchException;

}

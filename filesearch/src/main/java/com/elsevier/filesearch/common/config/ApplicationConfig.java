package com.elsevier.filesearch.common.config;

/**
 * This is a singletone class to store all the configuration information configured in file
 * application.properties. These config information will be use in the application
 * during run time
 * @author Abhijit Pritam Dutta
 *
 */

public final class ApplicationConfig {

	private String directoryPath;
	String executorPath;
	String programPath;
	String outPutFilePath;
	String fileNametoSearchPath;
	String fileExtension;
	
	private static ApplicationConfig myinstance = null;
	
	/**
	 * This is a static method to return the reference of ApplicationConfig
	 * instance so that only one instance only can be created to avoid 
	 * duplication.
	 * @return myinstance reference of type ApplicationConfig
	 */

	public static ApplicationConfig getInstance() {
		System.out.println("in ApplicationConfig getInstance");
		if (myinstance == null) {
			myinstance = new ApplicationConfig();
		}
		return myinstance;
	}

	private ApplicationConfig() {

	}	

	public String getDirectoryPath() {
		return directoryPath;
	}

	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}

	public String getExecutorPath() {
		return executorPath;
	}

	public void setExecutorPath(String executorPath) {
		this.executorPath = executorPath;
	}

	public String getProgramPath() {
		return programPath;
	}

	public void setProgramPath(String programPath) {
		this.programPath = programPath;
	}

	public String getOutPutFilePath() {
		return outPutFilePath;
	}

	public void setOutPutFilePath(String outPutFilePath) {
		this.outPutFilePath = outPutFilePath;
	}

	public String getFileNametoSearchPath() {
		return fileNametoSearchPath;
	}

	public void setFileNametoSearchPath(String fileNametoSearchPath) {
		this.fileNametoSearchPath = fileNametoSearchPath;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

}

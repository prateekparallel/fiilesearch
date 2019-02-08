package com.elsevier.filesearch.common.config;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import com.elsevier.filesearch.in.filter.FileSearchInFilter;

/*
 * This class will be instantiated by spring framework 
 * at the very beginning of of web service being loaded
 * This class is used to reading the config file and store
 * each config value into ApplicationConfig
 */

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties
public class InitConfig {
	@Autowired
	private Environment env;

	@PostConstruct
	public void init() {
		initConfig();
		System.out.println("Initialized");
	}

	@Bean
	public static ApplicationConfig applicationConfig() {
		return ApplicationConfig.getInstance();
	}

	@Bean
	public FilterRegistrationBean<FileSearchInFilter> infilterRegistrationBean() {
		FilterRegistrationBean<FileSearchInFilter> registrationBean = new FilterRegistrationBean();
		FileSearchInFilter fileSearchInFilter = new FileSearchInFilter();

		registrationBean.setFilter(fileSearchInFilter);
		registrationBean.addUrlPatterns("/app/*");
		registrationBean.setOrder(1);
		return registrationBean;
	}

	public InitConfig() {
	}

	public void initConfig() {

		System.out.println("initConfig - CommonConfig");
		String logPropertyFilePath = env.getProperty("LOG_PROPERTY_FILE_PATH");
		System.out.println(logPropertyFilePath);

		ApplicationConfig ac = ApplicationConfig.getInstance();
		ac.setDirectoryPath(env.getProperty("DIRECTORY_PATH"));
		ac.setExecutorPath(env.getProperty("PYTHONPATHEXE"));
		ac.setFileExtension(env.getProperty("FILETXTENSION"));
		ac.setFileNametoSearchPath(env.getProperty("FILENAME"));
		ac.setOutPutFilePath(env.getProperty("OUTPUTFILENAME"));
		ac.setProgramPath(env.getProperty("PROGRAMPATH"));

		if (logPropertyFilePath != null) {
			System.out.println("Loading log properties file: " + logPropertyFilePath);
			PropertyConfigurator.configure(logPropertyFilePath);
		} else {
			System.out.println("Called BasicConfigurator.configure()");
			BasicConfigurator.configure();
		}
	}

}

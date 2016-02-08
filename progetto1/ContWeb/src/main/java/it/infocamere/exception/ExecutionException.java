package it.infocamere.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.util.Clients;

public class ExecutionException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(ExecutionException.class);
	public ExecutionException(){
		super();
		writeStacktraceToLog();
		
	}
	
	
	public ExecutionException(Exception exc){
		super(exc);
		writeStacktraceToLog(exc);
	
		
	}
	public ExecutionException(String exc){
		super(exc);
		logger.error(exc);
		writeStacktraceToLog();
		
	}
	
	private void writeStacktraceToLog(Exception exc){
		StringWriter writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter( writer );
		exc.printStackTrace( printWriter );
		printWriter.flush();
		String stackTrace = writer.toString();
		logger.error(stackTrace);
		writeStacktraceToLog();
	}
	private void writeStacktraceToLog(){
		StringWriter writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter( writer );
		this.printStackTrace( printWriter );
		printWriter.flush();
		String stackTrace = writer.toString();
		logger.error(stackTrace);
	}
}

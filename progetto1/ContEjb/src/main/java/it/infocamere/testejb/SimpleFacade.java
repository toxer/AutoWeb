package it.infocamere.testejb;

import it.infocamere.SimpleRemote.SimpleRemoteInterface;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless
public class SimpleFacade implements SimpleRemoteInterface{
	Logger logger = Logger.getLogger(SimpleFacade.class);
	public String SimpleTestCall(){
		logger.info("EJB Success");
		return "Success";
	}
}

package it.infocamere.navbar;

import org.apache.log4j.Logger;
import org.zkoss.bind.annotation.Init;

public class NavbarModel {
	
	
	Logger logger = Logger.getLogger(NavbarModel.class);
	@Init
	public void init(){
		logger.info("Init model completed");
	}
	
	
	
	
}

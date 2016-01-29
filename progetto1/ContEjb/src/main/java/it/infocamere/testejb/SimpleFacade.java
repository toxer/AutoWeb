package it.infocamere.testejb;

import it.infocamere.SimpleRemote.SimpleRemoteInterface;

import javax.ejb.Stateless;

@Stateless
public class SimpleFacade implements SimpleRemoteInterface{
	public String SimpleTestCall(){
		return "Success";
	}
}

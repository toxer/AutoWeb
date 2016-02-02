package it.infocamere.service;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class HelloWorldResource extends ServerResource {
	@Override
	protected Representation post(Representation entity)
			throws ResourceException {
		System.out.println("post Method");
		return super.post(entity);

	}
	
	@Override
	protected Representation get() throws ResourceException {
		System.out.println("get method");
		return super.get();
	}
	@Get
	public String getString(){
		return "test";
	}

}

package it.infocamere.test;

import it.infocamere.SimpleRemote.SimpleRemoteInterface;
import it.infocamere.exception.ExecutionException;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Panel;

public class EjbTestController extends SelectorComposer<Panel> {
	Logger logger = Logger.getLogger(EjbTestController.class);
	@Wire
	Label label;

	public void doAfterCompose(Panel comp) {
		try {
			super.doAfterCompose(comp);
			

			Properties jndiProps = new Properties();
			jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jboss.naming.remote.client.InitialContextFactory");
			jndiProps.put(Context.PROVIDER_URL, System.getProperty(
					Context.PROVIDER_URL, "remote://localhost:4447"));
//			jndiProps.put(Context.SECURITY_PRINCIPAL,
//					System.getProperty("username", "admin"));
//			jndiProps.put(Context.SECURITY_CREDENTIALS,
//					System.getProperty("password","admin1234*"));
			// create a context passing these properties
			Context ctx = new InitialContext(jndiProps);

			SimpleRemoteInterface sri = (SimpleRemoteInterface) ctx
					.lookup("ejb:Test/ContEjb/SimpleFacade!it.infocamere.SimpleRemote.SimpleRemoteInterface");
			
			
			
			
			label.setValue(sri.SimpleTestCall());
		} catch (Exception exc) {
			throw new ExecutionException(exc);
		}
	}

}

package com.mx.sga.conectoresEJB;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConectorEJBWeblogic implements ConectorEJB{
	
	public ConectorEJBWeblogic() {
	}
	
	public Context InicializarContexto(){
		propiedades_EJB.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
		propiedades_EJB.put("java.naming.provider.url", "t3://192.168.1.72:7001");
		propiedades_EJB.put("java.naming.security.principal","weblogic");
		propiedades_EJB.put("java.naming.security.credentials","hipersp31");
		try {
			return new InitialContext(propiedades_EJB);
		} catch (NamingException e) {
			System.out.println("no se ha podido iniciar el Contexto: "+e);
			e.printStackTrace();
			return null;
		}
	}
}

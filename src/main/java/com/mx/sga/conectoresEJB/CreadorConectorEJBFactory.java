package com.mx.sga.conectoresEJB;

public class CreadorConectorEJBFactory extends ConectorEJBFactory{

	public ConectorEJB ObtenerConectorEJB(String servidor) {
		if(servidor.equals("weblogic")) 
			return new ConectorEJBWeblogic();
		if(servidor.equals("was"))
			return new ConectorEJBWAS();
		if(servidor.equals("jboss"))
			return new ConectorEJBJBoss();
		
		return null;
	}

}

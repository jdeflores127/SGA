package com.mx.sga.conectoresEJB;

import java.util.Hashtable;

import javax.naming.Context;

public interface ConectorEJB {
	Hashtable propiedades_EJB=new Hashtable();

	public Context InicializarContexto();
}

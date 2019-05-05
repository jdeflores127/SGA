package com.mx.sga.conectoresEJB;

public abstract class ConectorEJBFactory {
	
	public abstract ConectorEJB ObtenerConectorEJB(String Servidor);
}

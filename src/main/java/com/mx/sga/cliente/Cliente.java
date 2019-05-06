package com.mx.sga.cliente;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import com.mx.sga.conectoresEJB.ConectorEJB;
import com.mx.sga.conectoresEJB.ConectorEJBFactory;
import com.mx.sga.conectoresEJB.CreadorConectorEJBFactory;
import com.mx.sga.entidades.Persona;
import com.mx.sga.servicios.PersonaEJBRemote;

public class Cliente {
	public static void main(String[] args) {
		String servidor="weblogic";
		ConectorEJBFactory factory=new CreadorConectorEJBFactory();
		ConectorEJB con=factory.ObtenerConectorEJB(servidor);
		Context ctx=con.InicializarContexto();
		try {
			System.out.println("entra a la aplicacion");
			PersonaEJBRemote persona= (PersonaEJBRemote) ctx.lookup("java:global/SGA-0.0.1-SNAPSHOT/PersonaEJBBean!com.mx.sga.servicios.PersonaEJBRemote");
			//Crear nuevo Objeto
			Persona persistir=new Persona("Mariana", "Picapiedra", "Solis", "11673456", "holi@gmail.com");
			persona.registrarPersona(persistir);
			List<Persona> personasList=persona.listarPersonas();
			if(personasList==null || personasList.size()==0) {
				System.out.println("no hay registros de personas");
			}
			for(Persona p: personasList)
			{
				System.out.print(p.getNombre()+" ");
				System.out.print(p.getApPaterno()+" ");
				System.out.print(p.getApMaterno()+" ");
				System.out.print(p.getTelefono()+" ");
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("Error en el nombre JNDI: "+e);
			e.printStackTrace();
		}
	}
}

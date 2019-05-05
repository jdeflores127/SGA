package com.mx.sga.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mx.sga.CapaDatos.DAO.PersonaDAO;
import com.mx.sga.entidades.Persona;

@Stateless
public class PersonaEJBBean implements PersonaEJBRemote{
	PersonaDAO personaDAO=new PersonaDAO();
	
	public List<Persona> listarPersonas() {
		return personaDAO.obtenerTodasPersonas();
	}

	public Persona encontrarPersonaPorId(int idPersona) {
		return personaDAO.obtenerPorId(idPersona);
	}

	public Persona encontrarPersonaPorEmail(int idPersona) {
		return personaDAO.obtenerPorEmail(idPersona);
	}

	public void registrarPersona(Persona p) {
		personaDAO.insertPersona(p);	
	}

	public void ModificarPersona(Persona p) {
		personaDAO.updatePersona(p);
	}

	public void EliminarPersona(Persona p) {
		personaDAO.deletePersona(p);
	}

	public Persona encontrarPersonaPorId(Persona p) {
		// TODO Auto-generated method stub
		return null;
	}

	public Persona encontrarPersonaPorEmail(Persona p) {
		// TODO Auto-generated method stub
		return null;
	}
}

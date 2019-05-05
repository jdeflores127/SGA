package com.mx.sga.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.mx.sga.entidades.Persona;

@Remote
public interface PersonaEJBRemote {
	public List<Persona> listarPersonas();
	public Persona encontrarPersonaPorId(int idPersona);
	public Persona encontrarPersonaPorEmail(int idPersona);
	public void registrarPersona(Persona p);
	public void ModificarPersona(Persona p);
	public void EliminarPersona(Persona p);
}

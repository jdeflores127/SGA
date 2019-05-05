package com.mx.sga.CapaDatos.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mx.sga.entidades.Persona;
public class PersonaDAO {
	@PersistenceContext(unitName="PersonaPU")
	EntityManager em;

	public PersonaDAO(){
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> obtenerTodasPersonas()
	{
		return em.createNamedQuery("Persona.findAll").getResultList();
	}
	public Persona obtenerPorId(int idPersona) {
		return em.find(Persona.class, idPersona);
	}
	public Persona obtenerPorEmail(int idPersona) {
		Query query= em.createQuery("from persona p where p.email = :email");
		query.setParameter("email", idPersona);
		return (Persona) query.getSingleResult();
	}
	public void insertPersona(Persona persona) {
		em.persist(persona);
	}
	public void updatePersona(Persona persona) {
		//si el objeto persona no está en una transaccion, lo pone y revisa si existe diferencia entre el objeto y en la bd
		em.merge(persona);
	}
	public void deletePersona(Persona persona) {
		//lo obtiene en memoria y despues lo remueve
		em.merge(persona);
		em.remove(persona);
	}
}

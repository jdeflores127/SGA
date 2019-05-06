package com.mx.sga.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mx.sga.entidades.Persona;

@Stateless
public class PersonaEJBBean implements PersonaEJBRemote{	
	@PersistenceContext(unitName="PersonaPU")
	EntityManager em;
		
	public List<Persona> listarPersonas() {
		List<Persona> personasLista=em.createNamedQuery("Persona.findAll").getResultList();
		return personasLista;	
	}

	public Persona encontrarPersonaPorId(int idPersona) {
		return em.find(Persona.class, idPersona);
	}

	public Persona encontrarPersonaPorEmail(int idPersona) {
		Query query= em.createQuery("from persona p where p.email = :email");
		query.setParameter("email", idPersona);
		return (Persona) query.getSingleResult();
	}

	public void registrarPersona(Persona p) {
		System.out.println(p.toString());
		em.persist(p);
	}

	public void ModificarPersona(Persona p) {
		em.merge(p);
	}

	public void EliminarPersona(Persona p) {
		em.merge(p);
		em.remove(p);
	}
}

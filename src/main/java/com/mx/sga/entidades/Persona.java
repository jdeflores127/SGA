package com.mx.sga.entidades;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@Entity
@NamedQueries({@NamedQuery(name="Persona.findAll",query="select p FROM Persona p ORDER BY p.idPersona")})
public class Persona implements Serializable{
	public static final long serialVersionUID=6529685098267757690L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Persona")
	private int idPersona;
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;
	@Column(name="apellido_Paterno", length=50)
	private String apPaterno;
	@Column(name="apellido_Materno", length=50)
	private String apMaterno;
	@Column(name="telefono", length=10)
	private String telefono;
	@Column(name="email", length=20)
	private String email;
	
	public Persona(){
	}
	
	public Persona(int idPersona, String nombre, String apPaterno, String apMaterno, String telefono, String email) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.telefono = telefono;
		this.email=email;
	}
	public Persona(String nombre, String apPaterno, String apMaterno, String telefono, String email) {
		super();
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.telefono = telefono;
		this.email=email;
	}	

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apPaterno=" + apPaterno + ", apMaterno="
				+ apMaterno + ", telefono=" + telefono + ", email=" + email + "]";
	}	
	
}

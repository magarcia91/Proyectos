package com.email.sender.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="email1")
public class Email1 {
		 
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String to;
    private String email;
    private String nombre;
    private String mensaje;
    
        
	public Email1() {
		super();		
	}


	public Email1(long id, String to, String email, String nombre, String mensaje) {
		super();
		this.id = id;
		this.to = to;
		this.email = email;
		this.nombre = nombre;
		this.mensaje = mensaje;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	

}

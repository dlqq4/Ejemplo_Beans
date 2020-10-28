package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;






@Entity
@NamedQuery(name="Departamento.obtenerTodos", query="SELECT d FROM Departamento d")


public class Departamento implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
//***************DEFINO CLAVE PRINCIPAL PARA LA ENTIDAD DEPARTAMENTOS*************	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=40) private String nombre;
	
//********************************************************************************
		
	public Departamento() {
		super();
	}
	
//*****************************GETTERS**AND**SETTERS******************************
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
	
//*********************************************************************************	
	
   
}

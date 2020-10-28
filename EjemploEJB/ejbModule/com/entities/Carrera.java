package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Carrera
 *
 */
@Entity
public class Carrera implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
//*****************************************************************	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=40, unique=true)
	private String nombre;
	
	@ManyToOne(optional=false)
	private Departamento departamento;
	
	@OneToMany
	private List<Materia> materias = new ArrayList<>();
	
//*****************************************************************
	
	public Carrera() {
		super();
	} 
	
//********************GETTERS AND  SETTERS*************************
	
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	
	
   
}

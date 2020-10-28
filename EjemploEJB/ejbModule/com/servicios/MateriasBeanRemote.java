package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Materia;
import com.exception.ServiciosException;

@Remote
public interface MateriasBeanRemote {

	 void crear(Materia materia) throws ServiciosException;
	 
	 void actualizar(Materia materia) throws ServiciosException;
	 
	 void borrar(Long id) throws ServiciosException;
	 
	 List<Materia> obtenerTodos();
	 
	 List<Materia> obtenerTodos(String filtro);
}

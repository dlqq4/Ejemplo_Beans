package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Carrera;
import com.exception.ServiciosException;

@Remote
public interface CarrerasBeanRemote {
	
	void crearCarrera(String nombre, Long idDepartamento) throws ServiciosException;
	
	void asignarDepartamento(Long idCarrera, Long idDepartamento) throws ServiciosException;
	
	 void asignarMateria(Long idCarrera, Long idMateria) throws ServiciosException;
	 
	 List<Carrera> obtenerPorDepartamento(String departamento);
	 

}

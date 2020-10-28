package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Departamento;
import com.exception.ServiciosException;



@Remote
public interface DepartamentosBeanRemote {
	
	void crear (Departamento departamento) throws ServiciosException;
	
	void actualizar  (Departamento departamento) throws ServiciosException;
	
	void borrar (Long id) throws ServiciosException;
	
	List <Departamento> obtenertodos();
	
	List <Departamento> obtenertodoss();
	
	List <Departamento> obtnerTodos (String filtro);
	

}

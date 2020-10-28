package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Carrera;
import com.entities.Departamento;
import com.entities.Materia;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class CarrerasBean
 */
@Stateless
public class CarrerasBean implements CarrerasBeanRemote {
		
	@PersistenceContext
	private EntityManager em;
  
    public CarrerasBean() {
        
    }

	@Override
	public void crearCarrera(String nombre, Long idDepartamento) throws ServiciosException {
		
		 try{ 
			 Carrera carrera = new Carrera();
			 carrera.setNombre(nombre);
			 carrera.setDepartamento(em.find(Departamento.class, idDepartamento));
			 em.persist(carrera);
			 em.flush();
			  }catch(PersistenceException e){
			 throw new ServiciosException("No se pudo crear la carrera");
			  } 
	}

	@Override
	public void asignarDepartamento(Long idCarrera, Long idDepartamento) throws ServiciosException {
		
		try{
			Carrera carrera = em.find(Carrera.class, idCarrera);
			carrera.setDepartamento(em.find(Departamento.class, idDepartamento));
			em.flush();
			 }catch(PersistenceException e){
			throw new ServiciosException("No se pudo asignar el departamento a la carrera");
			 }
		
	}

	@Override
	public void asignarMateria(Long idCarrera, Long idMateria) throws ServiciosException {
		
		try{
			Carrera carrera = em.find(Carrera.class, idCarrera);
			carrera.getMaterias().add(em.find(Materia.class, idMateria));
			em.flush();
			 }catch(PersistenceException e){
			throw new ServiciosException("No se pudo asignar la materia a la carrera"); 
			 } 
		
	}

	@Override
	public List<Carrera> obtenerPorDepartamento(String departamento) {
		
		TypedQuery<Carrera> query = em.createQuery("SELECT c FROM Carrera c WHERE c.departamento.nombre LIKE :depto",Carrera.class).setParameter("depto", departamento);                                             
				 
		return query.getResultList();
		
	}

}

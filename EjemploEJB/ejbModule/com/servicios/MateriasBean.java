package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import com.entities.Materia;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class MateriasBean
 */
@Stateless
public class MateriasBean implements MateriasBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
	
    public MateriasBean() {        
    }

	@Override
	public void crear(Materia materia) throws ServiciosException {
		
		try {
    		em.persist(materia);
    		em.flush();
       	}catch(PersistenceException e) {
       		throw new ServiciosException("No se pudo crear la materia");     
       	}
		
	}

	@Override
	public void actualizar(Materia materia) throws ServiciosException {

		try{
			em.merge(materia); 
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar la materia");
		}
		
	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		try{
			Materia materia = em.find(Materia.class, id);
			em.remove(materia);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar la materia");
		} 
		
	}

	@Override
	public List<Materia> obtenerTodos() {
		TypedQuery<Materia> query = em.createQuery("SELECT d FROM Materia d",Materia.class);
		
		 return query.getResultList();
		
	}

	@Override
	public List<Materia> obtenerTodos(String filtro) {
		TypedQuery<Materia> query = em.createQuery("SELECT d FROM Departamento d WHERE d.nombre LIKE :nombre",Materia.class).setParameter("nombre", filtro);                            
		return query.getResultList();
	}

}

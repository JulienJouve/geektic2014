package com.ninja_squad.geektic.DAO;

import java.util.*;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.beans.CentreInteret;
import com.ninja_squad.geektic.beans.Geek;

@Repository
public class GeekDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Geek> getGeeks()
	{
        TypedQuery<Geek> query = em.createQuery("SELECT g from Geek as g", Geek.class);
        System.out.println("lkjgbpkug" + query.getResultList().get(0) );
        return query.getResultList();
    }
	
	public List<Geek> getGeeksByCriteria(String s, String i)
	{	
		TypedQuery<Geek> query = em.createQuery("SELECT distinct g from Geek as g left join fetch g.centresInteret inner join g.centresInteret as ci where g.sexe=:sexe and ci.interet=:interet", Geek.class);
        
        return query.setParameter("sexe", s).setParameter("interet", i).getResultList();
	}
	
	public List<CentreInteret> getAllInterets()
	{
		TypedQuery<CentreInteret> query = em.createQuery("SELECT c from CentreInteret as c", CentreInteret.class);
		return query.getResultList();
	}
}

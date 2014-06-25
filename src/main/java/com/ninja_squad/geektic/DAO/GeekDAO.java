package com.ninja_squad.geektic.DAO;

import java.util.*;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	public List<Geek> getGeeksBySex(String s)
	{	
		TypedQuery<Geek> query = em.createQuery("SELECT g from Geek as g left join fetch g.centresInteret where g.sexe=:sexe", Geek.class);
        
        return query.setParameter("sexe", s).getResultList();
	}
	
	public List<CentreInteret> getAllInterets()
	{
		TypedQuery<CentreInteret> query = em.createQuery("SELECT c from CentreInteret as c", CentreInteret.class);
		return query.getResultList();
	}
}

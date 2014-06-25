package com.ninja_squad.geektic.dao;

import java.util.*;

import com.ninja_squad.geektic.DAO.GeekDAO;
import com.ninja_squad.geektic.beans.Geek;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.*;


public class GeekDaoTest extends BaseDaoTest {
	
	@Autowired
	private GeekDAO gDao;
   

	@Test
    public void testGenreGetGeekByCriteria() {
       List<Geek> result = gDao.getGeeksByCriteria("M", "Sport");
       Assert.assertEquals("M", result.get(0).sexe);
    }
	
	@Test
    public void testInteretGetGeekByCriteria() {
		int valeurAttendu = 3; // Il y à 3 hommes dans la base qui aiment le cinéma
       List<Geek> result = gDao.getGeeksByCriteria("M", "Cinema");
       Assert.assertEquals(result.size(), valeurAttendu);
    }
}

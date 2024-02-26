package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.dto.FoodOrder;
import com.jsp.foodapp.dto.Item;

@Repository
public class ItemDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	public List<Item> fetchItem(){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select i from Item i");
		return query.getResultList();
	}
}

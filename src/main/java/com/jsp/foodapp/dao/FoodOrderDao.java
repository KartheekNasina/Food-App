package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.dto.FoodOrder;
import com.jsp.foodapp.dto.Product;

@Repository
public class FoodOrderDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	public List<FoodOrder> fetchFoodOrder(){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select f from FoodOrder f");
		return query.getResultList();
	}
}

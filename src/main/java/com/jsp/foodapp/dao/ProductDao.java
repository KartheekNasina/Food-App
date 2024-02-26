package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.dto.Product;
import com.jsp.foodapp.dto.User;

@Repository
public class ProductDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	public void saveProduct(Product product) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
	}
	public List<Product> fetchAllProducts(){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select p from Product p");
		return query.getResultList();
	}
	public Product findById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager.find(Product.class, id);
	}
	public void updateProduct(Product product) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(product);
		entityTransaction.commit();
	}
	public void deleteProduct(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Product product = entityManager.find(Product.class, id);
		entityTransaction.begin();
		entityManager.remove(product);
		entityTransaction.commit();
	}
}

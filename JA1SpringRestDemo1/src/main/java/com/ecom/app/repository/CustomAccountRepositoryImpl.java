package com.ecom.app.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.ecom.app.entity.Account;

public class CustomAccountRepositoryImpl implements CustomAccountRepository {

	@Autowired
	EntityManager entityManager;  // as a Session in Hibernate
	
	@Override
	public List<Account> getAccountsByCity(String cityName) {
		
		Session session = entityManager.unwrap(Session.class);
		// select * from AccountTable where cityName = 'dffd';
		String queryString = "from Account a where a.address.cityName=:cityName";
		
		Query<Account> query = session.createQuery(queryString);
		query.setString("cityName", cityName);
		
		List<Account>  list = (List<Account>) query.getResultList();
		
		// code to fetch data from DB using JPQL
		
		if(list != null)
		{
			return list;
		}
		else
		{
			throw new javax.persistence.NoResultException("City Name Records Not In The DB");
		}
	}

}

package com.phonebook.data.repositories;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phonebook.data.domains.Contact;

@Repository
public class ContactsRepositoryImpl implements ContactsRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public Contact getItemById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Contact item) {
		sessionFactory.getCurrentSession().save(item);
	}

	@Override
	public void remove(Contact item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Contact> getItems(Integer page, Integer rowsPerPage) {
		return this.getItems(page, rowsPerPage, "");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Contact> getItems(Integer page, Integer rowsPerPage, String searchCriteria) {

      TypedQuery<Contact> query = null;
      if (searchCriteria!= null && searchCriteria.length() > 0) {
    	  query = sessionFactory.getCurrentSession().createQuery("SELECT c FROM Contact c WHERE c.firstName LIKE :criteria OR c.lastName LIKE :criteria")
    			  .setParameter("criteria", searchCriteria);
      } else {
    	  query = sessionFactory.getCurrentSession().createQuery("from Contact");
      }
      
      query.setFirstResult(--page);
      query.setMaxResults(rowsPerPage);
      
      return query.getResultList();
	}

}

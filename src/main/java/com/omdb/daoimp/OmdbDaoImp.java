package com.omdb.daoimp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.omdb.dao.imp.OmdbDao;
import com.omdb.entity.UserOmdbEntity;

@Repository
@Transactional
public class OmdbDaoImp implements OmdbDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void save(UserOmdbEntity userOmdbEntity) {
		// TODO Auto-generated method stub
		entityManager.persist(userOmdbEntity);
	}

}

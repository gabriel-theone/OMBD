package com.omdb.dao.imp;

import com.omdb.entity.UserOmdbEntity;

public interface OmdbDao {

	void save(UserOmdbEntity userOmdbEntity) throws Exception;
}

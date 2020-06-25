package com.omdb.usecase;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.omdb.dao.imp.OmdbDao;
import com.omdb.dto.OMDB;
import com.omdb.dto.RequestOmdbDto;
import com.omdb.entity.UserOmdbEntity;
import com.omdb.web.client.ClientApiOmdb;

@Service
public class OmdbUseCase {

	@Autowired
	private OmdbDao omdbDao;

	@Autowired
	private ClientApiOmdb clientApiOmdb;

	public ResponseEntity<String> guardarOmdb(RequestOmdbDto requestOmdbDto) {
		OMDB omdb = clientApiOmdb.getOMDB(requestOmdbDto.getTitle());
		UserOmdbEntity userOmdbEntity = wrapper(requestOmdbDto, omdb);
		ResponseEntity<String> response;
		try {
			omdbDao.save(userOmdbEntity);
			response = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return response;
	}

	public UserOmdbEntity wrapper(RequestOmdbDto requestOmdbDto, OMDB omdb) {
		UserOmdbEntity userOmdbEntity = new UserOmdbEntity();
		userOmdbEntity.setFecha(new Timestamp(System.currentTimeMillis()));
		userOmdbEntity.setComentarios(requestOmdbDto.getComentarios());
		userOmdbEntity.setRating(requestOmdbDto.getRating());
		userOmdbEntity.setImdbId(omdb.getImdbID());
		return userOmdbEntity;
	}

}

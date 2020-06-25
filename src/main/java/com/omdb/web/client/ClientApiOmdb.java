package com.omdb.web.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.omdb.dto.OMDB;

@Service
public class ClientApiOmdb {

	@Value("${url.omdb.api}")
	private String url;

	public OMDB getOMDB(String title) {

		RestTemplate plantilla = new RestTemplate();
		url = url.replace("{title}", title);
		ResponseEntity<OMDB> response = plantilla.getForEntity(url, OMDB.class);

		return response.getBody();
	}
}

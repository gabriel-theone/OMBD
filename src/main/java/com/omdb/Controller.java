package com.omdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.omdb.dto.RequestOmdbDto;
import com.omdb.usecase.OmdbUseCase;
import com.omdb.web.client.ClientApiOmdb;

@RestController
public class Controller {

	@Autowired
	private ClientApiOmdb clientApiOmdb;

	@Autowired
	private OmdbUseCase omdbUseCase;

	@GetMapping(value = "search/{title}")
	public ResponseEntity<?> getOmdb(@PathVariable(name = "title") String title) {

		return new ResponseEntity<>(clientApiOmdb.getOMDB(title), HttpStatus.OK);
	}

	@PutMapping(value = "ratingusuario")
	public ResponseEntity<String> ratingusuario(@RequestBody RequestOmdbDto requestOmdbDto) {
		return omdbUseCase.guardarOmdb(requestOmdbDto);
	}

}

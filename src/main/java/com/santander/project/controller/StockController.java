package com.santander.project.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santander.project.model.dto.StockDTO;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
		return ResponseEntity.ok(dto);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
		return ResponseEntity.ok(dto);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDTO>> findAll(){
		List<StockDTO> list = new ArrayList<>();
		StockDTO dto = new StockDTO();
		dto.setId(1L);
		dto.setName("Magazine Luiza");
		dto.setPrice(100D);
		dto.setVariation(10D);
		dto.setDate(LocalDate.now());
		list.add(dto);		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> findById(@PathVariable Long id){
		
		List<StockDTO> list = new ArrayList<>();
		
		StockDTO dto = new StockDTO();
		dto.setId(1L);
		dto.setName("Magazine Luiza");
		dto.setPrice(100D);
		dto.setVariation(10D);
		dto.setDate(LocalDate.now());

		StockDTO dto2 = new StockDTO();
		dto2.setId(2L);
		dto2.setName("Ponto Frio");
		dto2.setPrice(200D);
		dto2.setVariation(5D);
		dto2.setDate(LocalDate.now());
		
		list.add(dto);
		list.add(dto2);
		
		StockDTO dtoSelect = list.stream().filter(x -> x.getId().compareTo(id) == 0).findFirst().get();
		return ResponseEntity.ok(dtoSelect);
	}
	
	
}

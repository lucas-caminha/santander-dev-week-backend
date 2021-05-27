package com.santander.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santander.project.model.dto.StockDTO;
import com.santander.project.service.StockService;

@CrossOrigin
@RestController
@RequestMapping(value = "/stock")
public class StockController {
	
	@Autowired
	private StockService stockService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
		StockDTO savedDTO = stockService.save(dto);	
		return ResponseEntity.ok(savedDTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
		StockDTO updatedDTO = stockService.update(dto);
		return ResponseEntity.ok(updatedDTO);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDTO>> findAll(){	
		return ResponseEntity.ok(stockService.findAll());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> findById(@PathVariable Long id){
		StockDTO stockSelected = stockService.findById(id);
		return ResponseEntity.ok(stockSelected)	;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> delete(@PathVariable Long id){
		return ResponseEntity.ok(stockService.delete(id));
	}
	
	@RequestMapping(value = "/today" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDTO>> findByToday(){
		return ResponseEntity.ok(stockService.findByToday());
	}
	
}

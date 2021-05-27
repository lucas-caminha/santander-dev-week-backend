package com.santander.project.mapper;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.santander.project.model.Stock;
import com.santander.project.model.dto.StockDTO;

@Component
public class StockMapper {

	public Stock toEntity(@Valid StockDTO dto) {
		Stock stock = new Stock();
		
		stock.setId(dto.getId());
		stock.setName(dto.getName());
		stock.setPrice(dto.getPrice());
		stock.setVariation(dto.getVariation());
		stock.setDate(dto.getDate());
		
		return stock;
	}

	public StockDTO toDto(Stock stock) {
		StockDTO dto = new StockDTO();
		
		dto.setId(stock.getId());
		dto.setName(stock.getName());
		dto.setPrice(stock.getPrice());
		dto.setVariation(stock.getVariation());
		dto.setDate(stock.getDate());
		
		return dto;
	}

	
}

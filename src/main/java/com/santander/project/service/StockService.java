package com.santander.project.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santander.project.exceptions.BusinessException;
import com.santander.project.mapper.StockMapper;
import com.santander.project.model.Stock;
import com.santander.project.model.dto.StockDTO;
import com.santander.project.repository.StockRepository;
import com.santander.project.util.MessageUtils;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepo;
	
	@Autowired
	private StockMapper stockMapper;
	
	@Transactional
	public StockDTO save(@Valid StockDTO dto) {
		Optional<Stock> optionalStock = stockRepo.findByNameAndDate(dto.getName(), dto.getDate());
		if(optionalStock.isPresent()) {
			throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
		}
		Stock stock = stockMapper.toEntity(dto);
		stockRepo.save(stock);
		return stockMapper.toDto(stock);
	}
	
	

	
}

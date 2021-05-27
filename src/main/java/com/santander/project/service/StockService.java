package com.santander.project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santander.project.exceptions.BusinessException;
import com.santander.project.exceptions.NotFoundException;
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

	@Transactional
	public StockDTO update(@Valid StockDTO dto) {
		Optional<Stock> optionalStock = stockRepo.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());
		if(optionalStock.isPresent()) {
			throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
		}
		Stock stock = stockMapper.toEntity(dto);
		stockRepo.save(stock);
		return stockMapper.toDto(stock);
	}

	@Transactional(readOnly = true)
	public List<StockDTO> findAll() {
		return stockMapper.toDto(stockRepo.findAll());
	}

	@Transactional(readOnly = true)
	public StockDTO findById(Long id) { 
		return stockRepo.findById(id).map(stockMapper::toDto).orElseThrow(NotFoundException::new);
	}

	@Transactional
	public StockDTO delete(Long id) {
		StockDTO StockSelected = this.findById(id);
		stockRepo.deleteById(StockSelected.getId());
		return StockSelected;
	}

	public List<StockDTO> findByToday() {	
		return stockRepo.findByToday(LocalDate.now()).map(stockMapper::toDto).orElseThrow(NotFoundException::new);
	}
	

	

	
}

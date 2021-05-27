package com.santander.project.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santander.project.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

	Optional<Stock> findByNameAndDate(String name, LocalDate date);

}

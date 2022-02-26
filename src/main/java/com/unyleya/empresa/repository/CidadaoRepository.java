package com.unyleya.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unyleya.empresa.model.Cidadaos;


@Repository
public interface CidadaoRepository extends JpaRepository<Cidadaos, Long >{
	
}






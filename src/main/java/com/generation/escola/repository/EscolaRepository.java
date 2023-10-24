package com.generation.escola.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.escola.model.Escola;


@Repository
public interface EscolaRepository extends JpaRepository <Escola,Long>{

}

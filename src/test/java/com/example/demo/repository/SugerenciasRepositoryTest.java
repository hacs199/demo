package com.example.demo.repository;

import com.example.demo.AbstractIntegrationDBTest;
import com.example.demo.entities.Sugerencias;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.junit.jupiter.api.Assertions.*;

class SugerenciasRepositoryTest extends AbstractIntegrationDBTest {

    SugerenciasRepository sugerenciasRepository;

    @Autowired
    public SugerenciasRepositoryTest(SugerenciasRepository sugerenciasRepository){
        this.sugerenciasRepository = sugerenciasRepository;
    }

}
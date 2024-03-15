package com.example.demo.repository;

import com.example.demo.AbstractIntegrationDBTest;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

class SugerenciaRepositoryTest extends AbstractIntegrationDBTest {

    SugerenciaRepository sugerenciaRepository;

    @Autowired
    public SugerenciaRepositoryTest(SugerenciaRepository sugerenciaRepository){
        this.sugerenciaRepository = sugerenciaRepository;
    }
    @BeforeEach
    void setUp() {
    }
}
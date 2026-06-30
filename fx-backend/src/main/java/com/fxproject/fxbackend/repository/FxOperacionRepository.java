package com.fxproject.fxbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FxOperacionRepository extends JpaRepository<FxOperacion, Integer> {
    public List<FxOperacion> findAllByEstado(String estado);
}

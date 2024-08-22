package com.app.farm.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantationRepository extends JpaRepository<Plantation,Long> {

    List<Plantation> findByIdAndName(String id,String name);
}
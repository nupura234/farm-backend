package com.app.farm.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlotRepository extends JpaRepository<Plot,Long> {

    List<Plot> findByIdAndArea(String id,String area);
}

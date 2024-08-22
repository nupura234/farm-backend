package com.app.farm.model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//DAO
public interface TreeRepository extends JpaRepository<Tree,Long> {

    List<Tree> findByIdAndName(String id,String name);


}
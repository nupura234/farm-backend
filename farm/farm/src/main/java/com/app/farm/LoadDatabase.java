package com.app.farm;

import com.app.farm.model.Tree;
import com.app.farm.model.TreeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    private TreeRepository treeRepository;

    @Bean
    CommandLineRunner initDatabase(TreeRepository treeRepository) {

        return args -> {
            log.info("Preloading " + treeRepository.save(new Tree("1123456", "Parijata")));
            log.info("Preloading " + treeRepository.save(new Tree("11135679", "Coconut")));
            log.info("Preloading " + treeRepository.save(new Tree("111351111", "Mandarin")));
            log.info("Preloading " + treeRepository.save(new Tree("1113109201", "Neem")));
            log.info("Preloading " + treeRepository.save(new Tree("112090911", "Banyan")));
        };
    }
}

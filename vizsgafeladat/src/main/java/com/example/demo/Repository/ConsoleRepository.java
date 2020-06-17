package com.example.demo.Repository;

import com.example.demo.Modell.Console;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsoleRepository extends CrudRepository<Console, Long> {
    @Query(value = "select c from Console c where c.consolePrice >= :minPrice AND c.consolePrice <= :maxPrice")
    List<Console> getConsolesByPriceRange(Integer minPrice, Integer maxPrice);
}

package com.example.demo.Repository;

import com.example.demo.Modell.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
    @Query(value = "select g from Game g where g.publisher = :publisher")
    List<Game> getGamesByPublisher(@Param("publisher") String publisher);
}

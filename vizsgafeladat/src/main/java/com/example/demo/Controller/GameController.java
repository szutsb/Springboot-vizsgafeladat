package com.example.demo.Controller;

import com.example.demo.Modell.Game;
import com.example.demo.Service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {this.gameService = gameService;}

    @PostMapping( path = "/addGame")
    public Game createGame(@RequestBody Game g){
        return gameService.createGame(g);
    }

    @GetMapping( path = "/getAllGames")
    public List<Game> getAllGames(){return gameService.getAllGames(); }

    @RequestMapping( method = RequestMethod.GET, value = "/getGame/{id}")
    public Game getGameById(@PathVariable("id") Long gameID){
        return gameService.getGameById(gameID);
    }

    @PostMapping( path = "/updateGame")
    public Game updateGame(@RequestBody Game g){
        return gameService.updateGame(g);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/deleteGame/{id}")
    public void deleteGame(@PathVariable("id") Long gameID){gameService.deleteGame(gameID); }

    @GetMapping(value = "/getGames/{publisher}")
    public List<Game> getGamesByPublisher(@PathVariable("publisher") String publisher){
        return gameService.getGamesByPublisher(publisher);
    }
}

package com.example.demo.Service;

import com.example.demo.Exception.NoSuchEsrbException;
import com.example.demo.Modell.Game;
import com.example.demo.Repository.GameRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {this.gameRepository = gameRepository;}

    public Game createGame(Game g){
        String esrb = g.getEsrbRating();
        if(esrb.equals("Everyone") || esrb.equals("Everyone 10+") || esrb.equals("Teen") || esrb.equals("Mature 17+")
        || esrb.equals("Adults Only 18+") || esrb.equals("Rating Pending")){
        return gameRepository.save(g);
        }
        else {
            throw new NoSuchEsrbException("Nincs ilyen esrb rating");
        }
    }

    public List<Game> getAllGames(){
        return (List<Game>) gameRepository.findAll();
    }

    public Game getGameById(Long gameID){
        Optional<Game> oGame = gameRepository.findById(gameID);

        if(oGame.isPresent()){
            return oGame.get();
        }
        else{
            throw new NoResultException("Nincs ilyen játék");
        }

    }

    public Game updateGame(Game g){
        return gameRepository.save(g);
    }

    public void deleteGame(Long gameID){
        gameRepository.deleteById(gameID);
    }

    public List<Game> getGamesByPublisher(String publisher) {
        List<Game> List = gameRepository.getGamesByPublisher(publisher);
        if(List.size() > 0) {
            return List;
        } else throw new NoResultException("Nem található ilyen kiadó az adatbázisban");
    }
}

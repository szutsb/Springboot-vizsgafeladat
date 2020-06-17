package com.example.demo.Service;

import com.example.demo.Modell.Console;
import com.example.demo.Modell.Game;
import com.example.demo.Repository.ConsoleRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class ConsoleService {
    private final ConsoleRepository consoleRepository;

    public ConsoleService(ConsoleRepository consoleRepository) {this.consoleRepository = consoleRepository;}

    public Console createConsole(Console c) { return consoleRepository.save(c); }

    public List<Console> getAllConsoles() { return (List<Console>) consoleRepository.findAll(); }

    public Console getConsoleById(Long consoleID){
        Optional<Console> oConsole = consoleRepository.findById(consoleID);

        if(oConsole.isPresent()){
            return oConsole.get();
        }
        else {
            throw new NoResultException("Nincs ilyen konzol");
        }
    }

    public Console updateConsole(Console c){ return consoleRepository.save(c); }

    public void deleteConsole(Long consoleID){ consoleRepository.deleteById(consoleID); }

    public List<Console> getConsolesByPriceRange(Integer minPrice, Integer maxPrice) {
        List<Console> List = consoleRepository.getConsolesByPriceRange(minPrice, maxPrice);
        if(List.size() > 0) {
            return List;
        } else throw new NoResultException("Nem található ebben az ártartományban konzol az adatbázisban");
    }
}

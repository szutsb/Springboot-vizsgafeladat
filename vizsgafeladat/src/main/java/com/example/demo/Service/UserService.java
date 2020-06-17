package com.example.demo.Service;

import com.example.demo.Modell.Game;
import com.example.demo.Modell.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User u){
        return userRepository.save(u);
    }

    public List<User> getAll(){
        return (List<User>) userRepository.findAll();
    }

    public User getById(Long userID){
        Optional<User> oUser =userRepository.findById(userID);

        if(oUser.isPresent()){
            return oUser.get();
        }
        else{
            throw new NoResultException("Nincs ilyen User");
        }

    }

    public User update(User u){
        return userRepository.save(u);
    }

    public void delete(Long userID){
        userRepository.deleteById(userID);
    }

    public List<User> getRegularCustomers() {
        List<User> List = userRepository.getRegularCustomers();
        if(List.size() > 0) {
            return List;
        } else throw new NoResultException("Nem található törzsvásárló az adatbázisban");
    }
}

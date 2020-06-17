package com.example.demo.Repository;

import com.example.demo.Modell.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "select u from User u where u.regularCustomer = true")
    List<User> getRegularCustomers();
}

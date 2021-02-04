package com.goldencode.gasteiapp.services;

import com.goldencode.gasteiapp.domain.Category;
import com.goldencode.gasteiapp.domain.User;
import com.goldencode.gasteiapp.repositories.UserRepository;
import com.goldencode.gasteiapp.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public User find(Integer id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: "+id+
                ", Tipo: "+Category.class.getName()));
    }

}

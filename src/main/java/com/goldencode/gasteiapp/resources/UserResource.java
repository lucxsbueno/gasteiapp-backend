package com.goldencode.gasteiapp.resources;

import com.goldencode.gasteiapp.domain.User;
import com.goldencode.gasteiapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserResource {

    @Autowired
    UserService service;

    @RequestMapping(value = "/{id}")
    public ResponseEntity<User> find(@PathVariable Integer id){
        User obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

}

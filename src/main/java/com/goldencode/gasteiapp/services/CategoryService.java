package com.goldencode.gasteiapp.services;

import com.goldencode.gasteiapp.domain.Category;
import com.goldencode.gasteiapp.repositories.CategoryRepository;
import com.goldencode.gasteiapp.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Category find(Integer id) {
        Optional<Category> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: "+id+
                ", Tipo: "+Category.class.getName()));
    }

}

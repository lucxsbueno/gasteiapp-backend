package com.goldencode.gasteiapp.resources;

import com.goldencode.gasteiapp.domain.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/categories")
public class EntryResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> welcome() {

        Category  cat1 = new Category(1, "Merch");
        Category  cat2 = new Category(2, "Shopping");

        List<Category> list = new ArrayList<>();

        list.add(cat1);
        list.add(cat2);
        
        return list;
    }

}

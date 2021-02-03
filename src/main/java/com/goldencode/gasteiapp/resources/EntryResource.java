package com.goldencode.gasteiapp.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/entries")
public class EntryResource {

    @RequestMapping(method = RequestMethod.GET)
    public String welcome() {
        return "Welcome to my Api REST.";
    }

}

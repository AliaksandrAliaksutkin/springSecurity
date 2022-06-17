package com.org.springsecurity.rest;

import com.org.springsecurity.model.Developer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/developers/")
public class DeveloperRestController {

    private List<Developer> DEVELOPERS = List.of(
            new Developer(1L, "Ivan", "Ivanov"),
            new Developer(2L,"Petr", "Petrov" ),
            new Developer(3L,"Alex", "Alexov")
    );

    @GetMapping
    public List<Developer> getAll(){
        return DEVELOPERS;
    };

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id){
        return DEVELOPERS.stream().filter(x->x.getId().equals(id)).findFirst()
                .orElse(null);
    };
}
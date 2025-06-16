package com.adalicious.adalicious.controller;

import com.adalicious.adalicious.modele.User;
import com.adalicious.adalicious.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User poUser) {
        return userService.creer(poUser);
    }
    // voir DTO, model mapper..ne pas exposer User sur cette couche

    @GetMapping("/read")
    public List<User> read() {
        return userService.lire();
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Integer id,@RequestBody User user) {
        return userService.modifier(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return userService.supprimer(id);
    }
    // ne fonctionne pas si l'utilisateur est rataché à d'autres tables
    
}

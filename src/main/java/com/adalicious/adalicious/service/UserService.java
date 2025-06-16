package com.adalicious.adalicious.service;

import com.adalicious.adalicious.modele.User;
import java.util.List;

public interface UserService {

    User creer(User user);

    List<User> lire();

    User modifier(Integer id, User user);

    String supprimer(Integer id);



}

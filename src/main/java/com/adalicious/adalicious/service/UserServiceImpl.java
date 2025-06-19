package com.adalicious.adalicious.service;
import com.adalicious.adalicious.modele.User;
import com.adalicious.adalicious.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User creer(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> lire() {
        return userRepository.findAll();
    }

    @Override
    public User trouver(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User modifier(Integer id, User user) {
        return userRepository.findById(id)
        .map(u-> {
            u.setFirstname(user.getFirstname());
            u.setLastname(user.getLastname());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            return userRepository.save(u);
        }).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé."));
    }

    @Override
    public String supprimer(Integer id) {
        userRepository.deleteById(id);
        return "Utilisateur supprimé.";
    }

}

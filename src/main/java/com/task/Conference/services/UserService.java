package com.task.Conference.services;

import com.task.Conference.dao.UserDao;
import com.task.Conference.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private UserDao userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserDao userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User not found");
    }

    public boolean saveUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

}

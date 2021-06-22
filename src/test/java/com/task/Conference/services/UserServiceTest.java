package com.task.Conference.services;

import com.task.Conference.entities.Role;
import com.task.Conference.entities.User;
import com.task.Conference.repositories.UserRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void nullTest() {
        assertThat(userService).isNotNull();
    }

    @Test
    void addingUserTest() {

        User user = new User(null, "test", "test", null, null);

        boolean isSaved = userService.saveUser(user);

        assertTrue(isSaved);
        assertTrue(CoreMatchers.is(user.getRole()).matches(Collections.singleton(Role.LISTENER)));
        Mockito.verify(userRepository, Mockito.times(1)).save(user);

    }
}

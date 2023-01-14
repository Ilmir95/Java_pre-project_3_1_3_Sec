package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;
@Component
public class DefUser implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public DefUser(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role roleMentror = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleRepository.save(roleMentror);
        roleRepository.save(roleUser);
        Set<Role> userRole = new HashSet<>();
        userRole.add(roleUser);
        Set<Role> mentorRole = new HashSet<>();
        mentorRole.add(roleMentror);
        mentorRole.add(roleUser);
        User ilmir = new User("Ilmir", "Khafizov", 27, "ilmir131313@yandex.ru", "user", "$2a$12$J3Gqnb2/bfxTIpAb0eWX1.wtB1C5GBfOAq9IKGiTecNrGCFsDQOMG", userRole); // password 123456
        User mentor = new User("Mentor", "Kata", 30, "mentor@mail.ru", "mentor", "$2a$12$J3Gqnb2/bfxTIpAb0eWX1.wtB1C5GBfOAq9IKGiTecNrGCFsDQOMG", mentorRole); // password 123456
        userRepository.save(ilmir);
        userRepository.save(mentor);
    }
}

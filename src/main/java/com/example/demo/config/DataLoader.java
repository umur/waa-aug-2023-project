package com.example.demo.config;

import com.example.demo.entity.RoleType;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private UserRepo userRepository;

    @Autowired
    public DataLoader(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        // Create a new user with the role ADMIN
        User adminUser1 = new User();
//                .name("Amensisa Wirtu")
//                .email("amensisawirtu.edossa@miu.edu")
//                .password(new BCryptPasswordEncoder().encode("secretpassword1"))
//                .about("I am an admin user1")
//                .role(RoleType.ADMIN)
//                .build();
        User adminUser2 = new User();
//                adminUser2.("Fraol Gerba")
//                adminUser2.email("firaolduguma.geraba@miu.edu")
//                adminUser2.password(new BCryptPasswordEncoder().encode("secretpassword2"))
//                adminUser2.about("I am an admin user2")
//                adminUser2.role(RoleType.ADMIN)
//                adminUser2.build();
        // Save the user to the database
        userRepository.save(adminUser1);
        userRepository.save(adminUser2);
    }
}

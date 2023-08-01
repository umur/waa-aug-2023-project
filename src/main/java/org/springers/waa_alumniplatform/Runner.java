package org.springers.waa_alumniplatform;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.repository.AlumniRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {
    private final AlumniRepo alumniRepo;
    @Override
    public void run(String... args) throws Exception {
//        System.out.println(alumniRepo.findUserById(1));
    }
}

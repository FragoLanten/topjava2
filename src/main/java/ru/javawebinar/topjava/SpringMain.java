package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.inmemory.InMemoryUserRepository;
import ru.javawebinar.topjava.web.user.AdminRestController;

import java.util.Arrays;
import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 automatic resource management (ARM)
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            adminUserController.create(new User(null, "userName", "email@mail.ru", "password", Role.ADMIN));

            InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
            inMemoryUserRepository.save(new User(1, "AlexA", "email", "111111", Role.ADMIN));
            inMemoryUserRepository.save(new User(2, "AlexC", "email", "111111", Role.ADMIN));
            inMemoryUserRepository.save(new User(3, "AlexY", "email", "111111", Role.ADMIN));
            inMemoryUserRepository.save(new User(10, "Boris", "email", "111111", Role.ADMIN));
            inMemoryUserRepository.save(new User(1, "AlexB", "email", "111111", Role.ADMIN));
            inMemoryUserRepository.save(new User(1, "Cedr", "email", "111111", Role.ADMIN));

            List<User> list = inMemoryUserRepository.getAll();

            for (User users:list) {
                System.out.println(users.toString());
            }

        }
    }
}

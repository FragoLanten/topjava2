package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.MealService;

import java.util.Collection;
import java.util.List;

import static ru.javawebinar.topjava.web.SecurityUtil.authUserId;

@Controller
public class MealRestController {
    @Autowired
    private MealService service;

    private int userId = authUserId();

    public void create(Meal meal) {
        service.create(meal, userId);
    }

    public Meal get(int id) {
        return service.get(id, userId);
    }

    public void delete(int id) {
        service.delete(id, userId);
    }

    public void update(Meal meal) {
        service.update(meal, userId);
    }

    public Collection<Meal> getAll() {
        return service.getAll(userId);
    }

}
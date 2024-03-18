package org.example.jdbc1.app.controller;

import org.example.jdbc1.app.user.user;
import org.example.jdbc1.app.userDao.userDao;
import org.springframework.web.bind.annotation.*;

@RestController
public class controller {

    private final userDao dao;

    public controller(userDao dao) {
        this.dao = dao;
    }

    @PostMapping
    public Long createUser(@RequestBody user user) {
        return dao.createUser(user);

    }

    @GetMapping
    public user getUserById(@RequestParam long id) {
        return dao.getUserById(id);
    }

    @PutMapping
    public void editUser(@RequestBody user user) {
        dao.editUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam long id) {
        dao.deleteUser(id);
    }

}

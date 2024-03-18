package org.example.jdbc1.app.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class user {
    private long id;
    private String surname;
    private String phone;
    private String addres;
    private LocalDateTime created;


}

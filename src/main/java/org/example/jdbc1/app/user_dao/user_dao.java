package org.example.jdbc1.app.user_dao;
import org.example.jdbc1.app.user.user;
import org.example.jdbc1.app.user_row_mapper.user_row_mapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Repository
public class user_dao {
    private final NamedParameterJdbcTemplate template;

    public user_dao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public Long createUser(user user) {
        String sql = "INSERT INTO user (surname, phone, addres) VALUES (:surname, :phone, :addres)";
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("surname", user.getSurname());
        paramMap.addValue("phone", user.getPhone());
        paramMap.addValue("addres", user.getAddres());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(sql, paramMap, keyHolder);

        return keyHolder.getKey().longValue();


    }

    public user getUserById(long id) {
        String sql = "SELECT * FROM user WHERE user.id = :id";
        MapSqlParameterSource paramMap = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, paramMap, new user_row_mapper());
    }

    public void editUser(user user) {
        String sql = "UPDATE user SET surname = :surname, addres = :addres, phone = :phone WHERE id = :id";
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("id", user.getId());
        paramMap.addValue("surname", user.getSurname());
        paramMap.addValue("phone", user.getPhone());
        paramMap.addValue("addres", user.getAddres());
        template.update(sql, paramMap);
    }

    public void deleteUser(long id) {
        String sql = "DELETE FROM user WHERE id = :id";
        MapSqlParameterSource paramMap = new MapSqlParameterSource("id",id);
        template.update(sql,paramMap);

    }
}

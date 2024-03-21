package org.example.jdbc1.app.user_row_mapper;

import org.example.jdbc1.app.user.user;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class user_row_mapper implements RowMapper<user> {

    @Override
    public user mapRow(ResultSet rs, int rowNum) throws SQLException {
        user user = new user();
        user.setId(rs.getLong("id"));
        user.setSurname(rs.getString("surname"));
        user.setPhone(rs.getString("phone"));
        user.setAddres(rs.getString("addres"));
        user.setCreated(rs.getTimestamp("created").toLocalDateTime());
        return user;
    }

}

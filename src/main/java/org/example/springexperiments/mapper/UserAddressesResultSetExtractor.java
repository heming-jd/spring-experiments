package org.example.springexperiments.mapper;

import lombok.extern.slf4j.Slf4j;
import org.example.springexperiments.dox.Address;
import org.example.springexperiments.dox.User;
import org.example.springexperiments.dto.UserAddresses;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserAddressesResultSetExtractor implements ResultSetExtractor<UserAddresses> {
    @Override
    public UserAddresses extractData(ResultSet rs) throws SQLException {
        User user=null;
        List<Address> addresses = new ArrayList<>();
        while(rs.next()) {
            if(user==null) {
                user = User.builder()
                        .id(rs.getString("u.id"))
                        .name(rs.getString("u.name"))
                        .createTime(rs.getObject("u.create_time", LocalDateTime.class))
                        .updateTime(rs.getObject("u.update_time", LocalDateTime.class))
                        .build();
            }
            Address a= Address.builder()
                    .id(rs.getString("a.id"))
                    .detail(rs.getString("a.detail"))
                    .userId(rs.getString("a.user_id"))
                    .createTime(rs.getTimestamp("a.create_time").toLocalDateTime())
                    .updateTime(rs.getTimestamp("a.update_time").toLocalDateTime())
                    .build();
            addresses.add(a);
        }
        return UserAddresses.builder()
                .user(user)
                .addresses(addresses)
                .build();
    }
}

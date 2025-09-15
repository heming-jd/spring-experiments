package org.example.springexperiments.mapper;

import lombok.extern.slf4j.Slf4j;
import org.example.springexperiments.dox.Address;
import org.example.springexperiments.dox.User;
import org.example.springexperiments.dto.AddressUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class AddressUserMapping implements RowMapper<AddressUser> {
    @Override
    public AddressUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        AddressUser addressUser = AddressUser.builder()
                .user(User.builder()
                        .id(rs.getString("user_id"))        // 使用正确的列别名
                        .name(rs.getString("user_name"))    // 使用正确的列别名
                        .build())
                .address(Address.builder()
                        .id(rs.getString("address_id"))           // 使用正确的列别名
                        .detail(rs.getString("address_detail"))   // 使用正确的列别名
                        .userId(rs.getString("address_user_id"))  // 使用正确的列别名
                        .createTime(rs.getTimestamp("create_time").toLocalDateTime())
                        .updateTime(rs.getTimestamp("update_time").toLocalDateTime())
                        .build())
                .build();

        log.info("addressUser:{}", addressUser);
        return addressUser;
    }
}

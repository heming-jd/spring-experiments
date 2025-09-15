package org.example.springexperiments.mapper;

import org.example.springexperiments.dto.UnameAcount;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnameAcountResultSetExtractor implements ResultSetExtractor<List<UnameAcount>> {
    @Override
    public List<UnameAcount> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<UnameAcount> results = new ArrayList<>();
        while (rs.next()) {
            UnameAcount item = UnameAcount.builder()
                    .username(rs.getString("name"))  // 使用列别名
                    .account(rs.getInt("count"))     // 使用列别名
                    .build();
            results.add(item);
        }
        return results;
    }
}


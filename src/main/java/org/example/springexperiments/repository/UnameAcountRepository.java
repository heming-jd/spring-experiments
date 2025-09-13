package org.example.springexperiments.repository;

import org.example.springexperiments.dto.UnameAcount;
import org.example.springexperiments.mapper.UnameAcountResultSetExtractor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnameAcountRepository extends ListCrudRepository<UnameAcount, Long> {
    @Query(value = "SELECT u.name, count(a.user_id) as count FROM user u LEFT JOIN address a ON u.id = a.user_id GROUP BY u.id ORDER BY count",
            resultSetExtractorClass = UnameAcountResultSetExtractor.class)
    List<UnameAcount> findAllUnameAcount();
}
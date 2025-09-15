package org.example.springexperiments.repository;

import org.example.springexperiments.dto.UserAddresses;
import org.example.springexperiments.mapper.UserAddressesResultSetExtractor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressesRepository extends ListCrudRepository<UserAddresses, String> {
    @Query(value="SELECT * FROM address a JOIN user u ON u.id = a.user_id WHERE u.id = :id",
    resultSetExtractorClass = UserAddressesResultSetExtractor.class)
    UserAddresses findUserAddressesById(String id);
}

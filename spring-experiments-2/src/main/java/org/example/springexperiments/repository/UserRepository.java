package org.example.springexperiments.repository;

import org.example.springexperiments.dox.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User, String> {
    @Query("UPDATE user SET name = :name WHERE id = :id")
    @Modifying
    void updateNameById(String id, String name);


}

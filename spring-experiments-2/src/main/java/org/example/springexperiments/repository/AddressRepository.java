package org.example.springexperiments.repository;

import org.example.springexperiments.dox.Address;
import org.example.springexperiments.dto.AddressUser;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends ListCrudRepository<Address, Long> {
    @Query("SELECT * FROM address WHERE user_id = :userId")
    List<Address> findByUserId(String userId);

    @Query("""
            select
                a.id as address_id,
                a.detail as address_detail,
                u.id as user_id,
                u.name as user_name,
                a.create_time as create_time,
                a.update_time as update_time,
                a.user_id as address_user_id
                from address a join user u on u.id = a.user_id
                where a.id = :aid
            """)
    AddressUser findAddressUserByAddressId(String aid);
}

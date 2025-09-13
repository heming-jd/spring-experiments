package org.example.springexperiments.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springexperiments.dox.Address;
import org.example.springexperiments.dox.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressUser {
    private User user;
    private Address address;
}
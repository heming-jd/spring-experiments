package org.example.springexperiments.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springexperiments.dox.Address;
import org.example.springexperiments.dox.User;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddresses {
    private User user;
    private List<Address>  addresses;
}

package br.com.vvaug.efoodusersds.entity;

import br.com.vvaug.efoodusersds.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private String name;
    private List<Address> addresses;
    @DBRef
    private List<UserRole> roles;
}
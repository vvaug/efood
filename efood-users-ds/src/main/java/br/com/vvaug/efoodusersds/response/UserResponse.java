package br.com.vvaug.efoodusersds.response;

import br.com.vvaug.efoodusersds.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponse {


    private String username;
    private String password;
    private List<UserRole> roles;
}

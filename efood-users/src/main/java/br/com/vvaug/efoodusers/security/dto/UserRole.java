package br.com.vvaug.efoodusers.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRole implements GrantedAuthority {

    private String id;
    private String name;

    @Override
    public String getAuthority() {
        return this.getName();
    }
}

package br.com.vvaug.efoodusersds.usecase.impl;

import br.com.vvaug.efoodusersds.entity.User;
import br.com.vvaug.efoodusersds.entity.UserRole;
import br.com.vvaug.efoodusersds.exception.ApplicationException;
import br.com.vvaug.efoodusersds.gateway.UserGateway;
import br.com.vvaug.efoodusersds.gateway.UserRoleGateway;
import br.com.vvaug.efoodusersds.request.CreateUserRequest;
import br.com.vvaug.efoodusersds.usecase.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserGateway userGateway;
    private final UserRoleGateway userRoleGateway;
    private final ModelMapper modelMapper;

    private static final String DEFAULT_ROLE = "ROLE_USER";

    @Override
    public void execute(CreateUserRequest createUserRequest) {
       var user = modelMapper.map(createUserRequest, User.class);
       setDefaultRole(user);
       userGateway.save(user);
    }

    public void setDefaultRole(User user){
        var role = userRoleGateway.findByName(DEFAULT_ROLE)
                .orElseThrow(() -> new ApplicationException("Role not found: " + DEFAULT_ROLE, HttpStatus.NOT_FOUND.value(), null));
        user.setRoles(List.of(role));
    }
}

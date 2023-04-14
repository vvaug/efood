package br.com.vvaug.efoodusersds.usecase.impl;

import br.com.vvaug.efoodusersds.exception.ApplicationException;
import br.com.vvaug.efoodusersds.gateway.UserGateway;
import br.com.vvaug.efoodusersds.request.FindUserRequest;
import br.com.vvaug.efoodusersds.response.UserResponse;
import br.com.vvaug.efoodusersds.usecase.FindUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindUserUseCaseImpl implements FindUserUseCase {

    private final UserGateway userGateway;
    private final ModelMapper modelMapper;

    @Override
    public UserResponse execute(FindUserRequest userRequest) {
        log.info("Searching user on database: {}", userRequest.getUsername());
        var user = userGateway.findByUsername(userRequest.getUsername())
                .orElseThrow(() -> new ApplicationException("Username not found", HttpStatus.NOT_FOUND.value(), null));
        return modelMapper.map(user, UserResponse.class);
    }
}

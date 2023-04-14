package br.com.vvaug.efoodusers.config.security;

import br.com.vvaug.efoodusers.gateway.EfoodUsersDataServiceGateway;
import br.com.vvaug.efoodusers.response.UserResponse;
import br.com.vvaug.efoodusers.security.dto.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final EfoodUsersDataServiceGateway efoodUsersDataServiceGateway;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserResponse response = efoodUsersDataServiceGateway.findUser(username);
        if (response != null){
            return modelMapper.map(response, User.class);
        }
        throw new UsernameNotFoundException("User not found");
    }
}

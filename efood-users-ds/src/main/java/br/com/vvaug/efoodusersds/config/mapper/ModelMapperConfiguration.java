package br.com.vvaug.efoodusersds.config.mapper;

import br.com.vvaug.efoodusersds.entity.User;
import br.com.vvaug.efoodusersds.entity.UserRole;
import br.com.vvaug.efoodusersds.request.CreateUserRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.print.attribute.standard.Destination;
import java.util.Arrays;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}

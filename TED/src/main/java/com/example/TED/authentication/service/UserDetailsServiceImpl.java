package com.example.TED.authentication.service;

import com.example.TED.authentication.model.RoleModel;
import com.example.TED.authentication.model.UserModel;
import com.example.TED.authentication.repository.RoleModelRepository;
import com.example.TED.authentication.repository.UserRepository;
import com.example.TED.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleModelRepository roleModelRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel userModel = userRepository.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("Não foi encontrado o usúario:" + username));

        return new User(userModel.getUserName(),
                userModel.getPassword(), true, true,
                true, true,userModel.getAuthorities());
    }

    @Transactional
    public UserDTO criarUsuario(UserDTO userDTO){


        if (userDTO.getUsername() != null && userDTO.getPassword() != null && !userDTO.getListRole().isEmpty()) {

            List<RoleModel> roleModel = roleModelRepository.findByRoleNameIn(userDTO.getListRole());

            if(roleModel.isEmpty()){
                throw new UsernameNotFoundException("ROLE inexistente" );
            }

            UserModel userModel = new UserModel();
            userModel.setRoles(roleModel);
            userModel.setUserName(userDTO.getUsername());
            userModel.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));

            userRepository.save(userModel);
        }else {
            throw new UsernameNotFoundException("Parametros null");
        }

        return userDTO;
    }

}
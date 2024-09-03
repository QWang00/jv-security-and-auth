package com.northcoders.security.service;

import com.northcoders.security.model.Users;
import com.northcoders.security.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


@Service
public class UsersService extends DefaultOAuth2UserService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        String name = oAuth2User.getName();
        String githubUsername = oAuth2User.getAttribute("login");


        if(usersRepository.findByGithubUsername(githubUsername).isEmpty()) {
            Users newUser = Users.builder()
                            .name(name)
                                    .githubUsername(githubUsername)
                                            .build();
            usersRepository.save(newUser);
        }

        return oAuth2User;
    }
}

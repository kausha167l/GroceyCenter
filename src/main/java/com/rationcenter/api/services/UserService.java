package com.rationcenter.api.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rationcenter.api.dto.userDtos.SignInDto;
import com.rationcenter.api.dto.userDtos.SignInResponseDto;
import com.rationcenter.api.dto.userDtos.SignUpDto;
import com.rationcenter.api.dto.userDtos.ResponseDto;
import com.rationcenter.api.entities.AuthenticationToken;
import com.rationcenter.api.entities.User;
import com.rationcenter.api.exception.AuthenticationFailedException;
import com.rationcenter.api.exception.CustomExceptions;
import com.rationcenter.api.repos.UserRepo;

import jakarta.xml.bind.DatatypeConverter;

@Transactional
@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    AuthenticationSevice authenticationSevice;

    public ResponseDto signUp(SignUpDto sdto){
        // Check if user is present
        if(Objects.nonNull(userRepo.findByEmail(sdto.getEmail()))){
            throw new CustomExceptions("User already exists");
        }

        // hash the Password
        String encryptedPwd = sdto.getPassword();
        try {
            encryptedPwd = hashPwd(sdto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // save User
        User user = new User(sdto.getFirstName(),sdto.getLastName(),sdto.getEmail(),encryptedPwd);

        userRepo.save(user);

        // create Token
        AuthenticationToken At = new AuthenticationToken(user);
        authenticationSevice.saveToken(At);

        ResponseDto srdto = new ResponseDto("success", sdto +" added");
        return srdto;

    }

    private String hashPwd(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return hash;
    }

    public SignInResponseDto signIn(SignInDto sidto) {
        // find email
        User user = userRepo.findByEmail(sidto.getEmail());

        if(Objects.isNull(user))
        {
            throw new AuthenticationFailedException("User not found");
        }

        // hash password
        try {
            if(!user.getPassword().equals(hashPwd(sidto.getPassword())))
            {
                throw new AuthenticationFailedException("Wrong Password");
            }
        } catch (NoSuchAlgorithmException e) {
            
            e.printStackTrace();
        }

        AuthenticationToken token = authenticationSevice.getToken(user);

        if(Objects.isNull(token)){
            throw new AuthenticationFailedException("No token");
        }
        return new SignInResponseDto("success",token.getToken());
    }
}

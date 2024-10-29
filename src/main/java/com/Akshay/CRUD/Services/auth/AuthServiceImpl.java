package com.Akshay.CRUD.Services.auth;
import com.Akshay.CRUD.Repository.UserRepository;
import com.Akshay.CRUD.dto.SignupRequest;
import com.Akshay.CRUD.dto.UserDto;
import com.Akshay.CRUD.entity.User;
import com.Akshay.CRUD.enums.UserRole;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    @PostConstruct
    public void createAdminAccount(){
        User adminAccount = userRepository.findByUserRole(UserRole.Admin);
        if(adminAccount == null){
            User newAdminAccount = new User();
            newAdminAccount.setUsername("admin");
            newAdminAccount.setEmail("admin@test.com");
            newAdminAccount.setPassword(new BCryptPasswordEncoder().encode("admin"));
            newAdminAccount.setUserRole(UserRole.Admin);
            userRepository.save(newAdminAccount);
            System.out.println("Admin account created");
        }
    }

    @Override
    public UserDto createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setUsername(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setEmail(signupRequest.getEmail());
        user.setUserRole(UserRole.User);
        User createdUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());

        return userDto;
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
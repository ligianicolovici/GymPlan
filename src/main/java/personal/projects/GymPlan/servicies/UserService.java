package personal.projects.GymPlan.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import personal.projects.GymPlan.dtos.UserDto;
import personal.projects.GymPlan.entities.User;
import personal.projects.GymPlan.repositories.UserRepository;
import personal.projects.GymPlan.utils.UserPrinciple;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private MapStructMapper mapStructMapper;

    public UserDto register(UserDto userDto){
//        User userForRegistration = mapStructMapper.userDtoToUser(userDto);
//        User userRegistered = userRepository.save(userForRegistration);
//        if(userRegistered!=null){
//            return userDto;
//        }
        return null;
    }

    public UserDto login(String username, String password){
//        User returnedUser = userRepository.findByUserName(username);
//        if(returnedUser.getPassword().equals(password)){
//            return mapStructMapper.userToUserDto(returnedUser);
//        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        if (user.isPresent()) {
            return new UserPrinciple(user);
        } else {
            return null;
        }
    }
}

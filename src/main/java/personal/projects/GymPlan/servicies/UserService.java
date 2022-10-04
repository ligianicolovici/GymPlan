package personal.projects.GymPlan.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.projects.GymPlan.dtos.UserDto;
import personal.projects.GymPlan.repositories.UserRepository;

@Service
public class UserService {

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
}

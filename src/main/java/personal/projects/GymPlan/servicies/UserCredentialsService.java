package personal.projects.GymPlan.servicies;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import personal.projects.GymPlan.entities.User;
import personal.projects.GymPlan.repositories.UserRepository;
import personal.projects.GymPlan.utils.UserCredentials;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserCredentialsService {

    private final UserRepository userRepository;

    public List<UserCredentials> getCredentialsForAllUsers() {
        final List<User> users = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        final List<UserCredentials> allUserCredentials = new ArrayList<>();
        users.forEach(customer -> allUserCredentials.add(new UserCredentials(customer.getUsername(), customer.getPassword())));

        return allUserCredentials;
    }
}
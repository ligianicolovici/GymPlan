package personal.projects.GymPlan.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import personal.projects.GymPlan.entities.User;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Data
@AllArgsConstructor
public class UserPrinciple implements UserDetails {
    private transient User user = null;

    public UserPrinciple(Optional<User> optionalUser) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (optionalUser.isPresent()) {
            this.user = optionalUser.get();
            this.user.setPassword(passwordEncoder.encode(this.user.getPassword()));
        } else {
            this.user = null;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
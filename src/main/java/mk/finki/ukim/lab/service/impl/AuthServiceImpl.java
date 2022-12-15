package mk.finki.ukim.lab.service.impl;

import mk.finki.ukim.lab.model.User;
import mk.finki.ukim.lab.model.exceptions.InvalidArgumentsException;
import mk.finki.ukim.lab.model.exceptions.InvalidUserCredentialsException;
import mk.finki.ukim.lab.model.exceptions.PasswordsDoNotMatchException;
import mk.finki.ukim.lab.model.exceptions.UsernameAlreadyExistsException;
import mk.finki.ukim.lab.repository.jpa.UserRepositoryJpa;
import mk.finki.ukim.lab.service.AuthService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepositoryJpa userRepository;

    public AuthServiceImpl(UserRepositoryJpa userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() ||  password == null ||  password.isEmpty()) {
            throw new InvalidArgumentsException();
        }

        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, LocalDate dateOfBirth) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }
        if (this.userRepository.findByUsername(username).isPresent() || !this.userRepository.findByUsername(username).isEmpty())
            throw new UsernameAlreadyExistsException(username);

        User user = new User(username, password, name, surname,dateOfBirth);
        return userRepository.save(user);

    }
}

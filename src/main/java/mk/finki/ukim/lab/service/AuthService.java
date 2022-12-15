package mk.finki.ukim.lab.service;

import mk.finki.ukim.lab.model.User;

import java.time.LocalDate;

public interface AuthService {
    User login(String username, String password);
    User register(String username, String password, String repeatPassword, String name, String surname, LocalDate dateOfBirth);
}

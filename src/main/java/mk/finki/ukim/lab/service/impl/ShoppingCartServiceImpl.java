package mk.finki.ukim.lab.service.impl;

import mk.finki.ukim.lab.repository.jpa.ShoppingCartRepositoryJpa;
import mk.finki.ukim.lab.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepositoryJpa shoppingCartJpaRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepositoryJpa shoppingCartJpaRepository) {
        this.shoppingCartJpaRepository = shoppingCartJpaRepository;
    }
}

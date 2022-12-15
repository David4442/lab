package mk.finki.ukim.lab.service.impl;

import mk.finki.ukim.lab.model.Order;
import mk.finki.ukim.lab.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order placeOrder(String balloonColor, String username, String address) {
        return new Order(balloonColor, username);
    }
}

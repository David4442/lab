package mk.finki.ukim.lab.service;


import mk.finki.ukim.lab.model.Order;

public interface OrderService {

    Order placeOrder(String balloonColor, String username, String address);
}


package mk.finki.ukim.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/BalloonOrder")
public class BalloonOrderController {
    @GetMapping
    public String getBalloonOrderPage() {
        return "delivery-info";
    }
}
package mk.finki.ukim.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/selectBalloon")
public class SelectBalloonController {
    @GetMapping
    public String getSelectBalloonPage() {
        return "selectBalloonSize";
    }
}
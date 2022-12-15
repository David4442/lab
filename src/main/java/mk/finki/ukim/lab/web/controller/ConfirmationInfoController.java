package mk.finki.ukim.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ConfirmationInfo")
public class ConfirmationInfoController {
    @GetMapping
    public String getConfirmationInfoPage() {
        return "confirmationInfo";
    }
}
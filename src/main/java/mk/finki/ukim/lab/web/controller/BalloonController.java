package mk.finki.ukim.lab.web.controller;

import mk.finki.ukim.lab.model.Balloon;
import mk.finki.ukim.lab.model.Manufacturer;
import mk.finki.ukim.lab.service.BalloonService;
import mk.finki.ukim.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }


    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model, HttpServletRequest request){

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Balloon> balloons = this.balloonService.listAll();
        request.getSession().setAttribute("balloons",balloons);
        model.addAttribute("balloons", balloons);
        return "listBalloons";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        this.balloonService.deleteById(id);
        return "redirect:/balloons";
    }

    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model){
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "add-balloon";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model){
        if (this.balloonService.findById(id).isPresent()) {
            Balloon balloon = balloonService.findById(id).get();
            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
            model.addAttribute("manufacturers", manufacturers);
            model.addAttribute("balloon", balloon);
            return "add-balloon";
        }
        return "redirect:/balloons?error=BalloonNotFound";

    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Long manufacturer){

        this.balloonService.save(name, description, manufacturer);
        return "redirect:/balloons";

    }



}

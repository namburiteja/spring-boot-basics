package org.example.springbootbasics.controller;

import org.example.springbootbasics.dto.HelloRequest;
import org.example.springbootbasics.service.FlamesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    String boyy,girll;
    private final FlamesService flamesService;
    public UserController(FlamesService flamesService){
        this.flamesService = flamesService;
    }
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("user",new HelloRequest());
        return "register";
    }
    @PostMapping("/result")
    public String answer(@ModelAttribute HelloRequest request,Model model){
        boyy = request.getboyName();;
        girll = request.getgirlName();
        String result = flamesService.flames(boyy,girll);
        model.addAttribute("boy",boyy);
        model.addAttribute("girl",girll);
        model.addAttribute("flame",result);
        return "home";
    }
}

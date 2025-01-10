package org.example.companywebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model)
    {
        System.out.println("Inside home");
        model.addAttribute("title","Home - Company Overview");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model)
    {
        model.addAttribute("title","About Us");
        return "about";
    }
    @GetMapping("/services")
    public String services(Model model)
    {
        model.addAttribute("title","Our Services");
        return "services";
    }
    @GetMapping("/contact")
    public String contact(Model model)
    {
        model.addAttribute("title","Contact Us");
        return "contact";
    }
    @GetMapping("/gallery")
    public String gallery(Model model)
    {
        model.addAttribute("title","Gallery");
        return "gallery";
    }
    @GetMapping("/article")
    public String article(Model model)
    {
        model.addAttribute("title","Articles");
        return "article";
    }

    public String quotation(Model model)
    {
        model.addAttribute("title","Request a quotation");
        return "quotation";
    }

}

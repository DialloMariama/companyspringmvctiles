package com.groupeisi.companyspringmvctiles.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommandeController {
    private static final Logger logger = LoggerFactory.getLogger(CommandeController.class);

    @GetMapping("/public/commandes")
    public String showCommandePage() {
        return "commandes";
    }
}

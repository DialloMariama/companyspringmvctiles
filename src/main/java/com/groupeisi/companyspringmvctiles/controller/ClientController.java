package com.groupeisi.companyspringmvctiles.controller;

import com.groupeisi.companyspringmvctiles.dto.ClientDto;
import com.groupeisi.companyspringmvctiles.service.ClientService;
import com.groupeisi.companyspringmvctiles.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    private IClientService clientService;

    public ClientController(){
        this.clientService = new ClientService();
    }

    @GetMapping("/clients")
    public String GetClients(Model model) {
        logger.info("Appel de la Méthode GET ");

        try {
            Optional<List<ClientDto>> clients = clientService.findAll();
            if (clients.isPresent()) {
                model.addAttribute("clientList", clients.get());
            } else {
                model.addAttribute("clientList", new ArrayList<ClientDto>());
            }
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération des clients", e);
        }

        return "clients";
    }

    @PostMapping("/clients")
    public String addClient(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam(value = "tel", required = false) String tel,
            @RequestParam(value = "address", required = false) String address) {

        ClientDto clientDto = new ClientDto();
        clientDto.setFirstName(firstName);
        clientDto.setLastName(lastName);
        clientDto.setEmail(email);
        clientDto.setPassword("default password");
        clientDto.setTel(tel);
        clientDto.setAddress(address);

        try {
            clientService.save(clientDto);

        } catch (RuntimeException e) {
            logger.error("Erreur lors de l'enregistrement du client : {}", e.getMessage());
        }

        return "redirect:clients";
    }
}

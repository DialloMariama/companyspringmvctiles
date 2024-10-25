package com.groupeisi.companyspringmvctiles.controller;

import com.groupeisi.companyspringmvctiles.dto.AccountUserDto;
import com.groupeisi.companyspringmvctiles.service.AccountUserService;
import com.groupeisi.companyspringmvctiles.service.IAccountUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final IAccountUserService accountUserService = new AccountUserService();

    private static final String REDIRECT_TO_LOGIN = "login";

    @GetMapping(name = "login", value ="/")
    public String showLoginPage() {
        return REDIRECT_TO_LOGIN;
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("username") String userName,
            @RequestParam("password") String password,
            HttpSession session) {

        logger.info("Nom d'utilisateur envoyé: {}", userName);

        try {
            Optional<AccountUserDto> accountUserDto = accountUserService.login(userName, password);

            if (accountUserDto.isPresent()) {
                session.setAttribute("username", userName);
                return "welcome";
            } else {
                return REDIRECT_TO_LOGIN;
            }
        } catch (Exception e) {
            logger.error("Erreur lors de la connexion : {}", e.getMessage());
            return REDIRECT_TO_LOGIN;
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return REDIRECT_TO_LOGIN;
    }
}

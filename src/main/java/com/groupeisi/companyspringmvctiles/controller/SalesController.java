package com.groupeisi.companyspringmvctiles.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.groupeisi.companyspringmvctiles.dto.ProductDto;
import com.groupeisi.companyspringmvctiles.dto.SalesDto;
import com.groupeisi.companyspringmvctiles.service.IProductService;
import com.groupeisi.companyspringmvctiles.service.ISalesService;
import com.groupeisi.companyspringmvctiles.service.ProductService;
import com.groupeisi.companyspringmvctiles.service.SalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class SalesController {
    private static final Logger logger = LoggerFactory.getLogger(SalesController.class);

    private final ISalesService salesService = new SalesService();
    private final IProductService productService = new ProductService();

    @GetMapping("/sales")
    public String showSales(Model model) {
        logger.info("SalesController - showSales");

        try {
            Optional<List<SalesDto>> sales = salesService.findAll();
            model.addAttribute("salesList", sales.orElse(new ArrayList<>()));

            Optional<List<ProductDto>> products = productService.findAll();
            model.addAttribute("productList", products.orElse(new ArrayList<>()));
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération des données", e);
        }

        return "sales";
    }

    @PostMapping("/sales")
    public String saveSale(
            @RequestParam("productRef") String productRef,
            @RequestParam("quantity") double quantity) {
        logger.info("SalesController - saveSale");

        logger.debug("Paramètres reçus : productRef={}, quantity={}", productRef, quantity);

        Optional<ProductDto> productOptional = productService.findByRef(productRef);

        if (productOptional.isPresent()) {
            ProductDto productDto = productOptional.get();

            SalesDto salesDto = new SalesDto();
            salesDto.setProduct(productDto);
            salesDto.setQuantity(quantity);

            try {
                salesService.save(salesDto);
                logger.info("Achat enregistré avec succès");
            } catch (Exception e) {
                logger.error("Erreur lors de l'enregistrement de l'achat", e);
            }
        } else {
            logger.error("Produit non trouvé avec la référence ");
        }

        return "redirect:/sales";
    }
}


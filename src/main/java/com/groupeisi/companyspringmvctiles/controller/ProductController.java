package com.groupeisi.companyspringmvctiles.controller;

import com.groupeisi.companyspringmvctiles.dto.ProductDto;
import com.groupeisi.companyspringmvctiles.service.IProductService;
import com.groupeisi.companyspringmvctiles.service.ProductService;
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
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private IProductService productService;

    public ProductController(){
        this.productService = new ProductService();
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        logger.info("ProductController - Méthode GET appelée pour afficher les produits");

        try {
            Optional<List<ProductDto>> products = productService.findAll();
            if (products.isPresent()) {
                logger.info("ProductController - Liste des produits récupérée avec succès");
                model.addAttribute("productList", products.get());
            } else {
                logger.info("ProductController - Aucun produit trouvé");
                model.addAttribute("productList", new ArrayList<ProductDto>());
            }
        } catch (Exception e) {
            logger.error("ProductController - Erreur lors de la récupération des produits", e);
        }

        return "products";
    }

    @PostMapping("/products")
    public String saveProduct(
            @RequestParam("ref") String ref,
            @RequestParam("name") String name,
            @RequestParam("stock") double stock) {

        logger.info("ProductController - Méthode POST appelée pour enregistrer un produit");
        logger.debug("ProductController - Paramètres reçus : ref={}, name={}, stock={}", ref, name, stock);

        ProductDto productDto = new ProductDto();
        productDto.setRef(ref);
        productDto.setName(name);
        productDto.setStock(stock);

        try {
            boolean productSaved = productService.save(productDto);

            if (productSaved) {
                logger.info("ProductController - Produit enregistré avec succès");
            } else {
                logger.warn("ProductController - Échec de l'enregistrement du produit");
            }
        } catch (Exception e) {
            logger.error("ProductController - Erreur lors de l'enregistrement du produit", e);
        }

        return "redirect:/products";
    }


}

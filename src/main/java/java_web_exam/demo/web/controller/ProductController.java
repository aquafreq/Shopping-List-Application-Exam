package java_web_exam.demo.web.controller;


import java_web_exam.demo.model.binding.ProductAddBindingModel;
import java_web_exam.demo.model.service.ProductServiceModel;
import java_web_exam.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ModelMapper modelMapper;
    private final ProductService productService;

    @GetMapping("/add")
    public String addProduct(Model model) {
        if (!model.containsAttribute("product")) model.addAttribute("product", new ProductAddBindingModel());
        return "product-add";
    }

    @PostMapping("/add")
    public String addProductConfirm(@Valid @ModelAttribute("product") ProductAddBindingModel productAddBindingModel, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.product", result);
            attributes.addFlashAttribute("product", productAddBindingModel);
            return "redirect:add";
        }

        ProductServiceModel map = modelMapper.map(productAddBindingModel,
                ProductServiceModel.class);
        productService.addProduct(map);

        return "redirect:/home";
    }

    @GetMapping("/buy/{id}")
    public String buyProduct(@PathVariable(value = "id") String id) {
        productService.buyProductById(id);
        return "redirect:/home";
    }

    @GetMapping("/buy/all")
    public String buyProduct() {
        productService.buyAllProducts();
        return "redirect:/home";
    }
}



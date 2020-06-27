package java_web_exam.demo.web.controller;


import java_web_exam.demo.model.view.ProductViewModel;
import java_web_exam.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ProductService productService;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("foods", productService.allProductsByCategory("Food"));
        model.addAttribute("drinks", productService.allProductsByCategory("Drink"));
        model.addAttribute("households", productService.allProductsByCategory("Household"));
        model.addAttribute("other", productService.allProductsByCategory("Other"));
        model.addAttribute("totalPriceOfProducts", productService.getPriceOfAllProducts());

        return "home";
    }
}

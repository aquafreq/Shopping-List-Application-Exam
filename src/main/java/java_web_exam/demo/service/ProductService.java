package java_web_exam.demo.service;

import java_web_exam.demo.model.service.ProductServiceModel;
import java_web_exam.demo.model.view.ProductViewModel;


import java.math.BigDecimal;
import java.util.Collection;

public interface ProductService {
    ProductServiceModel addProduct(ProductServiceModel map);

    Collection<ProductViewModel> allProductsByCategory(String category);

    void buyProductById(String id);

    void buyAllProducts();

    BigDecimal getPriceOfAllProducts();
}

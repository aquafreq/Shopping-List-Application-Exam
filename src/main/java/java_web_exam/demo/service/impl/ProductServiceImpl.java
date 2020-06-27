package java_web_exam.demo.service.impl;

import java_web_exam.demo.model.entity.Category;
import java_web_exam.demo.model.entity.Product;
import java_web_exam.demo.model.service.ProductServiceModel;
import java_web_exam.demo.model.view.ProductViewModel;
import java_web_exam.demo.repository.ProductRepository;
import java_web_exam.demo.service.CategoryService;
import java_web_exam.demo.service.ProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository repository;
    private final CategoryService categoryService;

    @Override
    public ProductServiceModel addProduct(ProductServiceModel map) {
        Product map1 = modelMapper.map(map, Product.class);

        Category category = categoryService.getCategoryByName(map.getCategory());
        map1.setCategory(category);
        return modelMapper.map(repository.save(map1),ProductServiceModel.class);
    }

    @Override
    public Collection<ProductViewModel> allProductsByCategory(String category) {
        return repository.getAllByCategory(categoryService.getCategoryByName(category))
                .stream()
                .map(x -> modelMapper.map(x, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyProductById(String id) {
        repository.deleteById(id);
    }

    @Override
    public void buyAllProducts() {
        repository.deleteAll();
    }

    @Override
    public BigDecimal getPriceOfAllProducts() {
        return repository.findAll()
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

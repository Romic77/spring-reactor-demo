package com.reactor.demo.controller;


import com.reactor.demo.base.BaseController;
import com.reactor.demo.domain.entity.Product;
import com.reactor.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author system
 * @since 2022-07-25
 */
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Mono<Product> addProduct(@RequestBody Product product) {
        productService.save(product);
        return Mono.just(product);
    }
}

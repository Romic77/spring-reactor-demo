package com.reactor.demo.controller;


import com.reactor.demo.domain.entity.Product;
import com.reactor.demo.domain.response.Result;
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
public class ProductController {

    @PostMapping("/add")
    public Mono<Result<Product>> addProduct(@RequestBody Product product) {
        return Mono.just(Result.success());
    }
}

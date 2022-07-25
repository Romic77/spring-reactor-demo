package com.reactor.demo.service.impl;

import com.reactor.demo.domain.entity.Product;
import com.reactor.demo.mapper.ProductMapper;
import com.reactor.demo.service.ProductService;
import com.reactor.demo.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author system
 * @since 2022-07-25
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductMapper, Product> implements ProductService {

}

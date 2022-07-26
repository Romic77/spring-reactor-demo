package com.reactor.demo.domain.entity;

import java.math.BigDecimal;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author system
 * @since 2022-07-25
 */
@Data
public class Product {
    private static final long serialVersionUID = 1L;

    private Long id;

    private BigDecimal price;

    private String productName;

    private String productCode;

    private String desc;

}

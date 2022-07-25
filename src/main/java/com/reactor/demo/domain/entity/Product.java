package com.reactor.demo.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.reactor.demo.base.BaseEntity;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author system
 * @since 2022-07-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("Product")
public class Product extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private BigDecimal price;

    private String productName;

    private String productCode;

    @TableField("`desc`")
    private String desc;

}

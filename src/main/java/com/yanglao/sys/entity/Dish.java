package com.yanglao.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author 张旭
 * @since 2023-03-27
 */
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜品id
     */
    @TableId(value = "dish_id", type = IdType.AUTO)
    private Integer dishId;

    /**
     * 菜品名称
     */
    private String dishName;

    /**
     * 菜品类型
     */
    private String dishType;

    /**
     * 原料
     */
    private String rawMaterial;

    /**
     * 菜品价格
     */
    private BigDecimal dishPrice;
    /**
     * 提供日期
     */
    private String week;
    /**
     * 提供日期
     */
    private String dishPic;

    public String getDishPic() {
        return dishPic;
    }

    public void setDishPic(String dishPic) {
        this.dishPic = dishPic;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }
    public String getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(String rawMaterial) {
        this.rawMaterial = rawMaterial;
    }
    public BigDecimal getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(BigDecimal dishPrice) {
        this.dishPrice = dishPrice;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", dishName='" + dishName + '\'' +
                ", dishType='" + dishType + '\'' +
                ", rawMaterial='" + rawMaterial + '\'' +
                ", dishPrice=" + dishPrice +
                ", week='" + week + '\'' +
                ", dishPic='" + dishPic + '\'' +
                '}';
    }
}

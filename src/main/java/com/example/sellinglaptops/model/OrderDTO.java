package com.example.sellinglaptops.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
public class OrderDTO {
    private String comment;
    private String discountCode;
    private List<Cart> listCart;
    private long idStatus;


    public long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(long idStatus) {
        this.idStatus = idStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public List<Cart> getListCart() {
        return listCart;
    }

    public void setListCart(List<Cart> listCart) {
        this.listCart = listCart;
    }

    public OrderDTO(String comment, String discountCode, List<Cart> listCart, long idStatus) {
        this.comment = comment;
        this.discountCode = discountCode;
        this.listCart = listCart;
        this.idStatus = idStatus;

    }
}

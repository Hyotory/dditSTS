package kr.or.ddit.vo;

import lombok.Data;

@Data
public class ProductVO {
    private String description;
    private String manufacturer;
    private String category;
    private int unitsInStock;
    private String condition;
    private String filename;
    private int quantity;
    private String productId;
    private String pname;
    private int unitPrice;
}

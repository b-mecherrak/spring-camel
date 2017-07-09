package com.ocp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Product")
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column( nullable = false)
    private String productCode;

    public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column( nullable = false)
    private String productName;
    
    @Column
    private String productCatg;

    public Product() {
    }

    public Product(int productId, String productName, String productCatg) {
        this.productId = productId;
        this.productName = productName;
        this.productCatg = productCatg;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCatg() {
        return productCatg;
    }

    public void setProductCatg(String productCatg) {
        this.productCatg = productCatg;
    }

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCatg=" + productCatg
				+ "]";
	}
    
    

}
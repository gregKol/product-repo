package pl.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "product")

@Entity
@Table(name = "product", schema = "productdb")
public class Product {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;

	@Id
	@Column(name = "credit_id")
	private int creditNumber;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "value")
	private int productValue;


	public int getCreditNumber() {
		return creditNumber;
	}

	public void setCreditNumber(int creditNumber) {
		this.creditNumber = creditNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductValue() {
		return productValue;
	}

	public void setProductValue(int productValue) {
		this.productValue = productValue;
	}

	@Override
	public String toString() {
		return "Product {creditNumber=" + creditNumber + ", productName=" + productName + ", productValue=" + productValue + "}";
	}

}

package com.uba.assetdisposal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "T_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "NAME")
    @Length(min = 5, message = "*Name must have at least 5 characters")
    private String name;
   
    @Column(name = "MAX_DAY", nullable = true)
    private int maxDays;

	@Column(name = "BID_START", nullable = true)
    private LocalDate bidStart; 
    
    @Column(name = "bidEnd", nullable = true)
    private LocalDate bidEnd;

	@Column(name = "SOLID")
    private String solid;

	@Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "QUANTITY", nullable = false)
    @Min(value = 0, message = "*Quantity has to be non negative number")
    private Integer quantity;

    @Column(name = "PRICE", nullable = false)
    @DecimalMin(value = "0.00", message = "*Price has to be non negative number")
    private BigDecimal price;
    
    @Column(name = "CURRENT_AMOUNT", nullable = true)
    private BigDecimal currentAmount;
    
    @Column(name = "START_AMOUNT", nullable = true)
    private BigDecimal startAmount;
    
    @Lob
    private byte[] data;

	public BigDecimal getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(BigDecimal currentAmount) {
		this.currentAmount = currentAmount;
	}

	public BigDecimal getStartAmount() {
		return startAmount;
	}

	public void setStartAmount(BigDecimal startAmount) {
		this.startAmount = startAmount;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal unitPrice) {
        this.price = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id.equals(product.id);
    }

    public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
    public int hashCode() {
        return id.hashCode();
    }
	
	public LocalDate getBidStart() {
		return bidStart;
	}

	public void setBidStart(LocalDate bidStart) {
		this.bidStart = bidStart;
	}

	public LocalDate getBidEnd() {
		return bidEnd;
	}

	public void setBidEnd(LocalDate bidEnd) {
		this.bidEnd = bidEnd;
	}
	
	public int getMaxDays() {
		return maxDays;
	}

	public void setMaxDays(int maxDays) {
		this.maxDays = maxDays;
	}
	
	public String getSolid() {
		return solid;
	}

	public void setSolid(String solid) {
		this.solid = solid;
	}
	
}
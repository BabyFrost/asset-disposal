package com.uba.assetdisposal.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ProductDTO {
	
    private Long id;
    
    @Length(min = 5, message = "*Name must have at least 5 characters")
    private String name;
    
    private int maxDays;
    
    @NotNull
    @NotBlank
    private String bidStart;
    
    @NotNull
    @NotBlank
    private String bidEnd;
    
    private String solid;
    
    private String description;
    
    @Min(value = 0, message = "*Quantity has to be non negative number")
    private Integer quantity;
    
    @DecimalMin(value = "0.00", message = "*Price has to be non negative number")
    private BigDecimal price;
    
    private BigDecimal currentAmount;
    
    private BigDecimal startAmount;
    
    @NotNull
    private byte[] data;
    
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
	public int getMaxDays() {
		return maxDays;
	}
	public void setMaxDays(int maxDays) {
		this.maxDays = maxDays;
	}
	public String getBidStart() {
		return bidStart;
	}
	public void setBidStart(String bidStart) {
		this.bidStart = bidStart;
	}
	public String getBidEnd() {
		return bidEnd;
	}
	public void setBidEnd(String bidEnd) {
		this.bidEnd = bidEnd;
	}
	public String getSolid() {
		return solid;
	}
	public void setSolid(String solid) {
		this.solid = solid;
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
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
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
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}

}

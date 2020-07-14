package com.hef.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table
public class OrderLine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private int amount;
	private BigDecimal purchasePrice;

	@ToString.Exclude
	@ManyToOne
	private CustomerOrder customerOrder;

	@ToString.Exclude
	@ManyToOne
	private Product product;

	public BigDecimal computingPurchasePrice(){
		return this.product.getPrice().multiply(new BigDecimal(this.amount));
	}





}

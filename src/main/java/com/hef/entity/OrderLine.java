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

	private Integer amount;
	private BigDecimal purchasePrice;
	
	@ManyToOne
	private CustomerOrder customerOrder;

	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;





}

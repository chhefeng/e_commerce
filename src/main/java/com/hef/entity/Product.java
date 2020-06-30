package com.hef.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;
	private BigDecimal price;

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				'}';
	}
}

package com.hef.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="customer_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Calendar date;
	private BigDecimal totalPrice;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "customerOrder")
	private List<OrderLine> orderLines = new ArrayList<>();
}

package com.fooddelivery.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_table")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	private double mrpPrice;
	private long quantity;
	private double totalPrice;
	private String OrderStatus;
	private String paymentStatus;
	private Date orderedDate;
	@NotEmpty(message = "Food Name Should Not be empty")
	private String foodName;
	private String foodImage;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_Id")
	private User user;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "food_order",joinColumns = @JoinColumn(name = "order_Id",referencedColumnName = "orderId"),
	inverseJoinColumns = @JoinColumn(name = "food_Id",referencedColumnName = "foodId"))
	private List<Food> food;


}

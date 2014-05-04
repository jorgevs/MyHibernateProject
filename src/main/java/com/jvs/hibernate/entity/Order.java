package com.jvs.hibernate.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Order extends AuditBaseEntityImpl {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_ID")
	private Long orderId;
	
	@Column(name="ORDER_DATE")
	private Date orderDate;
	
	@Column(name="DELIVERY_DATE")
	private Date deliveryDate;
	
	@Column(name="PAYMENT_METHOD")
	private String paymentMethod;
	
	@Column(name="STATUS")
	private String status;
		
	@Column(name="DISCOUNT")
	private BigDecimal discount;

	@Column(name="ORDER_TOTAL")
	private BigDecimal orderTotal;
	
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;

	
	public Order(){
		super();
	}
	
	public Order(Date orderDate, String paymentMethod, String status){
		this.orderDate = orderDate; 
		this.paymentMethod = paymentMethod;
		this.status = status;
	}

	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderId=");
		builder.append(orderId);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", deliveryDate=");
		builder.append(deliveryDate);
		builder.append(", paymentMethod=");
		builder.append(paymentMethod);
		builder.append(", status=");
		builder.append(status);
		builder.append(", discount=");
		builder.append(discount);
		builder.append(", orderTotal=");
		builder.append(orderTotal);
		builder.append("]");
		return builder.toString();
	}
	
}

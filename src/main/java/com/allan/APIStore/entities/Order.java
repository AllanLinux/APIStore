package com.allan.APIStore.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.allan.APIStore.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
// Definindo o nome da tabela no DB
@Table(name = "tb_order")
public class Order implements Serializable {

	/**
	 * Serializable: serve para habilitar que um objeto de uma determinada classe
	 * possa ter seu estado persistido pela api padrão do java
	 */
	private static final long serialVersionUID = 1L;

	// Indica qual atributo é a chave primária
	@Id
	// Determina que o ID será auto-incrementado
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// Realizando a formatação do Date/Moment
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer orderStatus;

	// Definindo o relacionamento de muitos para um
	@ManyToOne
	// Fazendo a configuração da chave extrangeira
	@JoinColumn(name = "client_id")
	// Associação
	private User client;
	// Associação com a tabela OrderItem
	// No OrderItem possui o id do pedido, por isso
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();

	// Associação com pagamento
	// Mapeando as duas entidades para possuir a mesma ID, por isso o cascade
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;

	// Construtor

	public Order() {

	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}
	
	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null)
			this.orderStatus = orderStatus.getCode();
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Set<OrderItem> getItem() {
		return items;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	// Method
	public Double getTotal() {
		double sum = 0.0;
		for (OrderItem x : items) {
			sum = sum + x.getSubTotal();
		}
		return sum;
	}

	// HashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

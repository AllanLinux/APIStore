package com.allan.secao25.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//Definindo o nome da tabela no DB
@Table(name = "tb_product")
public class Product implements Serializable {
	
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
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
	/**
	 *  Ao inves de List, foi usado o Set - Ele representa um conjunto
	 *  Isso para garantir não terá um produto com mais de uma ocorrencia 
	 *  da mesma categoria, o mesmo produto não pode ter uma mesma categoria 
	 *  mais de 1x
	 */
	//Define o relacionamento muitos para muitos
	@ManyToMany
	/**
	 * Aqui, define a chave trangeira, onde cria-se uma nova tabela e digo que a chave estrangeira de
	 * "Product" sera o "product_id". O inverseJoinColumns define a chave estrangeira da outra entidade
	 * 
	 */
	@JoinTable(name = "tb_product_category", 
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();

	// Usando Set para assim informar ao JPA que não ira admitir repetições do msm item
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items =  new HashSet<>();

	// Construtores
	public Product() {
		
	}
	
	public Product(Long id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	// Getters Setters
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
	}
	// Percorrendo a coleção items, a cada elemento da coleção de nome "X"
	// Sera adicionado 
	@JsonIgnore
	public Set<Order> getOrders() {
		Set<Order> set = new HashSet<>();
		for (OrderItem x : items) {
			set.add(x.getOrder());
		}
		return set;
	}

	// HashCode and Equals
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

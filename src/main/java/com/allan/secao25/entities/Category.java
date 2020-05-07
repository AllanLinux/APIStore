package com.allan.secao25.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//Definindo o nome da tabela no DB
@Table(name = "tb_category")
public class Category implements Serializable {
	
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
	
	@JsonIgnore
	// Referencia para o mapeamento feito em Product
	@ManyToMany(mappedBy = "categories")
	private Set<Product> procucts = new HashSet<>();
	
	//Construtor
	public Category() {
		
	}
	
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// Getters and Setters
	
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

	public Set<Product> getProcucts() {
		return procucts;
	}

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
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

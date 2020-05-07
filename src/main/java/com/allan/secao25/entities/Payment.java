package com.allan.secao25.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Essa anotação informa que uma classe também é uma entidade
@Entity
// Definindo o nome da tabela no DB
@Table(name = "tb_payment")
public class Payment implements Serializable {

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
    private Instant moment;


    // Ignorando esse campo para a consulta da api não entrar em loop
    @JsonIgnore
    // Associação um para um com order
    @OneToOne
    @MapsId
    private Order order;

    // Constructors
    public Payment() {

    }

    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
        Payment other = (Payment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
package com.allan.secao25.entities.enums;

public enum OrderStatus {
	// Determinando code para cada enum
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	// Codigo do tipo enumerado
	private int code;
	// Construtor do tipo enumerado
	private OrderStatus(int code) {
		this.code = code;
	}
	// Getter 
	public int getCode() {
		return code;
	}
	
	// Metodo estatico para converter um valor numero para o tipo enumerado
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus Code");
	}
}



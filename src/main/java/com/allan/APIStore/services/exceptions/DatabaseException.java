package com.allan.APIStore.services.exceptions;

public class DatabaseException extends RuntimeException {

    /**
     * Serializable: serve para habilitar que um objeto de uma determinada classe
     * possa ter seu estado persistido pela api padrão do java
     */
    private static final long serialVersionUID = 1L;

    public DatabaseException(String msg) {
        super(msg);
    }

}

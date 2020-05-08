package com.allan.APIStore.services.exceptions;
/*
    Classe de tratamento para objetos não encontrados
 */
public class ResourceNotFoundException extends RuntimeException {
    /**
     * Serializable: serve para habilitar que um objeto de uma determinada classe
     * possa ter seu estado persistido pela api padrão do java
     */
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id: " + id);
    }
}

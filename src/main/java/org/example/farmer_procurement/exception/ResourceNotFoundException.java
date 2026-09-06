package org.example.farmer_procurement.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        
        super(message);
    }
}

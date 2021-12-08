package me.block2block.networks.exceptions;

public class InvalidOperationException extends RuntimeException {

    public InvalidOperationException(String operation) {
        super(operation + " is not a valid operation.");
    }

}

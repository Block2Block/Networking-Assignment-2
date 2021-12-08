package me.block2block.networks.exceptions;

public class DivideByZeroException extends RuntimeException {

    public DivideByZeroException() {
        super("An attempt was made to divide by zero.");
    }
}

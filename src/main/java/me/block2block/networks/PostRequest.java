package me.block2block.networks;

import java.util.List;

public class PostRequest {

    private String operation;
    private int[] arguments;

    PostRequest(String operation, int[] arguments) {
        this.operation = operation;
        this.arguments = arguments;
    }

    public int[] getArguments() {
        return arguments;
    }

    public String getOperation() {
        return operation;
    }

    public void setArguments(int[] arguments) {
        this.arguments = arguments;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}

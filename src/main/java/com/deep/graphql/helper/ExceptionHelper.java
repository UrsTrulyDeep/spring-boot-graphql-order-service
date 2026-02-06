package com.deep.graphql.helper;

public class ExceptionHelper {

    public static RuntimeException throwResourceNotFoundException() {
        return  new RuntimeException("Resource not found !!");
    }
}

package io.riddles.io;

/**
 * Created by Niko on 28/03/16.
 */
public class Token {

    private String value;

    private Token(String value) {
        this.value = value;
    }

    public static Token of(String value) {
        return new Token(value);
    }
}

package io.riddles.model;

/**
 * Created by Niko on 24/03/16.
 */
public interface Traversible {

    void accept(Visitor visitor);
}

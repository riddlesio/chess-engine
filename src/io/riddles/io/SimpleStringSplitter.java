package io.riddles.io;

import java.util.List;

/**
 * Created by Niko on 28/03/16.
 */
public final class SimpleStringSplitter {

    public String[] tokenize(String input) {

        return input.split(" ");
    }
}

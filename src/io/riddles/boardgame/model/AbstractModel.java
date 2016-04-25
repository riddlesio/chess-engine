package io.riddles.boardgame.model;

import io.riddles.model.Traversible;
import io.riddles.model.Visitor;

/**
 * Created by Niko on 28/03/16.
 */
public abstract class AbstractModel implements Traversible {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

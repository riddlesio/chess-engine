package io.riddles.boardgame.model;

import java.util.List;

/**
 * @author Niko van Meurs <niko@riddles.io>
 */
public final class SquareBoard extends AbstractModel implements Board {

    protected List<Field> fields;

    /**
     * Board constructor
     * @param fields
     */
    public SquareBoard(List<Field> fields) {

        this.fields = fields;
    }

    @Override
    public List<Field> getFields() {
        return fields;
    }

    @Override
    public Field getFieldAt(Coordinate coordinate) throws IndexOutOfBoundsException {

        int x = coordinate.getX();
        int y = coordinate.getY();
        int boardSize = this.size();

        int index = boardSize * y + x;
        int fieldSize = fields.size();

        if (index >= fieldSize) {
            throw new IndexOutOfBoundsException("Coordinate out of bounds");
        }

        return fields.get(index);
    }

    public int size() {

        return (int) Math.sqrt(fields.size());
    }

    public static SquareBoard of(List<Field> fields) {

        return new SquareBoard(fields);
    }
}

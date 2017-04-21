/*
 * Copyright 2016 riddles.io (developers@riddles.io)
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 *     For the full copyright and license information, please view the LICENSE
 *     file that was distributed with this source code.
 */

package io.riddles.chess.move;

import io.riddles.chess.game.move.MoveType;
import io.riddles.javainterface.exception.InvalidInputException;
import io.riddles.javainterface.serialize.Deserializer;

import java.awt.*;

/**
 * io.riddles.go.game.move.GoMoveDeserializer - Created on 6/27/16
 *
 * [description]
 *
 * @author Joost - joost@riddles.io, Jim van Eeden - jim@riddles.io
 */
public class ChessMoveDeserializer implements Deserializer<ChessMove> {


    public ChessMoveDeserializer() {
    }

    @Override
    public ChessMove traverse(String string) {

        try {
            return visitMove(string);
        } catch (InvalidInputException ex) {
            return new ChessMove(ex);
        } catch (Exception ex) {
            return new ChessMove(new InvalidInputException("Failed to parse move"));
        }
    }

    private ChessMove visitMove(String input) throws InvalidInputException {
        input = input.replace(',', ' ');
        String[] split = input.split(" ");

        MoveType type = visitAssessment(split[0]);
        Point p = null;
        if (type == MoveType.MOVE) {
            p = new Point(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }

        return new ChessMove(new Point(), new Point());
    }

    private MoveType visitAssessment(String input) throws InvalidInputException {
        switch (input) {
            case "move": /* TODO: Use Chess notation */
                return MoveType.MOVE;
            default:
                throw new InvalidInputException("Move isn't valid");
        }
    }
}

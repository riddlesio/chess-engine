package io.riddles.chess.validator;

import io.riddles.boardgame.logic.PieceLogic;
import io.riddles.chess.model.ChessPieceColor;
import io.riddles.chess.model.ChessPieceType;

import java.awt.*;
import java.util.Optional;

/**
 * ${PACKAGE_NAME}
 *
 * This file is a part of chess
 *
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko
 */
public abstract class ChessPieceMoveValidator {

    private PieceLogic<ChessPieceType, ChessPieceColor> logic;

    ChessPieceMoveValidator() {
        logic = new PieceLogic<>();
    }

}

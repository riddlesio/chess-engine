package io.riddles.chess.validator;

import io.riddles.chess.move.ChessMove;
import io.riddles.chess.model.ValidationResult;

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
public interface MoveValidator<S> {

    Boolean isApplicable(ChessMove move, S state);

    ValidationResult validate(ChessMove move, S state);
}
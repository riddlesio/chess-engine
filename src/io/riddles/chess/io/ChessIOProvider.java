package io.riddles.chess.io;

import io.riddles.chess.visitor.ChessIORequestSerializer;
import io.riddles.chess.visitor.ChessIOResponseDeserializer;
import io.riddles.game.io.AbstractIOProvider;
import io.riddles.game.io.IOProvider;
import io.riddles.game.io.IORequest;
import io.riddles.game.io.IOResponse;

/**
 * io.riddles.chess.io
 * <p>
 * This file is a part of chess
 * <p>
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko
 */
public class ChessIOProvider extends AbstractIOProvider implements IOProvider<ChessIORequestType> {

    public ChessIOProvider(IOHandler handler) {
        super(handler);
    }

    /**
     * Chess IO Scheme:
     *
     * Notifications:
     *
     * DECLARE CHECK
     * DECLARE CHECK_MATE
     * DECLARE DRAW {reason}
     * UPDATE
     *
     * Requests:
     *
     * MOVE
     * PROMOTE x,y
     *
     * Responses:
     *
     * DECLARE THREEFOLD_REPETITION
     * MOVE x,y x,y
     * PROMOTE x,y {piece_type}
     * RESIGN
     */

    /**
     *
     * @param request The IO request
     * @return Response to the IORequest
     */
    @Override
    public IOResponse execute(IORequest<ChessIORequestType> request) {

        int playerId = 0;
        ChessIORequestType requestType = request.getType();
        String parsedRequest = parseRequest((ChessIORequest) request);

        String rawResponse = handler.sendRequest(playerId, parsedRequest);

        return parseResponse(rawResponse, request);
    }

    private String parseRequest(ChessIORequest request) {

        ChessIORequestSerializer serializer = new ChessIORequestSerializer();
        return serializer.traverse(request);
    }

    private ChessIOResponse parseResponse(String input, ChessIORequest request) {

        ChessIOResponseDeserializer deserializer = new ChessIOResponseDeserializer();
        return deserializer.traverse(input, request);
    }
}

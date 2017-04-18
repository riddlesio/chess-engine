package io.riddles.game.engine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import io.riddles.chess.io.ChessIORequestType;
import io.riddles.game.io.IORequest;
import io.riddles.game.io.IOProvider;
import io.riddles.game.io.IOResponse;

/**
 * Implements of the GameLoop interface in a way which is suitable
 * for most games.
 *
 * The generic type State is provided so the you are free to implement any
 * type of state container while still being able to use this class.
 *
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko van Meurs <niko@riddles.io>
 */
public class SimpleGameLoop<State> implements GameLoop<State> {

    /**
     * @inheritDoc
     */
    @Override
    public State run(IOProvider ioProvider,
                     Processor<State> processor,
                     State initialState) {

        IORequest request;
        IOResponse response;
        State state = initialState;
        
        
        String line = null;
        BufferedReader bufferedReader = null;
        
        
        try {
			FileReader fileReader = new FileReader("C:\\workspace\\Moves\\1.txt");
		
            bufferedReader =  new BufferedReader(fileReader);
              /*
                while((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
			*/
            
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        while (!processor.hasGameEnded(state)) {

        	//System.out.println("loop");
            
            try {
				while((line = bufferedReader.readLine()) != null) {
				    System.out.println(line);			    
				    state = processor.processInputTest(state, line);
				}
			} catch (Exception e) {
				state = processor.processException(state, e);
				e.printStackTrace();
			}        	
        	
        	
        }        
        
        /*

        while (!processor.hasGameEnded(state)) {

            request = processor.getRequest(state);

            try {
                response = ioProvider.execute(request);
                state = processor.processInput(state, response);

            } catch (Exception exception) {

                state = processor.processException(state, exception);
            }
            
            
        }

        */
        
        return state;
    }
}

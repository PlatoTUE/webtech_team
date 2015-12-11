/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.s2id90.draughts.player;

import nl.tue.s2id90.draughts.DraughtsState;
import org10x10.dam.game.Move;

public class HumanPlayer extends DraughtsPlayer {
    @Override
    public String getName() {
        return "human";
    }

    @Override
    public Move getMove(DraughtsState s) {
        throw new UnsupportedOperationException("should never be called!!!");
    }

    @Override
    public boolean isHuman() {
        return true;
    }
    
}

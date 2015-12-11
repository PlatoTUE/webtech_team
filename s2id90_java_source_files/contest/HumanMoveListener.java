/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.s2id90.contest;

/**
 *
 * @author huub
 * @param <Move>
 */
public interface HumanMoveListener<Move> {

    /**
     * This method is called when a human plays a move.
     * @param m played move
     */
    void onMove(Move m);
}

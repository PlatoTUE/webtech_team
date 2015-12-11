/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.s2id90.draughts;

/**
 *
 * @author huub
 */
public class Draughts {

    /**
     *
     * @param piece
     * @return whether or not piece is white
     */
    public static boolean isWhite(int piece) {
        return piece== DraughtsState.WHITEPIECE || piece==DraughtsState.WHITEKING;
    }
        
    /**
     *
     * @param piece
     * @return whether or not piece is black piece
     */
    public static boolean isBlack(int piece) {
        return piece== DraughtsState.BLACKPIECE || piece==DraughtsState.BLACKKING;
    }

    /**
     *
     * @param piece
     * @return whether or not piece is a king
     */
    public static boolean isKing(int piece) {
        return piece== DraughtsState.WHITEKING || piece==DraughtsState.BLACKKING;
    }
}

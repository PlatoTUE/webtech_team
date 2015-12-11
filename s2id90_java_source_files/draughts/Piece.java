/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.s2id90.draughts;

/**
 *
 * @author huub
 */
public enum Piece {
    BLACK     (false,false),
    BLACK_KING(false,true),
    WHITE     (true,false),
    WHITE_KING(true,true);
    
    // attributes
    private final Boolean isWhite;
    private final Boolean isKing;
    
    // constructor
    Piece(boolean white, boolean king) {
        this.isKing = king;
        this.isWhite = white;
        
    }

    /**
     * @return whether or not the piece is white.
     */
    public boolean isWhite() { return isWhite; }

    /**
     * @return whether or not the piece is black.
     */
    public boolean isBlack() { return !isWhite; }
    
    /**
     * return whether or not a piece is a king.
     * @return
     */
    public boolean isKing() { return isKing; }

    /**
     * @return whether or not the piece is white.
     */
    public boolean isWhitePiece() { return (!isKing)&&isWhite; }

    /**
     * @return whether or not the piece is black.
     */
    public boolean isBlackPiece() { return !(isKing || isWhite); }
    
    /**
     * @return whether or not the piece is white.
     */
    public boolean isWhiteKing() { return isKing&&isWhite; }

    /**
     * @return whether or not the piece is black.
     */
    public boolean isBlackKing() { return isKing && !isWhite; }
    
  
}
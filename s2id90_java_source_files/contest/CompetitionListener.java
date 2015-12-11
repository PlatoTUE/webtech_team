/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.tue.s2id90.contest;

import nl.tue.s2id90.game.Game;

/**
 *
 * @author huub
 */
public interface CompetitionListener<Move> {
    void onStartGame(Game g);
    void onStopGame(Game g);
    void onAIMove(Move m);
}

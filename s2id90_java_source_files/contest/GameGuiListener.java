/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.tue.s2id90.contest;

/**
 *
 * @author huub
 */
public interface GameGuiListener<S,M> {
    void onHumanMove(M m);
    void onNewGameState(S s);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.s2id90.draughts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nl.tue.s2id90.contest.PlayerPlugin;
import nl.tue.s2id90.draughts.player.DraughtsPlayer;

/**
 *
 * @author huub
 */
public class DraughtsPlugin extends PlayerPlugin<DraughtsPlayer> {
    List<DraughtsPlayer> players = new ArrayList<>();
    public DraughtsPlugin(DraughtsPlayer ... arg) {
        players.addAll(Arrays.asList(arg));
    }

    @Override
    public List<DraughtsPlayer> getPlayers() {
        return players;
    }       
}

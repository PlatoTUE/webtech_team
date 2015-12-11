/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.tue.s2id90.draughts.player;

import nl.tue.s2id90.draughts.DraughtsPlugin;

/**
 *
 * @author huub
 */
public class HumanPlugin  extends DraughtsPlugin {
    public HumanPlugin() {
        super(new HumanPlayer());
    }
}

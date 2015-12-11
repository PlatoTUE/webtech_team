/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.s2id90.contest;

import java.util.List;
import nl.tue.s2id90.game.Player;
import nl.tue.s2id90.pluginservice.Plugin;

/**
 * A Plugin that delivers a Player implementation.
 * @author huub
 * @param <P> Player
 */
public class PlayerPlugin<P extends Player> implements Plugin {
       
    /** final empty implementation.  **/
    @Override
    final public void start() { }

    /** final empty implementation. **/
    @Override
    final public void stop () { }

    /**
     * Get the value of name.
     * Override this method to give this plugin a different name.
     * @return the value of name; default "<unknown>".
     */
    @Override
    public String getName() {
        return getClass().getPackage().getName();
    }

    /**
     * @return a (computer) player
     */
    public List<P> getPlayers() {
        return null;
    }
}
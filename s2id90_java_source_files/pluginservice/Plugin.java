/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.s2id90.pluginservice;

/**
 *
 * @author huub
 */
public interface Plugin {

    /**
     *
     * @return
     */
    String getName();

    /**
     *
     */
    void start();

    /**
     *
     */
    void stop();
}

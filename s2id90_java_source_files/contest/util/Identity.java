/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.s2id90.contest.util;

import javax.swing.ImageIcon;

public interface Identity {
 
    /**
     * @return name of this identity
     */
    String getName();

    /**
     * @return icon if this identity
     */
    ImageIcon getIcon();
}

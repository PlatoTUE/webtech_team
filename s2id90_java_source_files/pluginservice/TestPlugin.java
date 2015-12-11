package nl.tue.s2id90.pluginservice;

import javax.swing.JComponent;

/**
 *
 * @author huub
 */
public class TestPlugin implements Plugin {

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return getClass().getName();
    }

    /**
     *
     */
    @Override
    public void start() {
        System.err.println(getName() +": started");
    }

    /**
     *
     */
    @Override
    public void stop() {
        System.err.println(getName() + ": stopped");
    }
}

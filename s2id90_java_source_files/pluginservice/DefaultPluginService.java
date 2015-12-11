/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.s2id90.pluginservice;

import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huub
 * @param <P>
 */
public class DefaultPluginService<P extends Plugin> implements PluginService<P> {

    private ServiceLoader<P> serviceLoader;
    private static final Logger logger = Logger.getLogger(DefaultPluginService.class.getName());

    /**
     *
     * @param _class
     */
    public DefaultPluginService(Class<P> _class) {
        //load all the classes in the classpath that have implemented the interface
        serviceLoader = ServiceLoader.load(_class);
    }

    /**
     *
     * @return
     */
    @Override
    public Iterable<P> services() {
        return serviceLoader;
    }

    /**
     *
     */
    @Override
    public void startPlugins() {
        for(P plugin : serviceLoader) {
            logger.log(Level.INFO, "Starting plugin \"{0}\"", plugin.getName());
            plugin.start();
        }
    }
    
    /**
     *
     */
    @Override
    public void stopPlugins() {
        for(P plugin : serviceLoader) {
            logger.log(Level.INFO, "Stopping plugin \"{0}\"", plugin.getName());
            plugin.stop();
        }
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.s2id90.pluginservice;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author huub
 */
public class Plugins {
    private static final Logger LOG = Logger.getLogger(Plugins.class.getName());
    
    /**
     *
     * @param <P>
     * @param clazz
     * @param folders
     * @return
     */
    public static <P extends Plugin> List<P> getPlugins(Class<P> clazz, String ... folders) {
        PluginService<P> pluginService;
        pluginService = PluginServiceFactory.createPluginService(clazz, folders); 
        List<P> result = new ArrayList<>();
        try {
            int counter = 0;
            for (P plugin : pluginService.services()) {
                plugin.start();
                LOG.log(Level.INFO, "adding plugin {0}!", plugin.getName());
                result.add(plugin);
                counter ++;
            }
            if (counter==0) {
                LOG.severe("no plugins were found!!");
            }
        } catch (ServiceConfigurationError | Exception e) {
            LOG.log(Level.SEVERE, "service configuration error {0}", e.toString());
        }
        return result;
    }
}

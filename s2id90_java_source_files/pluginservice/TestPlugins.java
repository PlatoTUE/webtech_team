/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.tue.s2id90.pluginservice;

/**
 *
 * @author huub
 */

public class TestPlugins
{

    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        PluginService<Plugin> pluginService = PluginServiceFactory.createPluginService(Plugin.class,"dist");
        
        System.err.println("\nstart all plugins");
        pluginService.startPlugins();
        
        System.err.println("\nstop all plugins");
        pluginService.stopPlugins();
    }
}
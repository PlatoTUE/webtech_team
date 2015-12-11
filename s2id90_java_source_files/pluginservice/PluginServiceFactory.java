package nl.tue.s2id90.pluginservice;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huub
 */

public class PluginServiceFactory
{
    private static final Logger LOG = Logger.getLogger(PluginServiceFactory.class.getName());
    
    /**
     *
     * @param <P>
     * @param _class
     * @param folders
     * @return
     */
    public static <P extends Plugin> PluginService<P> createPluginService(Class<P> _class, final String ... folders)
    {
        if (folders == null)
            return null;
        else {
            for (String folder : folders) {
                if (folder != null) {
                    addPluginJarsToClasspath(folder);
                }
            }
            return new DefaultPluginService<P>(_class);
        }
    }

    private static void addPluginJarsToClasspath(final String pluginFolder)
    {
        try
        {   //add the plugin directory to classpath
            ClassPathUtils.addDirToClasspath(new File(pluginFolder));
        } catch (IOException ex) {
           LOG.log(Level.SEVERE, null, ex);
        }
    }
}

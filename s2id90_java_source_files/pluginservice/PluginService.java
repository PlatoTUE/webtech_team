package nl.tue.s2id90.pluginservice;

/**
 *
 * @author huub
 * @param <Plugin>
 */
public interface PluginService<Plugin>
{

    /**
     *
     * @return
     */
    Iterable<Plugin> services();

    /**
     *
     */
    void startPlugins();

    /**
     *
     */
    void stopPlugins();
}

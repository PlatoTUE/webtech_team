package nl.tue.s2id90.pluginservice;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huub
 */
public class ClassPathUtils {

    private static final Logger logger = Logger.getLogger(ClassPathUtils.class.getName());
    // Parameters
    private static final Class[] parameters = new Class[]{ URL.class };

    /**
     * Adds the jars in the given directory to classpath
     * @param directory
     * @throws IOException
     */
    public static void addDirToClasspath(File directory) throws IOException {
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                addURL(file.toURI().toURL());
            }
        } else {
            logger.log(Level.WARNING, "The directory \"{0}\" does not exist!", directory);
        }
    }

    /**
     * Add URL to CLASSPATH
     * @param u URL
     * @throws IOException IOException
     */
    public static void addURL(URL u) throws IOException {
        URLClassLoader sysLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        for (URL url : sysLoader.getURLs()) {
            if (url.toString().equalsIgnoreCase(u.toString())) {
                logger.log(Level.INFO, "URL {0} is already in the CLASSPATH", u);
                return;
            }
        }
        Class sysclass = URLClassLoader.class;
        try {
            Method method = sysclass.getDeclaredMethod("addURL", parameters);
            method.setAccessible(true);
            method.invoke(sysLoader, new Object[]{ u });
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException t) {
            t.printStackTrace();
            throw new IOException("Error, could not add URL to system classloader");
        }
    }
}

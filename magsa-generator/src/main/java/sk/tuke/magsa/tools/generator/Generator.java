package sk.tuke.magsa.tools.generator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import sk.tuke.magsa.tools.ConfigurationException;
import sk.tuke.magsa.tools.metamodel.Model;

public abstract class Generator {
    protected static final String PROPERTIES_FILE = "generator.properties";

    protected static final Properties generatorProperties = new Properties();

    private final Model model;

    static {
        try {
            generatorProperties.load(new FileReader(new File(PROPERTIES_FILE).getAbsoluteFile()));
        } catch (Exception e) {
            throw new ConfigurationException("Failed during loading of the configuration file '" + PROPERTIES_FILE + "'", e);
        }
    }

    public Generator(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public String getJavaDestinationDir() {
        String destDir = generatorProperties.getProperty("destDir");
        String javaDir = generatorProperties.getProperty("javaDir");
        // Resolve path relative to user.dir system property
        return new File(destDir, javaDir).getAbsolutePath();

    }

    public String getResourcesDestinationDir() {
        String destDir = generatorProperties.getProperty("destDir");
        String resourcesDir = generatorProperties.getProperty("resourcesDir");
        // Resolve path relative to user.dir system property
        return new File(destDir, resourcesDir).getAbsolutePath();
    }

    protected PrintWriter createWriter(String fileName) throws GeneratorException {
        try {
            File file = new File(fileName);
            file.getParentFile().mkdirs();
            return new PrintWriter(file);
        } catch (IOException e) {
            throw new GeneratorException("Cannot write generated output to file '" + fileName + "'", e);
        }
    }

    public abstract void generate() throws GeneratorException;
}

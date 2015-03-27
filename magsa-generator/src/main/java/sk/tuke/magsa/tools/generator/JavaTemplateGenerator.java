package sk.tuke.magsa.tools.generator;

import java.io.Writer;
import java.util.Formatter;
import java.util.Map;
import sk.tuke.magsa.tools.metamodel.Model;
import sk.tuke.magsa.tools.metamodel.Type;

public abstract class JavaTemplateGenerator extends TemplateGenerator {
    public JavaTemplateGenerator(Model model, String template) {
        super(model, template);
    }

    @Override
    public String getExtension() {
        return "java";
    }

    @Override
    protected void generate(Writer writer, Map<String, Object> params) throws GeneratorException {
        params.put("package", getPackage(getTemplate()));
        super.generate(writer, params);
    }

    protected String getOutputDirectory() {
        String packageDir = getPackage(template).replace('.', '/');
        return getJavaDestinationDir() + "/" + packageDir + "/";
    }

    /* Utility methods used in templates. */
    /* *********************************************************************************** */
    public String getPackage(String template) {
        return generatorProperties.getProperty(template + ".package");
    }

    public String toUCIdent(String ident) {
        return Character.toUpperCase(ident.charAt(0)) + ident.substring(1);
    }

    public String toLCIdent(String ident) {
        return Character.toLowerCase(ident.charAt(0)) + ident.substring(1);
    }

    public String coalesce(String... args) {
        for (String s : args) {
            if (s != null) {
                return s;
            }
        }
        return null;
    }

    public String formatName(String name, String template) {
        String format = generatorProperties.getProperty(template + ".format");
        Formatter f = new Formatter();
        f.format(format, name);
        return f.toString();
    }

    public String formatQualifiedName(String name, String template) {
        return getPackage(template) + "." + formatName(name, template);
    }

    public Class<?> getJavaClass(String name) throws ClassNotFoundException {
        return Class.forName(name);
    }

    public String getJavaType(Type type) {
        switch (type) {
            case INTEGER:
                return "Integer";
            case REAL:
                return "Double";
            case STRING:
                return "String";
        }
        throw new IllegalArgumentException("Data type " + type + " is not supported");
    }

    public String psSetMethod(Type type) {
        switch (type) {
            case REAL:
                return "setDouble";
            case INTEGER:
                return "setInt";
            case STRING:
                return "setString";
        }
        throw new IllegalArgumentException("Data type " + type + " is not supported");
    }

    public String rsGetMethod(Type type) {
        switch (type) {
            case REAL:
                return "getDouble";
            case INTEGER:
                return "getInt";
            case STRING:
                return "getString";
        }
        throw new IllegalArgumentException("Data type " + type + " is not supported");
    }

    public String parseStringMethod(Type type, String input) {
        switch (type) {
            case REAL:
                return "Double.valueOf(" + input + ")";
            case INTEGER:
                return "Integer.valueOf(" + input + ")";
            case STRING:
                return input;
        }
        throw new IllegalArgumentException("Data type " + type + " is not supported");
    }
}

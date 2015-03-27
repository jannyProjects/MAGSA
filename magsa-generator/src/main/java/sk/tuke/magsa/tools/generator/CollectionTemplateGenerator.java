package sk.tuke.magsa.tools.generator;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.tuke.magsa.tools.metamodel.Model;
import sk.tuke.magsa.tools.metamodel.Named;

public class CollectionTemplateGenerator<T extends Named> extends JavaTemplateGenerator {
    private final Collection<T> items;

    public CollectionTemplateGenerator(Model model, String template, T[] items) {
        this(model, template, Arrays.asList(items));
    }

    public CollectionTemplateGenerator(Model model, String template, Collection<T> items) {
        super(model, template);
        this.items = items;
    }

    @Override
    public void generate() throws GeneratorException {
        for (T item : items) {
            Logger.getLogger(this.getClass().getCanonicalName()).log(Level.INFO,
                    "Generating output for " + item);
            generate(item);
        }
    }

    protected void generate(T item) throws GeneratorException {
        PrintWriter writer = createWriter(getOutputFileName(item));

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("item", item);
        params.put("name", formatName(item.getName(), getTemplate()));

        generate(writer, params);
        writer.close();
    }

    protected String getOutputFileName(T item) {
        return getOutputDirectory() + formatName(item.getName(), getTemplate()) + "." + getExtension();
    }
}

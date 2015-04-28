package sk.tuke.magsa.tools.generator;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import sk.tuke.magsa.tools.metamodel.Model;

public class ApplicationGenerator extends JavaTemplateGenerator {
    public ApplicationGenerator(Model model) {
        super(model, "app");
    }

    @Override
    public void generate() throws GeneratorException {
        PrintWriter writer = createWriter(getOutputFileName());

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", formatName(null, getTemplate()));

        generate(writer, params);
        writer.close();
    }

    protected String getOutputFileName() {
        return getOutputDirectory() + formatName(null, getTemplate()) + "." + getExtension();
    }
}

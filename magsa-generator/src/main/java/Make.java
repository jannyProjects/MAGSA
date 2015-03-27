import java.io.File;
import java.io.FileReader;
import sk.tuke.magsa.tools.builder.ConstraintBuilder;
import sk.tuke.magsa.tools.generator.CollectionTemplateGenerator;
import sk.tuke.magsa.tools.generator.DatabaseScriptGenerator;

import sk.tuke.magsa.tools.metamodel.*;
import sk.tuke.magsa.tools.parser.*;
import sk.tuke.magsa.tools.parserext.Parser;
//import sk.tuke.magsa.tools.parserext.Parser;

public class Make {
    public static void main(String[] args) throws Exception {
        
        /*Model model;

        File dir = new File("model/entities");
        LineParser parser = new LineParser();
        model = parser.parseDir(dir);

        System.out.println(model);
        
        
        ConstraintBuilder builder = new PersonalistikaObmedzenia();
        builder.compose(model);
        
        new CollectionTemplateGenerator<Entity>(model, "entity_class", model.getEntities()).generate();
        new CollectionTemplateGenerator<Entity>(model, "dao_interface", model.getEntities()).generate();
        new CollectionTemplateGenerator<Entity>(model, "dao_impl", model.getEntities()).generate();
    
        new DatabaseScriptGenerator(model).generate();*/
        
        
        
        
        
        
        
        
        Model model;

    
        Parser parserext = new Parser();
        model = parserext.parse(new FileReader("model/model.el"));

        System.out.println(model);
        
        new CollectionTemplateGenerator<Entity>(model, "entity_class", model.getEntities()).generate();
        new CollectionTemplateGenerator<Entity>(model, "dao_interface", model.getEntities()).generate();
        new CollectionTemplateGenerator<Entity>(model, "dao_impl", model.getEntities()).generate();
    
        new DatabaseScriptGenerator(model).generate();

    }
}

package sk.tuke.magsa.tools.generator;

import java.io.PrintWriter;
import sk.tuke.magsa.tools.metamodel.Entity;
import sk.tuke.magsa.tools.metamodel.Model;
import sk.tuke.magsa.tools.metamodel.Property;
import sk.tuke.magsa.tools.metamodel.Reference;
import sk.tuke.magsa.tools.metamodel.Type;
import sk.tuke.magsa.tools.metamodel.constraints.Length;
import sk.tuke.magsa.tools.metamodel.constraints.Range;
import sk.tuke.magsa.tools.metamodel.constraints.Required;

//SEE ALSO: Transformer Generation
//http://martinfowler.com/dslwip/TransformerGeneration.html
public class DatabaseScriptGenerator extends Generator {
    public DatabaseScriptGenerator(Model model) {
        super(model);
    }

    @Override
    public void generate() throws GeneratorException {
        
        int property_count;
        int count=0;
        Type type=null;
        int maxLength = 0;
        int minLength = 0;
        int maxValue = 0;
        int minValue = 0;
        
        PrintWriter out = createWriter(getResourcesDestinationDir() + "/database.sql");

        for (Entity entity : getModel().getEntities()) {
            out.printf("CREATE TABLE %s (\n", entity.getName());
            out.printf("  ident INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY");
            
            if(entity.getOutgoingReferences() != null)
            {
                for(Reference r : entity.getOutgoingReferences())
                {
                out.printf(",\n ident_"+r.getTo().getName()+" INTEGER");
                }
            }
            
            property_count=entity.getProperties().length;
                        
            while(count<property_count)
            {
                type=entity.getProperties()[count].getType();
                
                switch(type)
                {
                    case INTEGER:
                        out.printf(",\n %s INTEGER", entity.getProperties()[count].getName());
                        if(entity.getProperties()[count].getConstraints() != null)
                         {
                             if(entity.findProperty(entity.getProperties()[count].getName()).hasConstraint(Required.class) == true)
                             {
                                 out.printf(" NOT NULL ");
                             }
                             if(entity.findProperty(entity.getProperties()[count].getName()).hasConstraint(Range.class) == true)
                             {
                                 maxValue = entity.findProperty(entity.getProperties()[count].getName()).getConstraint(Range.class).getMaxValue();
                                 minValue = entity.findProperty(entity.getProperties()[count].getName()).getConstraint(Range.class).getMinValue();
                                 out.printf(" CHECK(%s BETWEEN %d AND %d) ",entity.getProperties()[count].getName(), minValue,maxValue);
                             }
                         }                        
                        break;
                    case REAL:
                         out.printf(",\n %s REAL", entity.getProperties()[count].getName());
                         if(entity.getProperties()[count].getConstraints() != null)
                         {
                             if(entity.findProperty(entity.getProperties()[count].getName()).hasConstraint(Required.class) == true)
                             {
                                 out.printf(" NOT NULL");
                             }
                         }
                        break;
                    case STRING: 
                         if(entity.getProperties()[count].getConstraints() != null)
                         {
                             if(entity.findProperty(entity.getProperties()[count].getName()).hasConstraint(Length.class) == true)
                             {
                                 maxLength = entity.findProperty(entity.getProperties()[count].getName()).getConstraint(Length.class).getMaxLength();
                                 minLength = entity.findProperty(entity.getProperties()[count].getName()).getConstraint(Length.class).getMinLength();
                                 
                                 System.out.println(maxLength+"+"+minLength);
                                 
                                 out.printf(",\n %s VARCHAR(%d)", entity.getProperties()[count].getName(),maxLength);   
                                 
                                 if(minLength != 0)
                                 {
                                     out.printf("CHECK(>%d)",minLength);
                                 }
                             }
                         }
                         else
                         {
                         out.printf(",\n %s VARCHAR(100)", entity.getProperties()[count].getName());                        
                         }
                         if(entity.getProperties()[count].getConstraints() != null)
                         {
                             if(entity.findProperty(entity.getProperties()[count].getName()).hasConstraint(Required.class) == true)
                             {
                                 out.printf(" NOT NULL");
                             }
                         }
                             
                        break;
                    default:
                        break;
                }
                
                count++;
            }
                count=0;


            out.println("\n);\n");
        }
        if(getModel().getReferences() != null)
        {
            for(Reference r : getModel().getReferences())
            {
                out.print("ALTER TABLE "+r.getFrom().getName()+" ADD CONSTRAINT "+r.getTo().getName()+"_fkey FOREIGN KEY (ident_"+
                        r.getTo().getName()+") REFERENCES " + r.getTo().getName()+"(ident)");
            }
        }
        
        out.close();
    }

}

package sk.tuke.magsa.tools.metamodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.annotation.Range;
import yajco.annotation.reference.Identifier;

public class Entity implements Named {
    @Identifier
    private final String name;
    
    private final Property[] properties;
    private List<Reference> outgoingReferences = new ArrayList<Reference>();

   @Before("entity")
    public Entity(String name, @Before("{") @After("}") @Range(minOccurs=1) Property[] properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public Property[] getProperties() {
        return properties;
    }
   
    @Override
    public String toString() {
        return "entity " + name + " " + Arrays.toString(properties);
    }
    
    public Property findProperty(String name)
    {
        Property result = null;
        
        for(Property p : properties)
        {
            if(p.getName().equalsIgnoreCase(name))
            {
                result=p;
            }
        }
        return result;
    }
    
    public Reference[] getOutgoingReferences()
    {
        return outgoingReferences.toArray(new Reference[outgoingReferences.size()]);
    }
    
    public void addOutgoingReference(Reference reference)
    {
        outgoingReferences.add(reference);
    }

}

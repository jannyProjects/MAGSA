package sk.tuke.magsa.tools.metamodel;

import java.util.Arrays;
import yajco.annotation.Exclude;
import yajco.annotation.Range;


public class Model {
    private final Entity[] entities;
    private Reference[] reference = null;
 
    @Exclude
    public Model(Entity[] entities) {
        this.entities = entities;      
    }
    
    public Model(@Range(minOccurs=1)Entity[] entities, Reference[] references)
    {
        this.entities = entities;
        this.reference = references;
    }

    public Entity[] getEntities() {
        return entities;
    }

    @Override
    public String toString() {
        return "model " + Arrays.toString(entities);
    }
    
    public Entity findEntity(String name)
    {
        Entity result = null;
        
        for(Entity e : entities)
        {
            if(e.getName().equalsIgnoreCase(name) == true)
            {
                result = e;
            }
        }
        
        return result;     
    }
    
    public  Reference[] getReferences()
    {
        return reference;
    }
}
 
package sk.tuke.magsa.tools.metamodel;

import sk.tuke.magsa.tools.metamodel.constraints.Constraint;
import yajco.annotation.Before;
import yajco.annotation.Exclude;
import yajco.annotation.Separator;
import yajco.annotation.reference.Identifier;

public class Property implements Named {
    
    private Constraint[] constraints = null;
    @Identifier(unique = "../sk.tuke.magsa.tools.metamodel.Property")
    private final String name;
    private Type typ = Type.STRING;
    
    
    @Exclude
    public Property(String name) {
        this.name = name;       
    }
    
    @Exclude
     public Property (String name, Type type)
    {
        this.name = name;
        this.typ = type;
    }
     
     public Property(String name,@Before(":") Type type,@Separator(",") Constraint[] constraints)
     {
         this.name = name;
         this.typ=type;
         this.constraints = constraints;
     }


    public String getName() {
        return name;
    }
    
    public Type getType()
    {
        return this.typ;
    }
    
    public String getTypeToString()
    {
        return this.typ.toString().toLowerCase();
    }

    @Override
    public String toString() {
        return name + ":" + typ.toString();
    }

    /**
     * @return the constraints
     */
    public Constraint[] getConstraints() {
        return constraints;
    }

    /**
     * @param constraints the constraints to set
     */
    public void setConstraints(Constraint[] constraints) {
        this.constraints = constraints;
    }
    
    public <T extends Constraint> T getConstraint(Class<T> clazz)
    {
        Constraint result = null;
        
        for(Constraint c : constraints)
        {
            if(c.getClass() == clazz)
            {
                result = c;
            }
        }
        return (T)result;
    }
    
    public boolean hasConstraint(Class<? extends Constraint> clazz)
    {
        boolean result = false;
        for(Constraint c : constraints)
        {
            if(c.getClass() == clazz)
            {
                result = true;
            }
        }
        return result;        
    }

}

package sk.tuke.magsa.tools.metamodel.constraints;

import sk.tuke.magsa.tools.metamodel.Type;

public abstract class Constraint {   
    
    public abstract boolean supportsType(Type type);

}

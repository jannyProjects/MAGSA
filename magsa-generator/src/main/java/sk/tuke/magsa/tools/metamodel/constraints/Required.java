package sk.tuke.magsa.tools.metamodel.constraints;

import sk.tuke.magsa.tools.metamodel.Type;
import yajco.annotation.Before;

public class Required extends Constraint {

    @Before("required")
    public Required() {
    }

    @Override
    public String toString() {
        return "required";
    }

    @Override
    public boolean supportsType(Type type) {
        if(type.toString().equalsIgnoreCase("integer")||type.toString().equalsIgnoreCase("real") || type.toString().equalsIgnoreCase("string") )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

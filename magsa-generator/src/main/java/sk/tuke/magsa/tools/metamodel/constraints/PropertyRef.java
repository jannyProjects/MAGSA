package sk.tuke.magsa.tools.metamodel.constraints;

import java.util.Arrays;

public class PropertyRef {
    private final String name;

    private final Constraint[] constraints;

    public PropertyRef(String name, Constraint... constraints) {
        this.name = name;
        this.constraints = constraints;
    }

    public String getName() {
        return name;
    }

    public Constraint[] getConstraints() {
        return constraints;
    }

    @Override
    public String toString() {
        return name + " constraints " + Arrays.toString(constraints);
    }
}

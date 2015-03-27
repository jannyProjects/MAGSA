package sk.tuke.magsa.tools.metamodel.constraints;

import java.util.Arrays;

public class EntityRef {
    private final String name;

    private final PropertyRef[] properties;

    public EntityRef(String name, PropertyRef... properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public PropertyRef[] getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "entity_ref " + name + " " + Arrays.toString(properties);
    }    
}

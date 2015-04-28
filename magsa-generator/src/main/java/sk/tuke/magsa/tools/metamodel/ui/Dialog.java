package sk.tuke.magsa.tools.metamodel.ui;

import java.util.Arrays;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlTransient;
import sk.tuke.magsa.tools.metamodel.Entity;
import sk.tuke.magsa.tools.metamodel.Named;


public abstract class Dialog implements Named {
    private String name;

    private String entityName;

    private Entity entity;

    private String label;

    private Component[] components;

    @XmlID
    @XmlAttribute(name="name", required = true)
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name="entity", required = true)
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }


    @XmlAttribute(name="label", required = true)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @XmlTransient
    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @XmlTransient
    public Component[] getComponents() {
        return components;
    }

    public void setComponents(Component[] components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return components != null ? Arrays.toString(components) : "";
    }
}

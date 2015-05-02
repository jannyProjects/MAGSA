package sk.tuke.magsa.tools.metamodel.ui;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import sk.tuke.magsa.tools.metamodel.Property;

@XmlTransient
public abstract class Component {
    private String propertyName;

    private String label;

    private Property property;


    @XmlAttribute(name = "property", required = true)
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }


    @XmlAttribute(name = "label")
    public String getLabel() {
        if (label == null) {
            return propertyName;
        }
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    @XmlTransient
    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}

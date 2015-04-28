package sk.tuke.magsa.tools.metamodel.ui;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;


public class Form extends Dialog {
    
    @XmlElements({
        @XmlElement(name = "field", type = Field.class),
        @XmlElement(name = "lookupField", type = LookupField.class)
    })
    public Field[] getFields() {
        return (Field[]) getComponents();
    }

    public void setFields(Field[] fields) {
        setComponents(fields);
    }

    @Override
    public String toString() {
        return "form " + getName() + " " + super.toString();
    }
}

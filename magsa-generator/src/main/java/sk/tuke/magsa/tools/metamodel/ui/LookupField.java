package sk.tuke.magsa.tools.metamodel.ui;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;

public class LookupField extends Field {
    private Table table;

    
    @XmlAttribute(name = "table", required = true)
    @XmlIDREF
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}

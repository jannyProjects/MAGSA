package sk.tuke.magsa.tools.metamodel.ui;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlIDREF;



public class Table extends Dialog {
    private Form editForm;


    @XmlElements({
    @XmlElement(name = "column", type = Column.class),
    @XmlElement(name = "lookupColumn", type = LookupColumn.class)
    })
    public Column[] getColumns() {
        return (Column[]) getComponents();
    }

    public void setColumns(Column[] columns) {
        setComponents(columns);
    }


    @XmlAttribute(name = "editFormDialog", required = true)
    @XmlIDREF
    public Form getEditForm() {
        return editForm;
    }

    public void setEditForm(Form editForm) {
        this.editForm = editForm;
    }

    @Override
    public String toString() {
        return "table " + getName() + " " + super.toString();
    }
}

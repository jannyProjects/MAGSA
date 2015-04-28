package sk.tuke.magsa.tools.metamodel.ui;

import java.util.Arrays;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://kpi.fei.tuke.sk/magsa")
public class UI {
    private Form[] forms;

    private Table[] tables;

    @XmlElement(name = "form")
    public Form[] getForms() {
        return forms;
    }

    public void setForms(Form[] forms) {
        this.forms = forms;
    }

    @XmlElement(name = "table")
    public Table[] getTables() {
        return tables;
    }

    public void setTables(Table[] tables) {
        this.tables = tables;
    }

    public Form findForm(String name) {
        for (Form form : forms) {
            if (name.equals(form.getName())) {
                return form;
            }
        }
        return null;
    }

    public Table findTable(String name) {
        for (Table table : tables) {
            if (name.equals(table.getName())) {
                return table;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return (forms != null ? Arrays.toString(forms) : "") + " "
                + (tables != null ? Arrays.toString(tables) : "");
    }
}

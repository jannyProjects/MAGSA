package sk.tuke.magsa.tools.metamodel.ui;

import javax.xml.bind.annotation.XmlAttribute;


public class Column extends Component {
    private Integer length;

    @XmlAttribute(name = "length")
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "column " + getPropertyName();
    }
}

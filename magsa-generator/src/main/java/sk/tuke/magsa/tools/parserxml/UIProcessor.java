package sk.tuke.magsa.tools.parserxml;

import java.io.File;
import java.io.Reader;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import sk.tuke.magsa.tools.metamodel.Entity;
import sk.tuke.magsa.tools.metamodel.Model;
import sk.tuke.magsa.tools.metamodel.Property;
import sk.tuke.magsa.tools.metamodel.ui.Component;
import sk.tuke.magsa.tools.metamodel.ui.Dialog;
import sk.tuke.magsa.tools.metamodel.ui.Field;
import sk.tuke.magsa.tools.metamodel.ui.LookupColumn;
import sk.tuke.magsa.tools.metamodel.ui.LookupField;
import sk.tuke.magsa.tools.metamodel.ui.UI;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UIProcessor {
    private UI ui;

    private Model model;

    public UIProcessor(Reader xmlReader, File schemaFile) throws UIProcessingException {
        try {
            JAXBContext jc = JAXBContext.newInstance("sk.tuke.magsa.tools.metamodel.ui", this.getClass().getClassLoader());
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            // Turn on validation
            unmarshaller.setSchema(SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(schemaFile));
            // Unmarshall
            ui = (UI) unmarshaller.unmarshal(xmlReader);
        } catch (SAXException e) {
            throw new UIProcessingException("Cannot process xml input", e);
        } catch (JAXBException e) {
            throw new UIProcessingException("Cannot process xml input", e);
        }
    }

    public UI getUi() {
        return ui;
    }

    public void compose(Model model) throws UIProcessingException {
        this.model = model;
        validate();
        model.setUi(ui);
    }

    private void validate() throws UIProcessingException {
        validate(ui.getTables());
        validate(ui.getForms());
    }

    private void validate(Dialog[] dialogs) throws UIProcessingException {
        Property prop = null;
        for(Dialog d : dialogs)
        {
            Entity entita = model.findEntity(d.getEntityName());
            System.out.println("ENTITA "+d.getEntityName());
            if(entita == null)
            {
                throw new UIProcessingException("Entita return NULL!");
            }
            for (Component c : d.getComponents())
            {               
                
               if(c instanceof LookupField)
                { //System.out.println("LOOPUPFIELD");
                    
                    LookupField field = (LookupField) c;
                    field.getTable().setEntity(model.findEntity(field.getTable().getEntityName()));
                    prop = field.getTable().getEntity().findProperty(c.getPropertyName());
                    System.out.println("FPROP:"+c.getPropertyName());
                    if(prop != null)
                    {
                        field.setProperty(prop);
                    }
                    else
                    {
                        throw new UIProcessingException("Lookfield error");
                    }
                }
                else if (c instanceof LookupColumn)
                {
                    //System.out.println("LOOPUPC");
                    LookupColumn column = (LookupColumn) c;
                    column.setEntity(model.findEntity(column.getEntityName()));
                    prop = column.getEntity().findProperty(c.getPropertyName());
                    System.out.println("CPROP:"+c.getPropertyName());
                    if(prop != null)
                    {
                        column.setProperty(prop);
                    }
                    else
                    {
                        throw new UIProcessingException("Lookfcolumn error");
                    }
                }
                else
                {
                    System.out.println("PROP:"+c.getPropertyName());
                    prop = entita.findProperty(c.getPropertyName());
                    if (prop != null) 
                    {
                        c.setProperty(prop);                        
                    }
                    else 
                    {
                        throw new UIProcessingException("ERROR");
                    }
                }
            }
        }
    }
}

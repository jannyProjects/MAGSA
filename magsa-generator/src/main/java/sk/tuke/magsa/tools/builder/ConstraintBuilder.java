package sk.tuke.magsa.tools.builder;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.magsa.tools.metamodel.Entity;
import sk.tuke.magsa.tools.metamodel.Model;
import sk.tuke.magsa.tools.metamodel.Property;
import sk.tuke.magsa.tools.metamodel.constraints.Constraint;
import sk.tuke.magsa.tools.metamodel.constraints.EntityRef;
import sk.tuke.magsa.tools.metamodel.constraints.Length;
import sk.tuke.magsa.tools.metamodel.constraints.PropertyRef;
import sk.tuke.magsa.tools.metamodel.constraints.Range;
import sk.tuke.magsa.tools.metamodel.constraints.Regex;
import sk.tuke.magsa.tools.metamodel.constraints.Required;

//SEE ALSO: Nested Function
//http://martinfowler.com/dslwip/NestedFunction.html
public abstract class ConstraintBuilder {
    private List<EntityRef> entities = new ArrayList<EntityRef>();

    private Model model;

    protected abstract void define();

    public void compose(Model model) throws ConstraintProcessingException {
        this.model = model;
        define();
        validate();
    }

    protected void entity_ref(String name, PropertyRef... properties) {
        entities.add(new EntityRef(name, properties));
    }

    protected PropertyRef property_ref(String name, Constraint... constraints) {
        return new PropertyRef(name, constraints);
    }

    protected Required required() {
        return new Required();
    }

    private void validate() throws ConstraintProcessingException {
        ArrayList<Constraint> con = new ArrayList<Constraint>();
        for (EntityRef e : entities)
        {
            if((model.findEntity(e.getName())) !=null)
            {
                System.out.println(model.findEntity(e.getName()));
                for(PropertyRef p : e.getProperties())
                {
                    System.out.println(model.findEntity(e.getName()).findProperty(p.getName()));
                    if(model.findEntity(e.getName()).findProperty(p.getName()) != null)
                    {
                        for(Constraint c : p.getConstraints())
                        {
                            //System.out.println(model.findEntity(e.getName()).findProperty(p.getName()).getConstraints());
                            System.out.println(c);
                            if(c == null)
                            {
                                throw new ConstraintProcessingException("Wrong Constraints");
                            }
                            else
                            {
                                if(c.supportsType(model.findEntity(e.getName()).findProperty(p.getName()).getType()) == true)
                                {                                    
                                con.add(c);
                                model.findEntity(e.getName()).findProperty(p.getName()).setConstraints(p.getConstraints());
                                }
                                else
                                {
                                    throw new ConstraintProcessingException("Propertie "+p.getName()+"does wrong constraint type.");
                                }
                            }
                        }
                    }
                    else
                    {
                        throw new ConstraintProcessingException("Propertie "+p.getName()+"doesnt exist.");
                    }
                }
            }
            else
            {
                throw new ConstraintProcessingException("Entity "+e.getName()+"doesnt exist.");
            }
        }
    }
    
    public Length length(int minLength, int maxLength)
    {
        return new Length(minLength, maxLength);
    }
    
    public Length min_length(int minLength)
    {
        return new Length(minLength, Integer.MAX_VALUE);
    }
    
    protected Length max_length(int maxLength)
    {
        return new Length(0, maxLength);
    }
    
    public Range range(int minValue, int maxValue)
    {
        return new Range(minValue, maxValue);
    }
    
    public Regex regex(String regex)
    {
        return new Regex(regex);
    }
}

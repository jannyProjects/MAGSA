package sk.tuke.magsa.tools.metamodel;

import yajco.annotation.Before;
import yajco.annotation.Token;
import yajco.annotation.reference.References;


public class Reference {
    private Entity from;
    private Entity to;

    @Before("reference")
    public Reference(
            @References(value = Entity.class, field = "from") @Token("NAME") String from,
            @References(value = Entity.class, field = "to") @Token("NAME") String to) {
    }

    public Entity getFrom() {
        return from;
    }

    public void setFrom(Entity from) {
        this.from = from;
        from.addOutgoingReference(this);
    }

    public Entity getTo() {
        return to;
    }

    public void setTo(Entity to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "reference from " + from.getName() + " to " + to.getName();
    }
}

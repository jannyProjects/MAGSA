package sk.tuke.magsa.framework;

import java.io.Serializable;

public abstract class Entity implements Serializable {
    private Integer ident;

    public Integer getIdent() {
        return ident;
    }

    public void setIdent(Integer ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[ident = " + ident + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Entity object = (Entity) obj;
        if (ident == null) {
            return this == obj;
        }

        return ident.equals(object.ident);
    }

    @Override
    public int hashCode() {
        return ident == null ? super.hashCode() : ident.hashCode();
    }
}

package sk.tuke.magsa.framework.ui;

import sk.tuke.magsa.framework.Entity;

public abstract class FormDialog<T extends Entity> {
    protected T entity;

    public FormDialog(T entity) {
        this.entity = entity;
    }

    public abstract T show();
}

package sk.tuke.magsa.framework.ui;

import java.util.List;
import sk.tuke.magsa.framework.CRUDDao;
import sk.tuke.magsa.framework.Entity;
import sk.tuke.magsa.framework.Utilities;

public abstract class TableDialog<T extends Entity> {
    private final CRUDDao<T> dao;

    public TableDialog(CRUDDao<T> dao) {
        this.dao = dao;
    }

    public void menu() {
        int selection = 0;
        do {
            printMenu();
            try {
                selection = Integer.parseInt(Utilities.readLine());
            } catch (NumberFormatException e) {
                //Do nothing, repeat loop
            }

            switch (selection) {
                case 1:
                    display();
                    break;
                case 2:
                    create();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    remove();
                    break;
            }
        } while (selection != 5);
    }

    public T selection() {
        printTable(dao.selectAll());
        return selectEntity();
    }

    protected void printMenu() {
        System.out.println("(1) Display");
        System.out.println("(2) Create");
        System.out.println("(3) Edit");
        System.out.println("(4) Remove");
        System.out.println("(5) Return");
        System.out.println("Enter selection: ");
    }

    public void display() {
        printTable(dao.selectAll());
    }

    public void create() {
        T entity = createFormDialogForInsert().show();
        dao.create(entity);
    }

    public void edit() {
        T entity = selectEntity();
        if (entity != null) {
            createFormDialogForEdit(entity).show();
            dao.edit(entity);
        }
    }

    public void remove() {
        T entity = selectEntity();
        if (entity != null) {
            dao.remove(entity);
        }
    }

    protected T selectEntity() {
        T entity = null;
        do {
            System.out.println("Enter identifier [empty string = no selection]: ");
            String input = Utilities.readLine();
            if ("".equals(input)) {
                return null;
            }
            Integer id = null;
            try {
                id = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                continue;
            }
            entity = dao.find(id);            
        } while (entity == null);
        return entity;
    }

    public void printTable(List<T> list) {
        printHeader();
        for (T entity : list) {
            printRow(entity);
        }
    }

    protected abstract FormDialog<T> createFormDialogForInsert();

    protected abstract FormDialog<T> createFormDialogForEdit(T entity);

    protected abstract void printHeader();

    protected abstract void printRow(T entity);
}

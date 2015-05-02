package sk.tuke.magsa.personalistika.ui;

import sk.tuke.magsa.framework.ui.TableDialog;
import sk.tuke.magsa.personalistika.Application;
import sk.tuke.magsa.personalistika.entity.Oddelenie;

public class OddelenieTable extends TableDialog<Oddelenie> {
    public OddelenieTable() {
        super(Application.getInstance().getOddelenieDaoImpl());
    }

    protected OddelenieForm createFormDialogForInsert() {
        return new OddelenieForm();
    }

    protected OddelenieForm createFormDialogForEdit(Oddelenie entity) {
        return new OddelenieForm(entity);
    }

    protected void printHeader() {
     System.out.print(String.format(" |%10s", "nazov"));

System.out.print(String.format(" |%10s", "kod"));

System.out.print(String.format(" |%5s", "uroven"));

        System.out.println();
    }

    protected void printRow(Oddelenie entity) {
          
System.out.print(String.format(" |%10s", entity.getNazov()));



System.out.print(String.format(" |%10s", entity.getKod()));



System.out.print(String.format(" |%5f", entity.getUroven()));


System.out.println();
    }
}
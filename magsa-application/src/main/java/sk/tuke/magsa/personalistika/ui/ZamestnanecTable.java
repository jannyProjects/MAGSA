package sk.tuke.magsa.personalistika.ui;

import sk.tuke.magsa.framework.ui.TableDialog;
import sk.tuke.magsa.personalistika.Application;
import sk.tuke.magsa.personalistika.entity.Zamestnanec;

public class ZamestnanecTable extends TableDialog<Zamestnanec> {
    public ZamestnanecTable() {
        super(Application.getInstance().getZamestnanecDaoImpl());
    }

    protected ZamestnanecForm createFormDialogForInsert() {
        return new ZamestnanecForm();
    }

    protected ZamestnanecForm createFormDialogForEdit(Zamestnanec entity) {
        return new ZamestnanecForm(entity);
    }

    protected void printHeader() {
     System.out.print(String.format(" |%10s", "Priezvisko"));

System.out.print(String.format(" |%10s", "Meno"));

System.out.print(String.format(" |%5s", "Vek"));

System.out.print(String.format(" |%10s", "Oddelenie"));

        System.out.println();
    }

    protected void printRow(Zamestnanec entity) {
          
System.out.print(String.format(" |%10s", entity.getPriezvisko()));

System.out.println();

System.out.print(String.format(" |%10s", entity.getMeno()));

System.out.println();

System.out.print(String.format(" |%5d", entity.getVek()));

System.out.println();

System.out.print(String.format(" |%10s", entity.getOddelenie()));

System.out.println();
    }
}
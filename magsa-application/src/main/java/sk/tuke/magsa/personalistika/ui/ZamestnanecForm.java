package sk.tuke.magsa.personalistika.ui;

import sk.tuke.magsa.framework.Utilities;
import sk.tuke.magsa.framework.ValidatorException;
import sk.tuke.magsa.framework.ui.FormDialog;
import sk.tuke.magsa.personalistika.entity.Zamestnanec;

public class ZamestnanecForm extends FormDialog<Zamestnanec>{


    public ZamestnanecForm() {
        super(new Zamestnanec());
    }

    public ZamestnanecForm(Zamestnanec entity) {
        super(entity);
    }

    public Zamestnanec show() {
        String input;


String priezvisko = entity.getPriezvisko();

do {
        try {
            System.out.print(String.format("Enter nazov [%s]: ", entity.getPriezvisko()));
            input = Utilities.readLine();
            if(!"".equals(input)) {
priezvisko = input;
                
            }
            




            
            break;
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse the entered value!");
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
        }
    } while (true);
    entity.setPriezvisko(priezvisko);



String meno = entity.getMeno();

do {
        try {
            System.out.print(String.format("Enter nazov [%s]: ", entity.getMeno()));
            input = Utilities.readLine();
            if(!"".equals(input)) {
meno = input;
                
            }
            




            
            break;
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse the entered value!");
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
        }
    } while (true);
    entity.setMeno(meno);



Integer vek = entity.getVek();

do {
        try {
            System.out.print(String.format("Enter nazov [%s]: ", entity.getVek()));
            input = Utilities.readLine();
            if(!"".equals(input)) {
vek = Integer.valueOf(input);
                
            }
            


            
            break;
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse the entered value!");
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
        }
    } while (true);
    entity.setVek(vek);





        return entity;
    }
}

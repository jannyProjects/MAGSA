package sk.tuke.magsa.personalistika.ui;

import sk.tuke.magsa.framework.Utilities;
import sk.tuke.magsa.framework.ValidatorException;
import sk.tuke.magsa.framework.ui.FormDialog;
import sk.tuke.magsa.personalistika.entity.Oddelenie;

public class OddelenieForm extends FormDialog<Oddelenie>{


    public OddelenieForm() {
        super(new Oddelenie());
    }

    public OddelenieForm(Oddelenie entity) {
        super(entity);
    }

    public Oddelenie show() {
        String input;


String nazov = entity.getNazov();

do {
        try {
            System.out.print(String.format("Enter nazov [%s]: ", entity.getNazov()));
            input = Utilities.readLine();
            if(!"".equals(input)) {
nazov = input;
                
            }
            




            
            break;
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse the entered value!");
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
        }
    } while (true);
    entity.setNazov(nazov);



String kod = entity.getKod();

do {
        try {
            System.out.print(String.format("Enter nazov [%s]: ", entity.getKod()));
            input = Utilities.readLine();
            if(!"".equals(input)) {
kod = input;
                
            }
            




            
            break;
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse the entered value!");
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
        }
    } while (true);
    entity.setKod(kod);


        return entity;
    }
}

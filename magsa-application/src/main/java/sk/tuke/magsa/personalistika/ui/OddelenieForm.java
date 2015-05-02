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

////////////


String nazov = entity.getNazov();



do{
    try {
        System.out.print(String.format("Enter nazov [%s]: ", entity.getNazov()));
        input = Utilities.readLine();
        if(!"".equals(input)) 
        {
                                    nazov = input;
                                }
  

if(nazov == null)
{
    throw new ValidatorException ("This property must be define: nazov");
}
if(entity.getNazov() != null)
{
    if(entity.getNazov().length() > 5 &&
        entity.getNazov().length() < 30 )
    {        
    }
    else
    {
        throw new ValidatorException ("Wrong property length nazov: value must be from 5 to 30");
    }
}

   
 

            
        break;
        } 
catch (NumberFormatException e) 
{
    System.out.println("Cannot parse the entered value!");
} 
catch (ValidatorException e) 
{
    System.out.println(e.getMessage());
}
    } while (true);

    entity.setNazov(nazov);

////////////


String kod = entity.getKod();



do{
    try {
        System.out.print(String.format("Enter kod [%s]: ", entity.getKod()));
        input = Utilities.readLine();
        if(!"".equals(input)) 
        {
                                    kod = input;
                                }
  

if(kod == null)
{
    throw new ValidatorException ("This property must be define: kod");
}
if(entity.getKod() != null)
{
    if(entity.getKod().length() > 1 &&
        entity.getKod().length() < 4 )
    {        
    }
    else
    {
        throw new ValidatorException ("Wrong property length kod: value must be from 1 to 4");
    }
}

   
 

            
        break;
        } 
catch (NumberFormatException e) 
{
    System.out.println("Cannot parse the entered value!");
} 
catch (ValidatorException e) 
{
    System.out.println(e.getMessage());
}
    } while (true);

    entity.setKod(kod);

////////////


Double uroven = entity.getUroven();



do{
    try {
        System.out.print(String.format("Enter uroven [%s]: ", entity.getUroven()));
        input = Utilities.readLine();
        if(!"".equals(input)) 
        {
                                    uroven = Double.valueOf(input);
                                }
  


            
        break;
        } 
catch (NumberFormatException e) 
{
    System.out.println("Cannot parse the entered value!");
} 
catch (ValidatorException e) 
{
    System.out.println(e.getMessage());
}
    } while (true);

    entity.setUroven(uroven);

///////////////




        return entity;
    }
}

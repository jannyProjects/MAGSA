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

////////////


String priezvisko = entity.getPriezvisko();



do{
    try {
        System.out.print(String.format("Enter priezvisko [%s]: ", entity.getPriezvisko()));
        input = Utilities.readLine();
        if(!"".equals(input)) 
        {
                                    priezvisko = input;
                                }
  

if(priezvisko == null)
{
    throw new ValidatorException ("This property must be define: priezvisko");
}
if(entity.getPriezvisko() != null)
{
    if(entity.getPriezvisko().length() > 2 &&
        entity.getPriezvisko().length() < 30 )
    {        
    }
    else
    {
        throw new ValidatorException ("Wrong property length priezvisko: value must be from 2 to 30");
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

    entity.setPriezvisko(priezvisko);

////////////


String meno = entity.getMeno();



do{
    try {
        System.out.print(String.format("Enter meno [%s]: ", entity.getMeno()));
        input = Utilities.readLine();
        if(!"".equals(input)) 
        {
                                    meno = input;
                                }
  

if(meno == null)
{
    throw new ValidatorException ("This property must be define: meno");
}
if(entity.getMeno() != null)
{
    if(entity.getMeno().length() > 2 &&
        entity.getMeno().length() < 30 )
    {        
    }
    else
    {
        throw new ValidatorException ("Wrong property length meno: value must be from 2 to 30");
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

    entity.setMeno(meno);

////////////


Integer vek = entity.getVek();



do{
    try {
        System.out.print(String.format("Enter vek [%s]: ", entity.getVek()));
        input = Utilities.readLine();
        if(!"".equals(input)) 
        {
                        vek = Integer.valueOf(input);
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

    entity.setVek(vek);

////////////

Integer ref_Oddelenie = entity.getOddelenie();

do{
    try{
    System.out.print(String.format("Enter reference ID [%s]: ", "Oddelenie"));
    input = Utilities.readLine();

if(!"".equals(input)) 
    {
        ref_Oddelenie = Integer.valueOf(input);
    }
if( ref_Oddelenie ==null)
    {
        throw new ValidatorException("Property reference is required!");
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
}while(true);
entity.setOddelenie(ref_Oddelenie);

//////////////////////////////////////////
///////////////




        return entity;
    }
}

package sk.tuke.magsa.personalistika;

import sk.tuke.magsa.framework.*;
import sk.tuke.magsa.personalistika.dao.*;
import sk.tuke.magsa.personalistika.dao_impl.*;
import sk.tuke.magsa.personalistika.ui.*;

public class Application {

    

    private static Application instance;

    private final ConnectionPool pool = new ConnectionPool();

        private final OddelenieDaoImpl oddelenie = new OddelenieDaoImpl(pool);
        private final ZamestnanecDaoImpl zamestnanec = new ZamestnanecDaoImpl(pool);
    
        public OddelenieDaoImpl getOddelenieDaoImpl()
    {
        return oddelenie;
    }
        public ZamestnanecDaoImpl getZamestnanecDaoImpl()
    {
        return zamestnanec;
    }
    
    public static Application getInstance() {
        return instance;
    }

    private void menu() {
 String selection = null;
	do {
            printMenuHeader();
           
		selection = Utilities.readLine();

            switch (Integer.parseInt(selection)) {
            case 1: new OddelenieTable().menu();
                     break;
            case 2: new ZamestnanecTable().menu();
                     break;
            case 3: System.exit(0);
                     break;

            }
	} while (Integer.parseInt(selection) != 3);

        
    }

private void printMenuHeader() {

System.out.println("(1): Oddelenia");
System.out.println("(2): Zamestnanci");
System.out.println("(3): Ukoncit aplikaciu");
System.out.println("Zadajte volbu: ");
    }

    public static void main(String[] args) {
        instance = new Application();
        instance.menu();
    }    
}

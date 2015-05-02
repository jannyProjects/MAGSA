
import sk.tuke.magsa.framework.ConnectionPool;
import sk.tuke.magsa.personalistika.Application;
import sk.tuke.magsa.personalistika.dao_impl.OddelenieDaoImpl;
import sk.tuke.magsa.personalistika.dao_impl.ZamestnanecDaoImpl;
import sk.tuke.magsa.personalistika.entity.Oddelenie;
import sk.tuke.magsa.personalistika.entity.Zamestnanec;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janny
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnectionPool connect = new ConnectionPool();
        connect.acquire();
        
        Zamestnanec zam = new Zamestnanec();
        Oddelenie od = new Oddelenie();
        
        ZamestnanecDaoImpl zamIml = new ZamestnanecDaoImpl(connect);
        OddelenieDaoImpl odImpl = new OddelenieDaoImpl(connect);
        //System.out.println("toSTRING:"+zam.toString());
        
        //////////////////INSERT///////////////////////////////////
               
        /*od.setIdent(1);
        od.setNazov("Informacne technologie");
        od.setKod("IT");        
        od.setUroven(3.3);
        odImpl.create(od);*/
        
        zam.setIdent(1);
        zam.setOddelenie(1);
        zam.setMeno("Silvia");
        zam.setPriezvisko("Burikova");
        zam.setVek(22);
        zamIml.create(zam);
       //////////////////UPDATE///////////////////////////////////
        /*zam.setIdent(1);
        zam.setOddelenie(1);
        zam.setMeno("Martin");
        zam.setPriezvisko("Hrasko");
        zam.setVek(20);
        zamIml.edit(zam);*/
       //////////////////DELETE///////////////////////////////////
        /*zam.setIdent(1);
        zam.setOddelenie(1);
        zam.setMeno("Martin");
        zam.setPriezvisko("Hrasko");
        zam.setVek(20);
        zamIml.remove(zam);*/
       //////////////////FIND///////////////////////////////////
        //System.out.println("Meno:"+zamIml.find(2).getOddelenie());
        //System.out.println("Oddelenie:"+odImpl.find(1).getNazov());
      //////////////////TABLES///////////////////////////////////
       /*System.out.println("TABULKA ZAMESTNANEC");
        for (Zamestnanec z : zamIml.selectAll()) {
            System.out.println("ID: " + z.getIdent() +" - Meno: " + z.getMeno() + " - Priezvisko: " + z.getPriezvisko() + " - Vek: " + z.getVek());
        }
        System.out.println("TABULKA ODDELENIE");
        for (Oddelenie o : odImpl.selectAll()) {
            System.out.println("ID: " + o.getIdent() +" - Nazov: " + o.getNazov() + " - Kod: " + o.getKod() + " - Poschodie: " + o.getUroven());
        }*/
        
        Application.main(args);
        
       
    }
    
}

package sk.tuke.magsa.personalistika.entity;

import sk.tuke.magsa.framework.Entity;

public class Oddelenie extends Entity {
    private static final long serialVersionUID = 1L;


                       private String nazov;
            public String getNazov() 
            {
                return nazov;
            }


            public void setNazov(String nazov) 
            {
                this.nazov = nazov;
            }
            

                       private String kod;
            public String getKod() 
            {
                return kod;
            }


            public void setKod(String kod) 
            {
                this.kod = kod;
            }
            

                private Double uroven;
            public Double getUroven() 
            {
                return uroven;
            }

            public void setUroven(Double uroven) 
            {
                this.uroven = uroven;
            }

    



            public String toString()
            {
                                                                                                return " nazov:STRING  kod:STRING  uroven:REAL ";
            }
   


}

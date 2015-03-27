// iDSLAddon_start_fold desc="Začnite písať výraz definujúci obmedzenia tu (pre pomoc použite kombináciu Ctrl+Space):"


import sk.tuke.magsa.tools.builder.ConstraintBuilder;

public class PersonalistikaObmedzenia extends ConstraintBuilder {
    
    @Override
    protected void define() {
// iDSLAddon_end_fold
        //entity_ref("name");
        entity_ref("Zamestnanec",
            property_ref("priezvisko",
                    required(),
                max_length(16)
            )
        );
        
        entity_ref("Oddelenie", 
                property_ref("poschodie", 
                        required(),
                        range(2, 5)                        
                        )                             
                );
        
// iDSLAddon_start_fold desc="Výraz končí tu."
    }    
}
// iDSLAddon_end_fold

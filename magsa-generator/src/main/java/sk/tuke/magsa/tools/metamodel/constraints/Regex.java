/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.magsa.tools.metamodel.constraints;

import sk.tuke.magsa.tools.metamodel.Type;

/**
 *
 * @author janny
 */
public class Regex extends Constraint{
    
    private String Regex;

    public Regex(String r) {
        this.Regex=r;
    }

    /**
     * @return the Regex
     */
    public String getRegex() {
        return Regex;
    }

    /**
     * @param Regex the Regex to set
     */
    public void setRegex(String Regex) {
        this.Regex = Regex;
    }

    @Override
    public boolean supportsType(Type type) {
        if(type.toString().equalsIgnoreCase("integer")||type.toString().equalsIgnoreCase("real") || type.toString().equalsIgnoreCase("string") )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    
}

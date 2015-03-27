/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.magsa.tools.metamodel.constraints;

import sk.tuke.magsa.tools.metamodel.Type;
import yajco.annotation.Before;
import yajco.annotation.Token;

/**
 *
 * @author janny
 */
public class Length extends Constraint{
    
    private int maxLength;
    private int minLength;

    @Before("length")
    public Length(@Token("INT_VALUE") int min, @Token("INT_VALUE") int max){
        this.minLength = min;
        this.maxLength = max;
    }  
    

    /**
     * @return the maxLength
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * @param maxLength the maxLength to set
     */
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * @return the minLength
     */
    public int getMinLength() {
        return minLength;
    }

    /**
     * @param minLength the minLength to set
     */
    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public boolean supportsType(Type type) {
        
        if(type.toString().equalsIgnoreCase("string"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    
}

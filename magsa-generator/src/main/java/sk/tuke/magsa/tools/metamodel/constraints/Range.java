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
public class Range extends Constraint{
    
    private int maxValue;
    private int minValue;

    @Before("range")
    public Range(@Token("INT_VALUE") int min, @Token("INT_VALUE")int max) {
        this.minValue=min;
        this.maxValue=max;
    }

    /**
     * @return the maxValue
     */
    public int getMaxValue() {
        return maxValue;
    }

    /**
     * @return the minValue
     */
    public int getMinValue() {
        return minValue;
    }

    @Override
    public boolean supportsType(Type type) {
        
        if(type.toString().equalsIgnoreCase("integer"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
   
    
    
}

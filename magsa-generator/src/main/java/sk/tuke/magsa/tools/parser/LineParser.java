package sk.tuke.magsa.tools.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.tuke.magsa.tools.metamodel.Entity;
import sk.tuke.magsa.tools.metamodel.Model;
import sk.tuke.magsa.tools.metamodel.Property;
import sk.tuke.magsa.tools.metamodel.Type;

public class LineParser {
    private static final char SEPARATOR = ':';
    private static final String REGEX = "([a-zA-Z_$][a-zA-Z0-9_$]*)|([a-zA-Z_$][a-zA-Z0-9_$]*\\s*:\\s*(integer|real|string))";
    private int numberLine = 1;
    private HashSet<String> set = new HashSet<String>();
    
    public Model parseDir(File dir) throws ParserException {
        if (!dir.isDirectory()) {
            throw new ParserException(dir + " is not a directory");
        }

        List<Entity> entities = new ArrayList<Entity>();
        for (File file : dir.listFiles()) {
            entities.add(parse(file));
        }
        return new Model(entities.toArray(new Entity[]{}));
    }

    public Entity parse(File file) throws ParserException {
        try {
            Reader reader = new FileReader(file);
            String name = file.getName();
            name = name.substring(0, name.lastIndexOf('.'));
            return parse(name, reader);
        } catch (IOException e) {
            throw new ParserException("Cannot open file " + file, e);
        }
    }

    private Entity parse(String name, Reader reader) throws ParserException{
        String line = null;
        Property named = null;
        Property[] property;
        ArrayList<Property>  list = new ArrayList<Property>();
        BufferedReader buffRead = new BufferedReader(reader);
        
        try {
            while((line = buffRead.readLine()) != null)
            {
                named = parseLine(line);
                if (named != null){
                    list.add(named);
                    numberLine++;
                }
            }
        } catch (IOException ex) {
            System.err.println("Error on line"+ numberLine);
        }        
        set.clear();
        property = list.toArray(new Property[list.size()]);
        return new Entity(name, property);
    }

     private Property parseLine(String line) throws ParserException {
         
         String final_line = line.trim();
         String data_type = null;
         String name_property = null;
                
         if(final_line.isEmpty() == false){
         
            if(!final_line.startsWith("#")) 
            {
                if(final_line.matches(REGEX) == true)
                {
                if(final_line.contains(Character.toString(SEPARATOR)))
                 {
                     data_type=final_line.substring(final_line.indexOf(Character.toString(SEPARATOR))+1).trim();
                     name_property=final_line.substring(0, (final_line.indexOf(":") - 1));
                     //System.out.println("line"+name_property);
                     if(set.contains(name_property) == false){
                        set.add(name_property);//   
                        if(data_type.equals("string"))
                        {
                            return new Property(name_property,Type.STRING);
                        }
                        if(data_type.equals("integer"))
                        {
                            return new Property(name_property,Type.INTEGER); 
                        }
                        if(data_type.equals("real"))
                        {
                            return new Property(name_property,Type.REAL);
                        }
                        
                     }//
                     else{
                         throw new ParserException("Propertie already existss: " + name_property);
                     }//

                 }
                 else
                 {
                     if(set.contains(final_line) == false){//
                        set.add(final_line);//
                        //System.out.println("line"+final_line);
                        return new Property(final_line,Type.STRING);
                     }//
                     else{//
                         throw new ParserException("Propertie already exists: " + final_line);
                     }//
                 }
             }
                else{
                    throw new ParserException("Wrong syntax on line: " + numberLine);
                }
            }
         }      
         return null;
    }
}

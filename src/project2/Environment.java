/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <p>Stores a map from names of definitions and operations (as Strings)
 * to objects of type Definition and Operation, as well as a list of all
 * procedures.</p>
 *
 * !!We may want to use two maps, one for definitions and one for operations.
 * !!But maybe not
 */
public class Environment {
    HashMap<String, Definition> definitionsAndOperations;
    ArrayList procedures;

    public Environment(){
        definitionsAndOperations = new HashMap();
        procedures = new ArrayList();
    }

    /**
     * Associates name with defObject in the map.
     * @param name The name of the definition
     * @param defObject A reference to the Definition object associated with
     * name.
     */
    public void addDefinition(String name, Definition defObject){
        definitionsAndOperations.put(name, defObject);
    }

    @Override
    public String toString(){
        String r = definitionsAndOperations.toString();
        return r;
    }
}

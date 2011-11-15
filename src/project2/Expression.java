/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project2;

import java.util.Map;

/**
 * <p>An immutable representation of something found in a requires or ensures
 * clause. Represents either a single variable or the application of a single
 * definition to some number of arguments.</p>
 */
public class Expression {

    /**
     * Returns a new Expression with any variable inside it that matches some
     * key in the given map replaced by the value associated with it in the map.
     * All other definition and variable names are left alone.
     */
    public Expression substitute(Map<String, String> map){
        return(new Expression());
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a definition, consisting of a name and a list of arguments.
 */
public class Definition {
    String name;
    ArrayList definitions;

    /**
     * We need to read in all the definitions from the input iterator and store
     * them in e. 
     * @param input Iterator for the input tokens. Should be queued at the start
     * of the file when we get here.
     */
    public static void generateDefinitions(Iterator<String> input, Environment e){
        String currToken, defName;
        ArrayList args = new ArrayList();
        /* This loop runs until we hit "Operation" and leaves the Iterator
         queued there.  */
        while(input.hasNext() && (!(currToken = input.next()).equals("Operation"))){
            if (currToken.equals("Definition")){
                args.clear();
                //Grab definition name
                defName = input.next();
                //Throw out (
                input.next();
                //Add arguments until we hit ")"
                while(!(currToken = input.next()).equals(")")){
                    args.add(currToken);
                }
                //Construct Definition Object and add it to e
                e.addDefinition(defName, new Definition(defName, args));
            }
            else{
                System.out.println("Shouldn't be here!");
            }
        }

    }
    /**
     * Creates a definition object with the associated name and list of
     * arguments and stores it in e.
     * @param name The name of the definition, ie, what is not in ()
     * @param arguments What is in the () for the definition. {} for no args.
     * @param e The environment generated from the input file.
     */
    public Definition(String defName, ArrayList arguments){
        name = defName;
        definitions = new ArrayList(arguments);
    }

    @Override
    public String toString(){
        return(name + definitions.toString());
    }
}

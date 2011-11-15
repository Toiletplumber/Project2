/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jmaggio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Tokenize the input file
        String inputFileName =
                JOptionPane.showInputDialog("Enter input filename");
        File inputFile = new File(inputFileName);
        ArrayList inputTokens = null;
        try {
            inputTokens = lex(inputFile);
            System.out.println(inputTokens.toString());
        } catch (FileNotFoundException ex) {
            System.out.println("Bad input file");
        }
        //Get an iterator for our tokens
        Iterator<String> inputIterator = inputTokens.iterator();

        //Create our environment object and populate it
        Environment e = new Environment();
        //Generate all of our definitions
        Definition.generateDefinitions(inputIterator, e);
        //Generate all of our operations
        //new Operation(inputIterator, e);
        System.out.println(e.toString());

    }

    /**
     * Takes the input file and tokenizes it on whitespace and parens ( )
     * Parens get their own token.
     * @param input
     * @return
     * @throws FileNotFoundException
     */
    private static ArrayList<String> lex(File input) throws FileNotFoundException {
        ArrayList<String> tokens = new ArrayList();
        String currentToken, finalToken;

        Scanner inputScanner = new Scanner(input);
        StringTokenizer whiteSpaceTokenizer;
        StringTokenizer parenTokenizer;

        while(inputScanner.hasNextLine()){
            String currLine = inputScanner.nextLine();
            whiteSpaceTokenizer = new StringTokenizer(currLine);
            //Remove whitespace
            while (whiteSpaceTokenizer.hasMoreTokens()){
                currentToken = whiteSpaceTokenizer.nextToken();
                parenTokenizer = new StringTokenizer(currentToken, "()", true);
                //Grab parens
                while(parenTokenizer.hasMoreTokens()){
                    finalToken = parenTokenizer.nextToken();
                    //Throw out commas
                    //finalToken = finalToken.replace(",", "");
                    finalToken = finalToken.replaceAll("[\\s+,]", "");
                    
                    tokens.add(finalToken);
                }
            }
        }
        return tokens;
}
}

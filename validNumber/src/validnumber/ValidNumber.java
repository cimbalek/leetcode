/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validnumber;

/**
 *
 * @author mcimbale
 */
public class ValidNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public boolean isNumber(String s) {
       return s.matches("\\s*[+-]?((\\d+\\.)|(\\.\\d+)|(\\d+)|(\\d+\\.\\d+))(e[+-]?\\d+)?\\s*");
    }
}

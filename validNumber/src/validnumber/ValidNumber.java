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

    private static final short[][] TRANSITION_TABLE = {
        {0, 0, 8, 0, 8, 8, 0, 8, 8, 9, 0}, //white
        {0, 2, 2, 5, 5, 5, 7, 7, 0, 2, 7}, //digit
        {0, 3, 4, 0, 0, 0, 0, 0, 0, 3, 0}, //'.'
        {0, 0, 6, 0, 6, 6, 0, 0, 0, 0, 0}, //'e'    
        {0, 0, 0, 0, 0, 0, 10, 0, 0, 1, 0}};   //-

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public boolean isNumber(String s) {

        short status = 9;
        for (char c : s.toCharArray()) {

            switch (c) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': {
                    status = TRANSITION_TABLE[1][status];
                    break;
                }
                case ' ':
                case '\t': {
                    status = TRANSITION_TABLE[0][status];
                    break;
                }
                case '.': {
                    status = TRANSITION_TABLE[2][status];
                    break;
                }
                case 'e': {
                    status = TRANSITION_TABLE[3][status];
                    break;
                }
                case '-':
                case '+': {
                    status = TRANSITION_TABLE[4][status];
                    break;
                }
                default:
                    return false;
            }
            if (status == 0) {
                return false;
            }
        }

        if (status == 2
                || status == 4
                || status == 5
                || status == 7
                || status == 8) {
            return true;
        }
        return false;
    }
}

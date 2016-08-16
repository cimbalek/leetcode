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
        short[][] transitionTable = {
            {0, 0, 8, 0, 8, 8, 0, 8, 8, 9, 0}, //white
            {0, 2, 2, 5, 5, 5, 7, 7, 0, 2, 7}, //digit
            {0, 3, 4, 0, 0, 0, 0, 0, 0, 3, 0}, //'.'
            {0, 0, 6, 0, 6, 6, 0, 0, 0, 0, 0}, //'e'    
            {0, 0, 0, 0, 0, 0, 10, 0, 0, 1, 0}};   //-

        short status = 9;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ' ': {
                    status = transitionTable[0][status];
                    break;
                }
                case '\t': {
                    status = transitionTable[0][status];
                    break;
                }
                case '0': {
                    status = transitionTable[1][status];
                    break;
                }
                case '1': {
                    status = transitionTable[1][status];
                    break;
                }
                case '2': {
                    status = transitionTable[1][status];
                    break;
                }
                case '3': {
                    status = transitionTable[1][status];
                    break;
                }
                case '4': {
                    status = transitionTable[1][status];
                    break;
                }
                case '5': {
                    status = transitionTable[1][status];
                    break;
                }
                case '6': {
                    status = transitionTable[1][status];
                    break;
                }
                case '7': {
                    status = transitionTable[1][status];
                    break;
                }
                case '8': {
                    status = transitionTable[1][status];
                    break;
                }
                case '9': {
                    status = transitionTable[1][status];
                    break;
                }

                case '.': {
                    status = transitionTable[2][status];
                    break;
                }
                case 'e': {
                    status = transitionTable[3][status];
                    break;
                }
                case '-': {
                    status = transitionTable[4][status];
                    break;
                }
                case '+': {
                    status = transitionTable[4][status];
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

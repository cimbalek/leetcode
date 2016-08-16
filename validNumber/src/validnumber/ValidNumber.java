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

    private static final short[][] TRANSITIONS = {
            { 0, 10,  9, 10,  9,  9, 10, 10,  9,  9, 10},  // whitespace
            { 2,  2,  2,  5,  5,  5,  8,  8,  8, 10, 10},  // digit
            { 3,  3,  4, 10, 10, 10, 10, 10, 10, 10, 10},  // '.'
            {10, 10,  6, 10,  6,  6, 10, 10, 10, 10, 10},  // 'e'    
            { 1, 10, 10, 10, 10, 10,  7, 10, 10, 10, 10}}; // +-  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public boolean isNumber(String s) {
        short status = 0;
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
                        status = TRANSITIONS[1][status];
                        break;
                    }
                    case ' ':
                    case '\t': {
                        status = TRANSITIONS[0][status];
                        break;
                    }
                    case '.': {
                        status = TRANSITIONS[2][status];
                        break;
                    }
                    case 'e': {
                        status = TRANSITIONS[3][status];
                        break;
                    }
                    case '-':
                    case '+': {
                        status = TRANSITIONS[4][status];
                        break;
                    }
                    default:
                        return false;
                }
                if (status == 10) {
                    return false;
                }
            }
        
        if (status == 2
                || status == 4
                || status == 5
                || status == 8
                || status == 9) {
            return true;
        }
        return false;
    }
}

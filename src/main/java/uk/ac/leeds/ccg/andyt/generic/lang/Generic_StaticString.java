/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.leeds.ccg.andyt.generic.lang;

import java.util.HashSet;
import java.util.TreeSet;

/**
 *
 * @author geoagdt
 */
public class Generic_StaticString {

    public static HashSet<String> getNumeralsHashSet() {
        HashSet<String> s = new HashSet<>();
        s.add("0");
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("4");
        s.add("5");
        s.add("6");
        s.add("7");
        s.add("8");
        s.add("9");
        return s;
    }

    public static TreeSet<String> getNumeralsTreeSet() {
        TreeSet<String> s = new TreeSet<>();
        s.add("0");
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("4");
        s.add("5");
        s.add("6");
        s.add("7");
        s.add("8");
        s.add("9");
        return s;
    }

    public static TreeSet<String> getUpperCaseStringAlphabet_TreeSet() {
        TreeSet<String> result = new TreeSet<>();
        result.add("A");
        result.add("B");
        result.add("C");
        result.add("D");
        result.add("E");
        result.add("F");
        result.add("G");
        result.add("H");
        result.add("I");
        result.add("J");
        result.add("K");
        result.add("L");
        result.add("M");
        result.add("N");
        result.add("O");
        result.add("P");
        result.add("Q");
        result.add("R");
        result.add("S");
        result.add("T");
        result.add("U");
        result.add("V");
        result.add("W");
        result.add("X");
        result.add("Y");
        result.add("Z");
        return result;
    }

    public static TreeSet<String> getLowerCaseStringAlphabet_TreeSet() {
        TreeSet<String> result = new TreeSet<>();
        result.add("a");
        result.add("b");
        result.add("c");
        result.add("d");
        result.add("e");
        result.add("f");
        result.add("g");
        result.add("h");
        result.add("i");
        result.add("j");
        result.add("l");
        result.add("k");
        result.add("l");
        result.add("m");
        result.add("n");
        result.add("o");
        result.add("p");
        result.add("q");
        result.add("r");
        result.add("s");
        result.add("t");
        result.add("u");
        result.add("v");
        result.add("w");
        result.add("x");
        result.add("y");
        result.add("z");
        return result;
    }

    /**
     * Use String.toLowerCase() instead
     * @param s
     * @return 
     */
     @Deprecated
    public static String getLowerCase(String s) {
        String result = s;
        result = result.replace('A', 'a');
        result = result.replace('B', 'b');
        result = result.replace('C', 'c');
        result = result.replace('D', 'd');
        result = result.replace('E', 'e');
        result = result.replace('F', 'f');
        result = result.replace('G', 'g');
        result = result.replace('H', 'h');
        result = result.replace('I', 'i');
        result = result.replace('J', 'j');
        result = result.replace('K', 'k');
        result = result.replace('L', 'l');
        result = result.replace('M', 'm');
        result = result.replace('N', 'n');
        result = result.replace('O', 'o');
        result = result.replace('P', 'p');
        result = result.replace('Q', 'q');
        result = result.replace('R', 'r');
        result = result.replace('S', 's');
        result = result.replace('T', 't');
        result = result.replace('U', 'u');
        result = result.replace('V', 'v');
        result = result.replace('W', 'w');
        result = result.replace('X', 'x');
        result = result.replace('Y', 'y');
        result = result.replace('Z', 'z');
        return result;
    }

    /**
     * Use String.toUpperCase() instead
     * @param s
     * @return 
     */
     @Deprecated
     public static String getUpperCase(String s) {
        String result = s;
        result = result.replace('a', 'A');
        result = result.replace('b', 'B');
        result = result.replace('c', 'C');
        result = result.replace('d', 'D');
        result = result.replace('e', 'E');
        result = result.replace('f', 'F');
        result = result.replace('g', 'G');
        result = result.replace('h', 'H');
        result = result.replace('i', 'I');
        result = result.replace('j', 'J');
        result = result.replace('k', 'K');
        result = result.replace('l', 'L');
        result = result.replace('m', 'M');
        result = result.replace('n', 'N');
        result = result.replace('o', 'O');
        result = result.replace('p', 'P');
        result = result.replace('q', 'Q');
        result = result.replace('r', 'R');
        result = result.replace('s', 'S');
        result = result.replace('t', 'T');
        result = result.replace('u', 'U');
        result = result.replace('v', 'V');
        result = result.replace('w', 'W');
        result = result.replace('x', 'X');
        result = result.replace('y', 'Y');
        result = result.replace('z', 'Z');
        return result;
    }

    /**
     *
     * @param s The String that's first letter is to be capitalised.
     * @return s but with the first letter capitalised.
     */
    public static String getCapitalFirstLetter(String s) {
        // Special cases
        if (s.isEmpty()) {
            return "";
        }
        String firstletter = s.substring(0, 1);
        String firstletterCapital = getUpperCase(firstletter);
        // Special cases
        if (s.length() == 1) {
            return firstletterCapital;
        }
        String remainder = s.substring(1, s.length());
        return firstletterCapital + remainder;
    }

    /**
     *
     * Returns a count of the number of times s0 appears in s. If s is
     * "sss" and s0 is "ss" then count is 1. If s is "ssss" and sp is "ss" then
     * count is 2.
     * @param s The string for which instances of s0 are counted. 
     * @param s0 The string for which the number of occurrences in s is returned.
     * @return int
     */
    public static int getCount(String s, String s0) {
        if (s.contains(s0)) {
            if (s.contentEquals(s0))  {
                return 1;
            }
            return s.length() - s.replace(s0, "").length();
        }
        return 0;
    }
}

package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class PyramidTransitionMatrix {
    public static void main(String[] args) {
        System.out.println(PyramidTransitionMatrix.pyramidTransition("BCD", new ArrayList<String>(Arrays.asList("BCG", "CDE", "GEA", "FFF"))));
    }

    static public boolean pyramidTransition(String bottom, ArrayList<String> allowed) {
        if (bottom.length() == 1) {
            return true;
        }

        ArrayList<String> bases = getBasesFromBottom(bottom);
        for (String base: bases) {
            if (!checkIfBaseAllowed(base, allowed)) {
                return false;
            }
        }

        var possibleBottoms = getAllPossibleBottoms(getTopFromBases(bases, allowed));

        for (String possibleBottom: possibleBottoms) {
           return pyramidTransition(possibleBottom, allowed);
        }

        return true;
    }

    static public ArrayList<String> getBasesFromBottom(String bottom) {
        ArrayList<String> bases = new ArrayList<>();
        for (int i = 0; i < bottom.length() - 1; i++) {
            bases.add(bottom.substring(i, i + 2));
        }
        return bases;
    }

    static public boolean checkIfBaseAllowed(String base, ArrayList<String> allowed) {
        for (String s: allowed) {
            if (s.substring(0,2).equals(base)) {
                return true;
            }
        }
        return false;
    }

    static public ArrayList<Character> getTopFromBase(String base, ArrayList<String> allowed) {
        ArrayList<Character> topLetters = new java.util.ArrayList<>(Collections.emptyList());

        for (String s: allowed) {
            if (s.substring(0,2).equals(base)) {
                topLetters.add(s.charAt(2));
            }
        }

        return topLetters;
    }

    static public ArrayList<ArrayList<Character>> getTopFromBases(ArrayList<String> bases, ArrayList<String> allowed) {
        ArrayList<ArrayList<Character>> tops = new ArrayList<>();

        for (String base: bases) {
            tops.add(getTopFromBase(base, allowed));
        }

        return tops;
    }

    static ArrayList<String> getAllPossibleBottoms(ArrayList<ArrayList<Character>> allPossibleTops)
    {
        StringBuilder tempBottom = new StringBuilder();
        ArrayList<String> possibleBottoms = new ArrayList<>();
        int numberOfArrays = allPossibleTops.size();

        int[] indices = new int[numberOfArrays];

        for(int i = 0; i < numberOfArrays; i++)
            indices[i] = 0;

        while (true)
        {
            for(int i = 0; i < numberOfArrays; i++)
                tempBottom.append(allPossibleTops.get(i).get(indices[i]));

            possibleBottoms.add(tempBottom.toString());
            tempBottom.setLength(0);

            int next = numberOfArrays - 1;
            while (next >= 0 &&
                    (indices[next] + 1 >=
                            allPossibleTops.get(next).size()))
                next--;

            if (next < 0)
                return possibleBottoms;

            indices[next]++;

            for(int i = next + 1; i < numberOfArrays; i++)
                indices[i] = 0;
        }
    }
}

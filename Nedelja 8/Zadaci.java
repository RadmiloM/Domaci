
package skup.zadaci;

import com.sun.source.tree.Tree;
import com.sun.source.util.Trees;

import java.util.*;

public class Zadaci {


    /*
     * 1. Zajednicki elementi
     * Za dva zadata niza bojeva vratiti niz onih brojeva koji se nalaze i u jednom i u drugom nizu.
     *
     * NPR:
     * [1, 2, 3, 4, 5], [2, 4, 6, 8, 10] -> [2, 4]
     * */


    public static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a == null || b == null) {
            return null;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer in : a) {
            set.add(in);
        }

        for (Integer in : b) {
            set.add(in);
        }
        ArrayList<Integer> result = new ArrayList<>(set);
        return result;


    }


    /*
     * 2. Svi elementi
     * Za dva zadata niza brojeva vratiti niz svih brojeva iz oba niza bez ponavljanja.
     * */


    // Test broj 4 za union nije ispravan.
    public static ArrayList<Integer> union(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a == null && b != null) {
            return b;
        } else if (b == null && a != null) {
            return a;
        } else if (a == null && b == null) {
            return null;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer in : a) {
            set.add(in);
        }

        for (Integer in : b) {
            set.add(in);
        }

        ArrayList<Integer> arrays = new ArrayList<>(set);
        return arrays;
    }

    /*
     * 3. Razlika
     * Za dva zadata niza brojeva vratiti niz onih brojeva koji se nalaze u prvom
     * ali ne i u drugom nizu, bez ponavljanja.
     * */

    public static ArrayList<Integer> razlika(ArrayList<Integer> a, ArrayList<Integer> b) {

        if(a == null && b!= null){
            return b;
        }
        if(b == null && a!=null){
                return a;
        }
        if(a == null && b == null){
            return null;
        }
        TreeSet<Integer> set = new TreeSet<>(b);
        ArrayList<Integer> array = new ArrayList<>();
        for(Integer in : a){
            if(!set.contains(in)){
                array.add(in);
            }

    }   if(array.size() == 0){
            return null;
        }
        return array;

}


    /*
     * 4. Napisati funkciju koja broji koliko ima duplikata u zadatom nizu.
     *
     * [1, 2, 3, 4, 4, 2, 3, 5, 6] -> 3
     * [1, 2, 3] -> 0
     * [5, 5, 5, 5, 5, 6] -> 4
     * */

    public static int ponavljanjeBroj(int[] arr){
        int counter = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < arr.length;i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);

            }else {
                if(set.contains(arr[i]));
                counter++;
            }

        }
        return counter;


    }

    /*
     * 5. Provera permutacije
     * Za dva zadata niza brojeva proveriti da li moze da se jedan dobije od drugog.
     * Brojevi u nizu se ne ponavljaju
     *
     * NPR:
     * [1, 2, 221, 101], [101, 2, 221, 1] -> da
     * [1, 2, 3], [3, 1, 2, 4] -> ne
     * */

    public static boolean permutacija(ArrayList<Integer> p1, ArrayList<Integer> p2){
        TreeSet<Integer> result= new TreeSet<>(p1);
        for(int i = 0; i < p1.size();i++){
            result.add(p1.get(i));
        }
        for(int i = 0; i < p2.size();i++){
            result.add(p2.get(i));
        }

        return result.size() == p1.size() && result.size() == p2.size();


    }


    /*
     * 6. Neuparen element
     * Funkciji se prosledjuje niz ciji se svi elementi ponavljaju tacno dva puta,
     * osim jednog koji se ponavlja samo jednom.
     * Vratiti taj element
     *
     * Npr:
     * [1, 1, 2, 3, 3, 4, 4] -> 2
     * */

    public static int neuparen(int[] arr){
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < arr.length;i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
            }else{
                set.remove(arr[i]);
            }
        }
        return set.first();

        }



    /*
     * 7. Anagram
     * Funkcija prima 2 String i daje odgovor da/ne u odnosu na to da li je
     * jedan String anagram drugog.
     *
     * NPR:
     * "panta redovno zakasni"
     * "neopravdan izostanak"
     * Da
     * */

    public static boolean anagram(String s1, String s2){
        if(s1.length() == 0 && s2.length() == 0){
            return true;
        }
        TreeSet<Character> first = new TreeSet<>();
        TreeSet<Character> second = new TreeSet<>();
        for(int i =0; i < s1.length();i++){
            if(Character.isLowerCase(s1.charAt(i))){
                first.add(s1.charAt(i));
            }
        }
        for(int i = 0; i < s2.length();i++){
            if(Character.isLowerCase(s2.charAt(i))){
                second.add(s2.charAt(i));
            }
        }
        return first.size() == second.size();
    }


}

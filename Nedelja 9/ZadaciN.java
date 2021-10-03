import com.sun.source.util.Trees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

// Pokusaj dekodiranja tako sto
// se pretvori svaki karakter
// prema ascii ili unicode tabeli
// gde se dobija njihov broj,
// a zatim se filtriraju vrednosti
// koje su u rasponu od nula do 100
// ne ukljucujuci 100,potom se
// ponovo pretvaraju brojevi u karaktere
// na osnovu ascii ili unicode tabele,
// izbacuju se duplikati iz tabele,
// i zatim se sortiraju karakteri po
// alfabet vrednostima,dobijeno resenje
// nije trazeni rezultat.
public class ZadaciN {
    public static void main(String[] args) {
        String s = "\">]aOZXWm[Wm\\\\OmaZOQYm^`WdOb\\\\cm^]`cYc(m8OdO\\\":gTS\"";
        char[] characters = s.toCharArray();
        int[] numbers = new int[characters.length];
        for(int i = 0; i < characters.length;i++) {
            numbers[i] = (int) characters[i];
        }
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < numbers.length;i++){
            array.add(numbers[i]);
        }
        List<Integer> result = array.stream().filter(x -> x <=100).collect(Collectors.toList());
        ArrayList<Character> chars = new ArrayList<>();
        int[] convert = new int[result.size()];
        for(int i = 0; i < result.size();i++){
            convert[i] = result.get(i);
        }
        for(int i = 0; i < convert.length;i++){
            chars.add((char)convert[i]);
        }
        String str = "";
        for(int i = 0; i < chars.size();i++){
            if(Character.isAlphabetic(chars.get(i))){
                if(!str.contains(String.valueOf(chars.get(i)))){
                    str = str + chars.get(i);
                }
            }
        }
        TreeSet<Character> ret = new TreeSet<>();
        for(int i = 0; i < str.length();i++){
            ret.add(str.charAt(i));
        }
        System.out.println(ret);
    }
}

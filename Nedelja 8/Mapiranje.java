package mape.zadaci;

import com.sun.source.tree.Tree;

import java.util.*;

public class Mapiranje {

    /*
     * 1. Najmanje ponavljanje
     *
     * Za zadati niz brojeva, ispisati onaj broj koji se najmanje puta ponavlja,
     * ako je unapred poznato da je takav broj jedinstven
     * */

    public static int najmanjePonavljanje(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int currentMinValue = 55;
        int current_key = 0;
        for (Map.Entry<Integer, Integer> elements : map.entrySet()) {
            if (elements.getValue() < currentMinValue) {
                currentMinValue = elements.getValue();
                current_key = elements.getKey();

            }
        }
        return current_key;
    }


    /*
     * 2. Najopasnija posada
     *
     * Svetska vlada je izdala poternice za poznate pirate u fiktivnoj valuti 'Belly'.
     * Za prosledjen spisak pirata, formata:
     * "{Ime}, {Posada}, {nagrada_u_Belly-ima}", vratiti ime Posade koja u zbiru ima najvecu poternicu
     *
     * NPR:
     * "Roronoa Zoro, Strawhat, 320000"
     * "Trafalgar D. Water Law, Heart, 500000"
     * "Nami, Strawhat, 66000",
     * "Brook, Strawhat, 84000",
     * "Bepo, Heart, 500"
     *
     * Resenje: "Heart"
     * */

    public static String wanted(ArrayList<String> posters) {
        HashMap<String,Integer> mapa = new HashMap<>();
        for(String s : posters){
            String[] podela = s.split(",");
            String klan = podela[1].trim();
            int valuta = Integer.parseInt(podela[2].trim());
            if(mapa.containsKey(klan)){
                mapa.put(klan,mapa.get(klan) + valuta);
            }else{
                mapa.put(klan,valuta);
            }

        }
        int maksimum = Integer.MIN_VALUE;
        String rezultat =  "";
        for(Map.Entry<String,Integer> elementi : mapa.entrySet()){
            if(elementi.getValue() > maksimum){
                maksimum = elementi.getValue();
                rezultat = elementi.getKey();
            }
        }
        return rezultat;

    }



    /*
     * 3. Molekularna formula
     *
     * Hemijske formule molekula nam daju odlican opis toga koliko kojih atoma ima u molekulu,
     * kao i na koji nacin su oni povezani, dok nam molekularna formula daje samo opis broja atoma koji
     * ucestvuju u gradjenju datog molekula. Vas zadatak je da datu hemijsku formulu pretvorite u njenu molekularnu.
     * (Gde su elementi poredjanji po leksikografskom poretku)
     *
     * NPR:
     * H2S04 -> H2O4S1
     * Al2(S04)3 -> O12S3Al2
     * */

    // Ovaj kod radi ali rezultat nije tacan.
    public static void molekul(String hemija) {
        char[] characters = hemija.toCharArray();
        String letter = "";
        for(int i = 0; i < characters.length;i++){
            int counter= 0;
            if(Character.isDigit(characters[i])){
                counter++;
                letter+=characters[i] + String.valueOf(counter);

            }else{
                letter+=characters[i];
            }
        }
        System.out.println(letter);



    }

    public static void main(String[] args) {
        String s = "H2S04";
        molekul(s);

    }

    /*
     * 4. Frekvencija znaka
     *
     * Za prosledjenu String, vratiti koji karakter se ponavlja najvise puta
     * */

    public static char frekvencija(String s) {
        char result = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int current_maximum = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() > current_maximum) {
                current_maximum = e.getValue();
            }
        }
        for (Map.Entry<Character, Integer> elements : map.entrySet()) {
            if (elements.getValue() == current_maximum) {
                result = elements.getKey();
            }
        }
        return result;


    }




    /*
     * 5. Proizvodi
     * Napisati program koji vraca listu svih proizvoda koja prodavnica treba da naruci za sutradan,
     * ako je poznato da je svaka prodavnica zakonom duzna da prilikom otvaranja u maloprodaji sadrzi
     * barem 5 stvari svake stavke.
     *
     * Npr:
     * {
     * "Sapun" -> 4
     * "Torata" -> 10
     * "Hleb" -> 0
     * "Supa" -> 7
     * "Papir" -> 17
     * "Koka kola" -> 3
     * }
     * Resenje: ["Sapun", "Helb", "Koka kola"]
     * */

    public static ArrayList<String> nabavka(TreeMap<String, Integer> proizvodi) {
        ArrayList<String> productsToOrder = new ArrayList<>();
        for (Map.Entry<String, Integer> elements : proizvodi.entrySet()) {
            if (elements.getValue() < 5) {
                productsToOrder.add(elements.getKey());
            }
        }
        return productsToOrder;
    }







    /*
     * 6. Deljivost
     * Za proslednjen broj n, vratiti look-up table, koji govori da li je broj i prost ili ne
     * (2 <= i <= n)
     *
     * NPR:
     * n = 10
     * {
     * 2 -> true
     * 3 -> true
     * 4 -> false
     * 5 -> true
     * 6 -> false
     * 7 -> true
     * 8 -> false
     * 9 -> false
     * 10 -> false
     * }
     * */

    private static  boolean isPrime(int k){
        for(int i = 2; i  < Math.sqrt(k) + 1 ;i++){
            if(k % i == 0){
                return false;
            }
        }
        return true;
    }

    public static HashMap<Integer, Boolean> lookUp(int n) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i = 2; i <=n;i++){
            map.put(i,isPrime(i));
        }
        return map;
    }




    /*
     * 7. Fibonacijev niz
     * Fibonacijev niz je onaj niz koji pocinje sa 0, 1, a svaki sledeci broj je dobijen kao zbir prethodna dva.
     * Formalnije, Fibonacijev niz je zadat rekurentno kao:
     * | fib(0) = 0
     * | fib(1) = 1
     * | fib(n) = fib(n-1) + fib(n-2), za n >= 2;
     * Za proslednjen broj n, naci n-ti Fibonacijev broj.
     * */

    public static int fib(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        if (n  == 0 || n == 1) {
            return n;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }

        int result = fib(n-1) + fib(n-2);
        map.put(n,result);
        return map.get(n);
    }




    /*
     * 8. Sortiranje
     * Sortirati ucenike po broju osvojenih poena na testu, opadajuce
     * */

    // 1.Proveriti da li je mapa prazna,ako jeste ne moramo nista da radimo,
    // u slucaju da nije izbacujemo vrednosti iz mape i smestamo u listu
    // 2. Poredjenje vrsimo tako sto odredimo neku maksimalnu vrednost koja
    // treba da bude manja od bilo koje vrednosti u mapi,pa izaberemo minimalnu
    // vrednost iz klase Integer,na taj nacin uporedjujemo nasu maksimalnu vrednost
    // sa vrednostima iz mape,na osnovu poena pravimo promenlivu koja ce cuvati naziv
    // osobe koja ima najvise poena i nju smestamo u listu,a ime osobe kao i poene koje
    // smo procesuirali izbacujemo iz mape.

    public static ArrayList<String> sortiranje(HashMap<String, Integer> bodovi){
        ArrayList<String> ucenici = new ArrayList<>();
        while(!bodovi.isEmpty()){
            int maximum = Integer.MIN_VALUE;
            String rezultat = "";
            for(Map.Entry<String,Integer> elementi : bodovi.entrySet()){
                if(elementi.getValue() > maximum){
                    maximum = elementi.getValue();
                    rezultat =elementi.getKey();
                }
            }
            ucenici.add(rezultat);
            bodovi.remove(rezultat);
        }
        return ucenici;




    }











}

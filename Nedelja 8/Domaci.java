package stek.zadaci;


import java.util.ArrayList;
import java.util.Stack;

public class Domaci {

    /*
     * 1. Palacinke
     * Sara pravi palacinke sa dzemom, nutelom i sunkom za svoje drugare.
     * Funkciji se prosledjuje niska sa vrstom palacinke koju je Sara napravila, odvojene novim redom, redom;
     * kao i broj n koji oznacava koliko palacinaka ce pojesti Sarini prijatelji.
     * Ispisati kojim redom ce koje palacinke Sara pojesti posle svojih drugara, ako znamo da ce da pojede sve koje ostanu.
     *
     * NPR:
     * Nutela
     * Sunka
     * Nutela
     * Dzem
     * 2
     * ---------
     * Sunka
     * Nutela
     * */

    public static String palacinke(String s, int n) {
        StringBuilder result = new StringBuilder();
        java.util.Stack<String> array = new java.util.Stack<>();
        String[] arrayOfPancakes = s.split("\n");
        if (n > arrayOfPancakes.length) {
            return ":(";
        }
        for (int i = 0; i < arrayOfPancakes.length; i++) {
            array.push(arrayOfPancakes[i]);
        }

        for (int i = 0; i < n; i++) {
            array.pop();
        }
        if (!array.isEmpty()) {
            while (!array.isEmpty()) {
                result.append(array.pop()).append("\n");
            }
        }

        String output = result.substring(0, result.length() - 1);
        return output;

    }








    /*
     * 2. Istorija web pregledaca
     * Прегледач веба памти историју посећених сајтова и корисник има могућност да се враћа унатраг на сајтове које је раније посетио.
     * Написати програм који симулира историју прегледача тако што се учитавају адресе посећених сајтова (свака у посебном реду),
     * а када се учита ред у коме пише back прегледач се враћа на последњу посећену страницу.
     * Ако се наредбом back вратимо на почетну страницу, исписати -.
     * Ако се на почетној страници изда наредба back, остаје се на почетној страници.
     * Програм треба да испише све сајтове које је корисник посетио.
     * Улаз: Са стандардног улаза се учитавају веб-адресе, свака у посебној линији, koje се даље уписују у String, свака у посебном реду.
     * Излаз: Вратити String са исписаним сајтовима редом посећиваним.
     * */


    public static String history(String search) {
        java.util.Stack<String> stack = new java.util.Stack<>();
        String result = "";
        String[] array = search.split("\n");
        for (int i = 0; i < array.length; i++) {
            String currentWord = array[i];
            if (!currentWord.equals("back")) {
                stack.push(currentWord);
                result += currentWord + "\n";
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    result += "-\n";
                } else {
                    result += stack.peek() + "\n";
                }
            }
        }
        return result.substring(0, result.length() - 1);
    }

    /*
     * 3. Uparenost zagrada:
     * У изразу учествују следеће врсте заграда (, ), {, }, [ и ].
     * Напиши програм који проверава да ли су у унетом изразу заграде исправно упарене.
     * Улаз: Са стандардног улаза се уноси израз (цео у једном реду, без размака), које се даље уписују у String.
     * Излаз: Boolean.
     * */


    public static boolean uparenost(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty())
                    return false;

                char last = stack.pop();
                if ((c == ')' && last != '(') || (c == '}' && last != '{') || (c == ']' && last != '[')) {
                    return false;
                }

            }
        }
        return true;
    }

    /*
     * 4. Uzastopni brojevi
     * Низ се трансформише тако што се сваких 2 узастопних појављивања неког елемента бришу.
     * Напиши програм који одређује садржај низа након исцрпне примене ове трансформације.
     * Улаз:Са стандардног улаза се учитава елементи низа.
     * Излаз: На стандардни излаз исписати елементе резултујућег низа, раздвојене размаком.
     * NPR:
     * 1 1 2 2 2 2 1 3 4 4 5 5 4 4 3 2 1 1 1
     * "1 3 3 2 1"
     * */


    public static String uzastopni(int[] arr) {
        String result = "";
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else {
                if (arr[i] == stack.peek()) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    result += stack.pop() + " ";
                    stack.push(arr[i]);
                }
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop() + " ";

        }
        return result.trim();

    }


    /*
     * 5. Linijski editor
     * Sa standardnog ulaza se unose niske karaktera koje opisuju neku akciju. Akcije su sledece:
     * iX - korisnike je otkucao karakter X
     * < - korisnik je pritisnuo taster levo
     * > - korisnik je pritisnuo taster desno
     * b - korisnik je pritisnuo taster backspace za brisanje karaktera iza kursora
     * d - korisnik je pritisnuo taster delete za brisanje karaktera ispred kursora
     *
     * Vratiti String dobijen izvrsavanjem svih ackija
     *
     * NPR:
     * iaib<bic>>     cb
     * cb
     *
     * Objasnjenje:
     * Tekst     Naredba
     * |         ia
     * a|        ib
     * ab|       <
     * a|b       b
     * |b        ic
     * c|b       >
     * cb|       >
     * cb|
     *
     * */


    // Ovaj zadatak nece raditi ne testirati.
    public static String console(String input){
        java.util.Stack<Character> stack = new java.util.Stack<>();
        String result = "";
        char[] characters = input.toCharArray();
        for(int i = 0; i < characters.length-1;i++){
            if(characters[i] == 'i' && Character.isLetter(characters[i+1]) || Character.isDigit(characters[i+1])){
                stack.push(characters[i+1]);
                result+=String.valueOf(characters[i+1]);
            }else if(characters[i] == '<' && Character.isLetter(characters[i-1])|| Character.isDigit(characters[i-1])){
                char temp = characters[i-1];
                characters[i-1] = '|';
                result+=String.valueOf(characters[i-1]);
                result+=temp;
            }else if(characters[i] == 'b'){
                characters[i-1] = ' ';
            }else if(characters[i] == '>'){
                char current = '|';
                characters[i+1] = current;
                result+=current;
            }
        }
        return result;

    }

    /*
     * 6. Vrednost postfiksnog izraza
     * Са стандардног улаза се учитава постфиксно записан израз
     * који садржи једноцифрене бројеве и операторе +, -, * и / (без размака).
     * Ispisati vrednost izraza
     *
     * NPR:
     * 12+3*
     * 9
     *
     * Objasnjenje:
     * 12+3* -> (1+2)*3 = 3*3 = 9
     * */


    public static int eval(String s) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                if (c == '+') {
                    stack.push(stack.pop() + stack.pop());
                } else if (c == '*') {
                    stack.push(stack.pop() * stack.pop());
                } else if (c == '-') {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                } else if (c == '/') {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                }

            }
        }
        return stack.pop();

    }


    /*
     * 7. Berza
     * Duzina Si cene nekoe hartije ne berzi je definisana kao najveci broj uzastopnih dana,
     * pre datog dana, za koje je cena hartije manja ili jednaka trenutnoj ceni.
     * Za dat niz cena jedne hartije, vratiti niz duzina Si za svaki od tih dana
     *
     * NPR:
     * Cene po danima:      [100, 80, 60, 70, 60, 75, 85]
     * Si duzine po danima: [  1,  1,  1,  2,  1,  4,  6]
     * */

    // Ovaj zadatak nece raditi ne pokretati.
    public static void hartije(int... hartija) {
        int counter = 0;
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < hartija.length-1;i++){
            if(hartija[i+1]  <= hartija[i]){
                counter = 1;
                array.add(counter);
            }else{
                counter++;
                array.add(counter);
            }
        }
        System.out.println(array);

    }



    public static void main(String[] args) {
        int[] hartijes = new int[]{17, 61, 91, 67, 40};
        hartije(hartijes);
    }

}

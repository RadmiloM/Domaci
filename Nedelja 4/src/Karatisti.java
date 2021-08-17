import java.util.Arrays;
import java.util.Random;
import java.util.RandomAccess;
import java.util.concurrent.LinkedBlockingDeque;

public class Karatisti {
    private String ime;
    private int godine;
    private String rang;
    private String[] kata;

    public Karatisti(String ime, int godine,String rang,String[] kata){
        this.ime = ime;
        if(godine <=0){
            System.out.println("Nisi uneo validne godine");
            System.exit(1);
        }else {
            this.godine = godine;
        }
        this.rang = rang;
        this.kata = kata;
    }


    public void napadni(int index){
        if(index > this.kata.length-1){
            System.out.println("Index je veci od broja elemenata u nizu");
            System.exit(1);
        }
        System.out.println("Karatista " + getIme() + " napada sa " + this.kata[index]);
    }

    public void vatreniNapad(){
        Random randomElement = new Random();
        int randomIndex = randomElement.nextInt(this.kata.length);
        System.out.println("Karatista " + getIme()  +  " napada sa " + this.kata[randomIndex]);
    }

    public void log(){
        System.out.println("Karatistia: " + getIme() +"," + " " +getGodine()+"," + " " + getRang()
                + " - zna naredne kate " + Arrays.toString(getKata()));
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public String[] getKata() {
        return kata;
    }

    public void setKata(String[] kata) {
        this.kata = kata;
    }
}

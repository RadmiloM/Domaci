import java.util.ArrayList;

public class Posta {
    private ArrayList<Poruka> poruke;

    public Posta(ArrayList<Poruka> poruke){
        this.poruke = poruke;
    }

    public void add(Poruka p){
        for(int i = 0; i < poruke.size();i++){
            if(poruke.get(i).getId() != p.getId()){
                poruke.add(p);
            }
        }
    }

    public void remove(Poruka p){
        for(int i = 0; i < poruke.size();i++){
            if(poruke.get(i).getId() == p.getId() ){
                poruke.remove(p);
            }
        }
    }


    public void send(Poruka p){
        System.out.println(p.getPoruka());
        for(Poruka p1 : poruke){
            if(p1.getId() == p.getId()){
                poruke.remove(p);
            }
        }
    }

    public void change(Poruka p, String msg){
        for(int i = 0; i < poruke.size();i++){
            if(poruke.get(i).getPoruka().contains(p.getPoruka())){
                poruke.get(i).setPoruka(msg);
            }
        }
    }

    public int isplata(Poruka p){
        for(Poruka p2 : poruke){
            if(p2.equals(p)){
                return p.getSuma();
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String rezultat = "";
        for(Poruka p3: poruke){
            rezultat+=p3.toString();
        }
        return rezultat;
    }
}

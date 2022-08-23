package poo4;

import java.util.ArrayList;

public class testaProva {
    public static void main(String[] args) {
        int qtd = 0;
        ArrayList <Prova> lista = new ArrayList<>();
        while(qtd <= 3) {
            lista.add(new Prova());
            qtd++;
        }
        System.out.println(lista);
    }
}

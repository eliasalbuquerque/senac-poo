package PTI_DistanciaEntrePontos;


public class Distancia{
    public static void main(String[] args) {
        Pontos c1 = new Pontos();
        // c1.setXa(2); // erro!
        c1.coordenadasPontoA(2, -3);
        c1.coordenadasPontoB(2, 3);
        c1.distancia();

        Pontos c2 = new Pontos();
        c2.coordenadasPontoA(7, -3);
        c2.distancia();

        Pontos c3 = new Pontos();
        c3.distancia();

        Pontos c4 = new Pontos();
        c4.coordenadasPontoA(1, 4);
        c4.coordenadasPontoB(1, 4);
        c4.distancia();
    }
}
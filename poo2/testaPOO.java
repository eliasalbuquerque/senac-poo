package poo2;

public class testaPOO {
    public static void main(String[] args) {
        int Result=0;
        POO1 Objs[] = new POO1[3];
        Objs[0] = new POO1();
        Objs[1] = new POO1();
        Objs[2] = new POO1();
        for (int i=0; i<3; i++)
            Result += Objs[i].Calcula();
        System.out.println(Result);
    }
}

package PTI_DistanciaEntrePontos;


public class Pontos implements Interface {   
    
    // atributos
    private int xa, xb, ya, yb;
    private boolean inserirPontoA;



    // construtores
    public Pontos(){
        this.setXb(0);
        this.setYb(0);
        this.setInserirPontoA(false);
    }

 

    // metodos getters e setters
    public int getXa() {
        return this.xa;
    }

    private void setXa(int xa) {
        this.xa = xa;
    }

    public int getXb() {
        return this.xb;
    }

    private void setXb(int xb) {
        this.xb = xb;
    }

    public int getYa() {
        return this.ya;
    }

    private void setYa(int ya) {
        this.ya = ya;
    }

    public int getYb() {
        return this.yb;
    }

    private void setYb(int yb) {
        this.yb = yb;
    }

    public boolean getInserirPontoA() {
        return this.inserirPontoA;
    }

    private void setInserirPontoA(boolean inserirPontoA) {
        this.inserirPontoA = inserirPontoA;
    }
    


    // metodos abstratos    
    @Override
    public void coordenadasPontoA(int xa, int ya) {
        this.setXa(xa);
        this.setYa(ya);
        this.setInserirPontoA(true);
    }
    
    @Override
    public void coordenadasPontoB(int xb, int yb) {
        this.setXb(xb);
        this.setYb(yb);
    }
    
    @Override
    public void distancia(){
        verificarPontosIguais();
    }


    
    // metodos
    private float calcularDistancia() {
        float d = (float) Math.hypot((this.getXa() - this.getXb()), (this.getYa() - this.getYb()));
        return d;
    }
    
    private void verificarPontosIguais(){
        if (this.getInserirPontoA()) {
            if ((this.getXa() == this.getXb()) && (this.getYa() == this.getYb())){
                System.out.println("Os pontos A e B tem o mesmo valor, portanto, nao ha distancia entre os pontos");
            } else {
                System.out.println("Ponto A (x, y): " + this.getXa() + ", " + this.getYa());
                System.out.println("Ponto B (x, y): " + this.getXb() + ", " + this.getYb());
                System.out.println("A distancia entre os pontos A e B é: " + calcularDistancia());
            }            
        } else {
            System.out.println("Faltando valores de X e Y para o PONTO A!");
            System.out.println("Insira valores interiros com o comando: \"<objeto>.coordenadasPontoA(<valor de x>, <valor de y>)\"");
        }
    }
}

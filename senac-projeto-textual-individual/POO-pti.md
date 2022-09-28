# PTI Programação Orientada a Objetos

Esse trabalho foi elaborado segundo as especificações da [PTI](https://github.com/eliasalbuquerque/senac/blob/main/PTI_DistanciaEntrePontos/POO-pti.pdf) e implementando outras funcionalidades que serão explicadas ao longo da análise do código.

No [GitHub](https://github.com/eliasalbuquerque/senac/tree/main/PTI_DistanciaEntrePontos), poderá ser consultado todo o trabalho: 
- Algoritmo do projeto
- Código main Distancia.java
- Interface do projeto
- Classe Pontos.java

---



## Classe Pontos

O projeto prevê a abstração dos métodos de inserção de dados com o uso de uma interface e protegendo os atributos com o modificador de acesso **_private_**. O problema solicita a entrada de  coordenadas x e y de um “ponto” na tela. Sendo assim, atributos inteiros e privados na classe Ponto.

A implementação de uma condição booleana serve para o teste de entrada dos valores _x_ e _y_ do Ponto A.


```java
public class Pontos implements Interface {   
    
    // atributos
    private int xa, xb, ya, yb;
    private boolean inserirPontoA;
```



O construtor insere valores iguais a zero nas coordenadas _x_ e _y_ do segundo ponto (Ponto B) ao iniciar cada instancia da classe. Desse modo o construtor sobrescreve o método abstrato do Ponto B.

```java
    // construtores
    public Pontos(){
        this.setXb(0);
        this.setYb(0);
        this.setInserirPontoA(false);
    } 
```



Como boa prática de escrita de código, foi implementado os _Getters_ e _Setters_ da classe, métodos que irão acessar ou alterar os valores dos atributos, ao invés de realizar o processo diretamente, minimizando possíveis quebras de código e facilitando a implementação e manutenção do código.

Foi utilizado o modificador de acesso **_private_** para todos os _Setters_, de modo a limitar o acesso a inserção de dados aos atributos, realizado somente pela Interface do projeto.

```java
    // metodos getters e setters
    public int getXa() {
        return this.xa;
    }

    private void setXa(int xa) {
        this.xa = xa;
    }

    (...)
    }
```



Os métodos acessíveis para a inserção de dados no código é feita pela Interface e implementada por métodos abstratos na classe.

No método `coordenadasPontoA()`, toda vez que o usuário insere coordenadas para o Ponto A, a lógica booleana é _verdadeira_ e será utilizada para a verificação de inserção obrigatória das coordenadas.

O método `coordenadasPontoB()` foi implementado para a alteração do valor _default_ das coordenadas do Ponto B, sendo assim, caso queira testar outros valores e distâncias, basta chamar o método e inserir novos valores para _x_ e _y_.

```java
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
```



O Método `calcularDistancia()` implementa a classe [**_Math_**](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#hypot-double-double-) nativa do Java. 

`Math.hypot` calcula a hipotenusa de um triangulo, que nesse caso é formado ao inserir os pontos A e B em um quadrante qualquer e interligando os pontos no eixo X do plano cartesiano, formando um triângulo retângulo. 

Para a classe `Math.hypot` é solicitado dois valores _double_ como parâmetros e retorna o valor da expressão: **sqrt(x² + y²)**.

O método `calcularDistancia()` retorna o valor da distância tratado como **float**.

```java
    // metodos
    private float calcularDistancia() {
        float d = (float) Math.hypot((this.getXa() - this.getXb()), (this.getYa() - this.getYb()));
        return d;
    }
```



Como outra opção para implementar o cálculo de distância dos pontos, o algoritmo abaixo prevê o uso das classes `Math.sqrt` e `Math.pow`, cálculo de raiz quadrada e cálculo de potência respectivamente.

```
privado Metodo calcularDistancia()
    // hipotenusa: D = sqrt((Xa-Xb)^2 + (Ya-Yb)^2)        
    d : float
    d = Math.sqrt(Math.pow((xa-xb),2) + Math.pow((ya-yb),2)) : float
fim Metodo
```



Para finalizar, o método `verificarPontosIguais()` abaixo verifica se foi inserido coordenadas para o Ponto A, e se sim, verifica se são valores idênticos ao Ponto B, se for igual, são o mesmo ponto, não havendo distância entre eles, se não for igual, é calculada a distância entre os pontos. Se ainda não foi inserido o Ponto A, então é indicado para que o usuário entre com os valores de _x_ e _y_ para o Ponto A.

```java    
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
```

## Interface

```java
public interface Interface {
    public abstract void coordenadasPontoA(int xa, int ya);
    public abstract void coordenadasPontoB(int xb, int yb);
    public abstract void distancia();
}
```

## Código Main

```java
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
```

### Saída do Console

![saidaDoConsole-fontePropria](https://github.com/eliasalbuquerque/senac/blob/main/PTI_DistanciaEntrePontos/testePTI.png?raw=true "Saída do Console: Fonte própria")

<!-- ## Algoritmo

```
Classe Pontos
	
	// atributos
	privado xa, xb, ya, yb : inteiro
	privado inserirPontoA : booleano
	


	// metodos construtores
	publico Metodo Pontos()
		setXb(0)
		setYb(0)
		setInserirPontoA(falso)
	fim Metodo
	


	// metodos abstratos da Interface
	publico Metodo coordenadasPontoA(xa, ya : int)
		setXa(xa)
		setYa(ya)
		setInserirPontoA(verdadeiro)
	fim Metodo

	publico Metodo coordenadasPontoB(xb, yb : int)
		setXb(xb)
		setYb(yb)
	fim Metodo

	publico Metodo distancia()
		verificarPontosIguais()
	fim Metodo



	// metodos comuns	
	privado Metodo calcularDistancia()
		// hipotenusa: D = sqrt((Xa-Xb)^2 + (Ya-Yb)^2)
		 
		d : float
		
		// ou opcao 1
		d = Math.sqrt(Math.pow((xa-xb),2) + Math.pow((ya-yb),2)) : float
		
		// ou opcao 2
		x = xa-xb
		y = ya-yb
		d = Math.hypot(x,y) : float

		retorna (d)
	fim Metodo
	
	privado Metodo verificarPontosIguais()
		se (ponto A foi inserido) entao
			se (ponto A = ponto B) entao
				escreva("os pontos A e B sao o mesmo ponto!")
			senao
				escreva("Ponto A")
				escreva("Ponto B")
				escreva("A distancia entre A e B é: " + calcularDistancia())
			fim se
		senao 
			escreva("insira coordenadas do ponto A")
	fim Metodo
```


 -->

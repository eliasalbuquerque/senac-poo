package poo7;

// import java.util.ArrayList;


// public class Curso {
//     private String nome;

//     public Curso(String nome) {
//         this.nome = nome;
//         System.out.println("Curso:" + nome);
//     }

//     public void Disciplina(String novoValor) {
//         Disciplina novaDisciplina = new Disciplina();
//     }

//     public String getNome() {
//         return this.nome;
//     }
// }

import java.util.ArrayList;

public class Curso{
    private String nome;
    private ArrayList listaDisciplina;

    public Curso(String nome){
        this.nome = nome;
        this.listaDisciplina = new ArrayList<>();
    }

    public String getNome(){
        return this.nome;  
    }

    public void Disciplina(String disciplina){
        listaDisciplina.add(disciplina);
    }

    public String toString(){
        return "Curso: "+this.nome+"\nDisciplinas: "+listaDisciplina;
    }
}

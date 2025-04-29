package ex3;

public class Aluno {

    String nome;
    static int totalAlunos = 0;

    public Aluno(String nome){
        this.nome = nome;
        totalAlunos++;
    }

    public void exibirInfo(){
        System.out.printf("O nome do aluno é %s e o total de alunos %d.", nome, totalAlunos);
    }
}

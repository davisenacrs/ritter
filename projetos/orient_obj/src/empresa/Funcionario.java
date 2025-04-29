package empresa;

public class Funcionario {

    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double calcularSalario(){
        System.out.println("Salário calculado com suscesso.");
    }
}

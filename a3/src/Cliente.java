public class Cliente {

    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private String cpfCnpj;
    private String endereco;

    public Cliente(String nome, String telefone, String email, String senha, String cpfCnpj, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
    }
}

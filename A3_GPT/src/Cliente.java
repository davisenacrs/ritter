public abstract class Cliente {
    protected String nome;
    protected String email;
    protected String telefone;
    protected String endereco;

    public Cliente(String nome, String email, String telefone, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public abstract void exibirDados();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome, String email, String telefone, String endereco, String cpf) {
        super(nome, email, telefone, endereco);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void exibirDados() {
        System.out.println("Pessoa Física: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
    }
}

class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(String nome, String email, String telefone, String endereco, String cnpj) {
        super(nome, email, telefone, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void exibirDados() {
        System.out.println("Pessoa Jurídica: " + nome);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
    }
}

public class Funcionario {
    private String cpf;
    private String nome;
    private boolean gerente;

    public Funcionario(String cpf, String nome, boolean gerente) {
        this.cpf = cpf;
        this.nome = nome;
        this.gerente = gerente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isGerente() {
        return gerente;
    }

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }
}

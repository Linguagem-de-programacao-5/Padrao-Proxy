import java.util.Arrays;
import java.util.List;

public class Conta implements IConta{

    private Integer numConta;
    private double limiteCredito;
    private double saldo;
    private String cpf;
    private String nome;
    private String rua;
    private String bairro;
    private int numero;
    private String cep;
    private String cidade;
    private String estado;


    public Conta(Integer numConta) {
        this.numConta = numConta;
        Conta objeto = BD.getConta(numConta);
        this.limiteCredito = objeto.limiteCredito;
        this.cpf = objeto.cpf;
        this.nome = objeto.nome;
        this.saldo = objeto.saldo;
        this.rua = objeto.rua;
        this.bairro = objeto.bairro;
        this.numero = objeto.numero;
        this.cep = objeto.cep;
        this.cidade = objeto.cidade;
        this.estado = objeto.estado;
    }

    public Conta(Integer numConta, double limiteCredito, double saldo, String cpf, String nome, String rua, String bairro, int numero, String cep, String cidade, String estado) {
        this.numConta = numConta;
        this.limiteCredito = limiteCredito;
        this.saldo = saldo;
        this.cpf = cpf;
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getNumConta() {
        return numConta;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    @Override
    public String obterDadosPessoais() {
        return "Cliente = {" +
                "Cpf='" + this.cpf + '\'' +
                ", nome='" + this.nome + '\'' +
                ", rua='" + this.rua + '\'' +
                ", bairro='" + this.bairro + '\'' +
                ", numero=" + this.numero +
                ", cep='" + this.cep + '\'' +
                ", cidade='" + this.cidade + '\'' +
                ", estado='" + this.estado + '\'' +
                '}';
    }

    @Override
    public Double obterLimite() {
        return this.getLimiteCredito();
    }

    @Override
    public void ajustarLimite(Funcionario funcionario, double valor) {
        setLimiteCredito(valor);
    }
}

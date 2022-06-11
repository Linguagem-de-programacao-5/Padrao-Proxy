public class ContaProxy implements IConta {

    private Conta conta;
    private Integer numConta;

    public ContaProxy(Integer numConta) {
        this.numConta = numConta;
    }

    @Override
    public String obterDadosPessoais() {
        if(this.conta==null){
            this.conta = new Conta(this.numConta);
        }
        return this.conta.obterDadosPessoais();
    }

    @Override
    public Double obterLimite() {
        if(this.conta==null){
            this.conta = new Conta(this.numConta);
        }
        return this.conta.obterLimite();
    }

    @Override
    public void ajustarLimite(Funcionario funcionario, double valor) {
        if(!funcionario.isGerente()){
            throw new IllegalArgumentException("Funcionário não autorizado!");
        }
        if (valor < 50 ){
            throw new IllegalArgumentException("O valor mínimo deve ser R$50!");
        }
        if(this.conta==null){
            this.conta = new Conta(this.numConta);
        }
        conta.setLimiteCredito(valor);
    }
}

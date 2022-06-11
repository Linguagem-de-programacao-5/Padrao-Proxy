import java.util.List;

public interface IConta {
    String obterDadosPessoais();
    Double obterLimite();
    void ajustarLimite(Funcionario funcionario, double valor);
}

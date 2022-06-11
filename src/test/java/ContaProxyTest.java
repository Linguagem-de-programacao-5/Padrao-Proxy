import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaProxyTest {

    @BeforeEach
    void setUp(){
        BD.addConta(new Conta(12345,1500,1000,"85693683052", "Jose da Silva", "Rua A", "Bairro A1", 1, "672245000", "Cidade A", "A"));
        BD.addConta(new Conta(0001,5000,3500,"12309083712", "Maria Silva", "Rua B", "Bairro B1", 2, "682985000", "Cidade B", "B"));

    }

    @Test
    void deveRetornarDadosPessoaisCliente(){
       ContaProxy conta = new ContaProxy(12345);
       assertEquals("Cliente = {Cpf='85693683052', nome='Jose da Silva', rua='Rua A', " +
               "bairro='Bairro A1', numero=1, cep='672245000', cidade='Cidade A', estado='A'}", conta.obterDadosPessoais());
    }

    @Test
    void deveRetornarLimite(){
        ContaProxy conta = new ContaProxy(0001);
        assertEquals(5000, conta.obterLimite());
    }

    @Test
    void deveRetonarNovoValorLimite() {
            Funcionario gerente = new Funcionario("12233344455", "Silva", true);
            ContaProxy conta = new ContaProxy(12345);

            conta.ajustarLimite(gerente,6850);
            assertEquals(6850,conta.obterLimite());
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoAjustarValor() {
        try {
            Funcionario atentende = new Funcionario("12233344455", "João", false);
            ContaProxy conta = new ContaProxy(12345);

            conta.ajustarLimite(atentende,9000);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado!", e.getMessage());
        }
    }

    @Test
    void deveRetonarExcecaoUsuarioValorInvalido() {
        try {
            Funcionario gerente = new Funcionario("12233344455", "João", true);
            ContaProxy conta = new ContaProxy(12345);

            conta.ajustarLimite(gerente,34);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("O valor mínimo deve ser R$50!", e.getMessage());
        }
    }
}

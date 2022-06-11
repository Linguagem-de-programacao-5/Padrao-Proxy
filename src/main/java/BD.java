import java.util.HashMap;
import java.util.Map;

public class BD {

    private static Map<Integer, Conta> contas = new HashMap<>();

    public static Conta getConta(Integer numConta) {
        return contas.get(numConta);
    }

    public static void addConta(Conta conta){
        contas.put(conta.getNumConta(), conta);
    }

}

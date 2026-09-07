package estudos.exercicio_SO;

public class ImpressoraRecibo{
    public String imprimirRecibo(Produto[] produtos){
        String resultado = "";
        for (Produto produto : produtos) {
            resultado += "Produto: '" + produto.nome + "' = R$" + produto.calcularPrecoFinal() + "\n";
        }
        return resultado;
    }
}

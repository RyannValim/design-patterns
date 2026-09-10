package estudos.locacao_equipamentos;

public class ServicoDeLocacao{
    public String processarLocacao(Equipamento equipamento, int diasLocacao){
        equipamento.setDiasLocacao(diasLocacao);
        
        double valorLocacao = equipamento.calcularValorLocacao();
        return "O valor da locação para o equipamento '" + equipamento.nome + "' será de: R$" + valorLocacao;
    }
}

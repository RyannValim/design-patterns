package estudos.exercicio_SOLID;

public abstract class Equipamento{
    protected String nome;
    protected double valorDiaria;
    protected int diasLocacao;

    public void setDiasLocacao(int diasLocacao){
        this.diasLocacao = diasLocacao;
    }

    public int getDiasLocacao(){
        return this.diasLocacao;
    }

    public abstract double calcularValorLocacao();
}

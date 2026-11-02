public class PassagemRodoviaria extends Passagem{
    public PassagemRodoviaria(){
        this.valorTarifa = 350.00;
    }

    @Override
    public Double calcTaxaEmbarque(){
        return this.valorTarifa * 0.03;
    }
}

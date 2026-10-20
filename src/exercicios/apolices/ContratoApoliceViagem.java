package apolices;

public class ContratoApoliceViagem extends ContratoApolice{ // ConcreteCreator
    private String segurado;
    private String destinoViagem;
    private int diasViagem;
    private Double valorCoberturaMedica;
    private String passaporte;
    private String itinerarioViagem;

    public ContratoApoliceViagem(String segurado, String destinoViagem, int diasViagem, Double valorCoberturaMedica,
                                 String passaporte, String itinerarioViagem){
        this.segurado = segurado;
        this.destinoViagem = destinoViagem;
        this.diasViagem = diasViagem;
        this.valorCoberturaMedica = valorCoberturaMedica;
        this.passaporte = passaporte;
        this.itinerarioViagem = itinerarioViagem;
    }

    @Override
    protected Apolice criarApolice(){
        return new ApoliceViagem(segurado, destinoViagem, diasViagem, valorCoberturaMedica, passaporte, itinerarioViagem);
    }
}

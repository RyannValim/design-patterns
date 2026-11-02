public class Main {
    public static void main(String[] args){
    
        Emissor emissor = null;
        String tipoPassagem = "AEREA";
        String nomePassageiro = "Marlene";
        String docIdentidade = "13.102.338-1";

        try{
            switch(tipoPassagem){
                case "AEREA":
                    emissor = new EmissorAereo();
                    break;
                case "RODOVIARIA":
                    emissor = new EmissorRodoviario();
                    break;
                case "FERROVIARIA":
                    emissor = new EmissorFerroviario();
                    break;
                default:
                    throw new IllegalArgumentException("Este tipo de passagem '" + tipoPassagem + "' não existe!");
            }

            emissor.emitirPassagem(nomePassageiro, docIdentidade);
        } catch(IllegalArgumentException e){
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
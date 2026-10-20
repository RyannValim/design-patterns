package apolices;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main{ // Client
    // seleciona o criador pelo tipo solicitado, sem if/switch e sem instanciar produto concreto
    private static void emitir(Map<String, ContratoApolice> contratos, String tipo){
        try{
            Apolice apolice = contratos.get(tipo).processarContratacao();
            System.out.println(apolice.gerarResumo());
        }catch(ContratacaoRejeitadaException e){
            System.out.println("[" + tipo + "] " + e.getMessage());
        }
        System.out.println();
    }

    public static void main(String[] args){
        Map<String, ContratoApolice> contratos = new LinkedHashMap<>();

        // contratações válidas
        contratos.put("AUTO", new ContratoApoliceAuto(
            "Ana Souza", 80000.00, 22, 1, 100000.00, "CNH-123456", "CRLV-987654", "Conta de luz 09/2026"));
        contratos.put("RES", new ContratoApoliceRes(
            "Bruno Lima", 1200000.00, "ALTO PADRAO", "Escritura nº 4521", null, "Conta de água 09/2026"));
        contratos.put("VIDA", new ContratoApoliceVida(
            "Carla Mendes", 40, 600000.00, true, "RG 12.345.678-9", "123.456.789-00", "Atestado Dr. Silva 10/2026"));
        contratos.put("VIAGEM", new ContratoApoliceViagem(
            "Diego Rocha", "INTERNACIONAL", 10, 50000.00, "FZ123456", "GRU -> LIS -> MAD -> GRU"));

        // contratações que devem ser rejeitadas
        contratos.put("AUTO_SEM_COBERTURA", new ContratoApoliceAuto(
            "Eduardo Alves", 50000.00, 30, 10, 30000.00, "CNH-654321", "CRLV-123123", "Conta de gás 09/2026"));
        contratos.put("RES_SEM_DOCUMENTO", new ContratoApoliceRes(
            "Fernanda Dias", 400000.00, "PADRAO", null, null, "Conta de luz 08/2026"));
        contratos.put("VIDA_SEM_ATESTADO", new ContratoApoliceVida(
            "Gabriel Costa", 35, 800000.00, false, "RG 98.765.432-1", "987.654.321-00", null));
        contratos.put("VIAGEM_SEM_PASSAPORTE", new ContratoApoliceViagem(
            "Helena Prado", "INTERNACIONAL", 7, 40000.00, null, "GRU -> MIA -> GRU"));

        for(String tipo : contratos.keySet()){ emitir(contratos, tipo); }
    }
}

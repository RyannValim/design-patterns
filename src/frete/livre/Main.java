package frete.livre;

public class Main {
    // a) fechar o pedido de id 1: 2kg, 100km e R$200,00 em itens pelo SEDEX
    // b) simular as 3 modalidades para esse mesmo pedido
    // c) alterar a tarifa do PAC por kg para R$5,00
    // d) simular as 3 modalidades, novamente
    // e) imprimir o histórico de auditoria
}

/*
    Três modalidades de entrega

    PAC, SEDEX e Retirada na Loja

    fechamento do pedido: cobra o frete de uma modalidade escolhida
    tela de simulação: mostra ao cliente o preço das 3 opções antes
    histórico de auditoria para os cálculos realizados

    rf01 (pac): frete == pesoKg * 2.5 + distanciaKm * 0.05
    rf02 (sedex): frete == pesoKg * 4.0 + distanciaKm * 0.12 + 15.00
        de taxa de urgência
    rf03 (retirada na loja): frete == 0
    rf04 (pedido): pedido com int ID, pesoKg, distanciaKm e valorItens
        são double. Caso o valor seja negativo, para quaisquer valores,
        rejeitar com erro.
    rf05 (modalidade): PAC / SEDEX / RETIRADA (texto deconhecido é
        rejeitado).
    rf06 (auditoria): cálculos bem-sucedidos gravam linha no histórico,
        no formato pedido=1, estrategia=SEDEX e frete=35.00. Se falhar,
        não grava nada. Preserva a ordem e pode ser lido e apagado.
    rf07 (tarifas): as cinco tarifas (PAC por kg, PAC por km, SEDEX por
        kg, SEDEX por km e taxa de urgência do SEDEX) podem ser lidas e
        também restauradas aos valores iniciais informados em RF01 e RF02.
    rf08 (saidas): imprimir o valor dos itens, frete e o total. A simulação
        imprime o frete das três modalidades.

    rnf01 - dados de um pedido não podem ser alterados depois de o pedido
        ter sido criado
    rnf02 - esta versão não deve usar padrão de projeto algum, nada de
        interface, nada de hierarquia: a decisão da modalidade é condicional
        explícita.
*/
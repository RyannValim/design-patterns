package spawninimigos;

public class Main {
    public static void main(String[] args){
        Inimigo modeloInimigo = new Inimigo("orc", 100, 1.5);
        modeloInimigo.adicionarHabilidades(new Habilidade("Machadada", 12));

        CatalogoDeInimigos catalogoDeInimigos = new CatalogoDeInimigos();
        catalogoDeInimigos.registrar("modelo-orc", modeloInimigo);

        modeloInimigo.exibirInfo();
        System.out.println();

        // Gerando inimigo A a partir do catálogo e fortalecendo a habilidade
        Inimigo inimigoA = catalogoDeInimigos.criar("modelo-orc");
        inimigoA.getHabilidades().get(0).setDano(30);
        inimigoA.exibirInfo();
        System.out.println();

        // Gerando o inimigo B a partir do catálogo
        Inimigo inimigoB = catalogoDeInimigos.criar("modelo-orc");
        inimigoB.exibirInfo();
        System.out.println();

        // Gerando o inimigo 'dragão'
        try{
            Inimigo inimigoDragao = catalogoDeInimigos.criar("dragao");
            inimigoDragao.setNome("adalberto");
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        // conferências dos modelos
        System.out.println("\nDano Machadada 'modelo': " + modeloInimigo.getHabilidades().get(0).getDano());
        System.out.println("Dano Machadada 'inimigoA': " + inimigoA.getHabilidades().get(0).getDano());
        System.out.println("Dano Machadada 'inimigoB': " + inimigoB.getHabilidades().get(0).getDano());
    }
}

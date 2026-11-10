package spawninimigos;

public class Habilidade {
    private String nome;
    private int dano;

    public Habilidade(
        String nome,
        int dano
    ){
        this.nome = nome;
        this.dano = dano;
    }

    public Habilidade(Habilidade origem){
        this.nome = origem.nome;
        this.dano = origem.dano;
    }

    public String getNome() { return this.nome; }
    public void setNome(String value) { this.nome = value; }

    public int getDano() { return this.dano; }
    public void setDano(int value) { this.dano = value; }
}

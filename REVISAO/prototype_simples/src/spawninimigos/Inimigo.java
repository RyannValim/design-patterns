package spawninimigos;

import java.util.List;
import java.util.ArrayList;

public class Inimigo implements Prototype<Inimigo>{
    private String nome;
    private int vida;
    private double velocidade;
    private List<Habilidade> habilidades = new ArrayList<>();

    public Inimigo(
        String nome,
        int vida,
        double velocidade
    ){
        this.nome = nome;
        this.vida = vida;
        this.velocidade = velocidade;
    }

    public String getNome() { return this.nome; }
    public void setNome(String value) { this.nome = value; }

    public int getVida() { return this.vida; }
    public void setVida(int value) { this.vida = value; }

    public double getVelocidade() { return this.velocidade; }
    public void setVelocidade(double value) { this.velocidade = value; }

    public List<Habilidade> getHabilidades() { return this.habilidades; }

    
    public void adicionarHabilidades(Habilidade habilidade){
        habilidades.add(habilidade);
    }
    
    @Override
    public Inimigo clonar(){
        Inimigo copiaInimigo = new Inimigo(this.nome, this.vida, this.velocidade);
        for (Habilidade habilidade : this.habilidades) {
            copiaInimigo.habilidades.add(new Habilidade(habilidade));
        }

        return copiaInimigo;
    }

    public void exibirInfo(){
        System.out.println("===== INFORMAÇÕES DO INIMIGO =====");
        System.out.println("Nome: " + getNome());
        System.out.println("Vida: " + getVida());
        System.out.println("Velocidade: " + getVelocidade());
        System.out.println("Habilidades: ");
        for (Habilidade habilidade : habilidades) {
            System.out.println(
                "--- Nome: " + habilidade.getNome() +
                " | Dano: " + habilidade.getDano()
            );
        }
        System.out.println("==================================");
    }
}

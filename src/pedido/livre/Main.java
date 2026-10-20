package pedido.livre;

public class Main{
    public static void main(String[] args){
        Pedido p = new Pedido();
        p.setStatus("Preparando!");
        p.notificar();

        p.setStatus("Pedido pronto!");
        p.notificar();
    }
}
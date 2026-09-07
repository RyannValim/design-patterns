package estudos.heranca.src;

public class Main {
    public static void main(String[] args){
        Animal cachorro = new Cachorro();
        System.out.println("Este animal emite o som: " + cachorro.emiteSom());
    }
}

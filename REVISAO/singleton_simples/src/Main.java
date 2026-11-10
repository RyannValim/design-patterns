public class Main {
    public static void main(String[] args){
        AppSettings appSettings = AppSettings.getInstance();

        Header header = new Header();
        header.show();

        Footer footer = new Footer();
        footer.show();

        appSettings.setLanguage("en");

        header.show();

        footer.show();
    }
}

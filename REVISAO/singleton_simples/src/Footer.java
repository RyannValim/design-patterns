public class Footer {
    public void show(){
        AppSettings appSettings = AppSettings.getInstance();

        System.out.println("Footer: " + appSettings.getLanguage());
    }
}

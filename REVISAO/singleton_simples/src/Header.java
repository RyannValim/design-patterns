public class Header {
    public void show(){
        AppSettings appSettings = AppSettings.getInstance();
        
        System.out.println("Header: " + appSettings.getLanguage());
    }
}

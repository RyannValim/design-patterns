public class AppSettings { // singleton
    private String language = "pt";
    private static AppSettings instance = null;

    private AppSettings(){}

    public String getLanguage() { return this.language; }
    public void setLanguage(String value) { this.language = value; }

    public static AppSettings getInstance(){
        if(instance == null){
            instance = new AppSettings();
        }

        return instance;
    }
}

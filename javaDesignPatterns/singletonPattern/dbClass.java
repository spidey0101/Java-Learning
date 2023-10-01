package singletonPattern;

public class dbClass {
    
    private static dbClass instance;

    private dbClass() {

    }

    public static dbClass getInstance() {
        if(instance == null) {
            instance=new dbClass();
        } 
        return instance;
    }

    public String getName() {
        return "Bhaskar";
    }

    public String getNumber() {
        return "7005";
    }
}

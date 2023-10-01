package singletonPattern;
import java.util.*;
import java.util.concurrent.TimeUnit;  

class mainClass {
    public static void main(String[] args) {
        mainClass clazz = new mainClass();
        clazz.mainWork();
        
    }
    
    private void mainWork() {
        // create 2 theme factories Dark and Light themes that generate UI components of themes respectively
        // The components should be relative like white text on dark theme and vice versa.
        getData();
    }
    
    private void getData() {
        getName();
        getNumber();
    }

    private void getNumber() {
        dbClass claz= dbClass.getInstance();
        
        System.out.println(claz.getNumber());
    }

    private void getName() {
        dbClass claz= dbClass.getInstance();
        
        System.out.println(claz.getName());

    }
    }
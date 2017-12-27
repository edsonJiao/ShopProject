package test;

import com.example.UI.MainPage;
import com.example.UI.impl.MainPageImpl;

public class MainClass {
    public static void main(String[] args){
        MainPage mainPage=new MainPageImpl();
        mainPage.show();
    }
}

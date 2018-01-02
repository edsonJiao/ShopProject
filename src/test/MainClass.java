package test;

import com.example.ui.MainPage;
import com.example.ui.impl.MainPageImpl;

public class MainClass {
    public static void main(String[] args){
        MainPage mainPage=new MainPageImpl();
        mainPage.show();
    }
}

package test;

import com.example.Utils.PasswordEncrypte;
import com.example.Utils.VerificationCode;
import org.junit.Test;

public class SimpleTest {
    @Test
    public void testEncode(){
        String str1;
        String str2;
        str1=PasswordEncrypte.encodePassword("123456");
        System.out.println(str1);
        str2=PasswordEncrypte.decodePassword(str1);
        System.out.println(str2);
    }
    @Test
    public void testVerificationCode(){
        VerificationCode v=new VerificationCode();
        System.out.println(v.createVerification());
    }
}

package inlämningsuppgift_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import junit.framework.TestCase;
import org.junit.Test;

public class medlemmarTest {
    Medlemmar lista = new Medlemmar();
    SkrivTillFil skriva = new SkrivTillFil();
    
    
    
    @Test
    public void setMedlemTest1(){

       TestCase.assertFalse(lista.checkMedlem(false, 4));
       TestCase.assertFalse(lista.checkMedlem(false,5));
       TestCase.assertTrue(lista.checkMedlem(true, 3));
       TestCase.assertTrue(lista.checkMedlem(true,1));
       
    }
    @Test 
    public void söklistaTest1() throws IOException{
        
       TestCase.assertEquals(true,lista.sökLista("alhambra aromes"));
       TestCase.assertEquals(false,lista.sökLista("kenny hoang"));
       TestCase.assertEquals(true,lista.sökLista("7603021234"));
       TestCase.assertTrue(lista.sökLista("bear belle"));
       TestCase.assertFalse(lista.sökLista("bla bla"));
       
    }
    @Test
    public void skrivTillFilTest() throws IOException{
        
        String filnamn ="src/inlämningsuppgift_2/besökare.txt";
        
        TestCase.assertTrue(skriva.skrivTillFil(1, filnamn));
        TestCase.assertFalse(skriva.skrivTillFil(0, filnamn));
        
    }
}

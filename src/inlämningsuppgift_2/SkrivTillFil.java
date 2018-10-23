package inlämningsuppgift_2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Johnny
 */
public class SkrivTillFil {
    
    Medlemmar medlemmar = new Medlemmar();
        public boolean skrivTillFil(int index, String filnamn){
        
        Scanner scan = new Scanner(System.in);
        List<Person> personer = new ArrayList<>();
        personer = medlemmar.getList();
        String utskrift="";
        while (true){
            try(FileWriter writer = new FileWriter(filnamn,true);){
                   if(personer.get(index).medlem){
                        utskrift = personer.get(index).namn +" - personnummer: " +
                        personer.get(index).personNummer + "\nTränade " + LocalDate.now()+"\n";
                        writer.write(utskrift);
                        writer.close(); 
                        return true;
                    }
                    else
                        return false;

            }
            catch(IOException e){
                System.out.println("Det gick inte att skriva till filen");
                e.printStackTrace();
                System.exit(0);
            }
        }    
    }
}

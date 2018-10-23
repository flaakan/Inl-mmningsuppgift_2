package inlämningsuppgift_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Medlemmar{
    List<Person> personer = new ArrayList<>();
    String namn;
    String personNr;
    int index = 0;
    String filnamn ="src/inlämningsuppgift_2/besökare.txt";
    
    public Medlemmar(){
        skapaLista();
    }
    
    public void skapaLista(){
        
        int i=0;
        String s="";
        Path p = Paths.get("src/inlämningsuppgift_2/customers.txt");
        
        try(BufferedReader input = Files.newBufferedReader(p);){
            
            LocalDate tid;
            LocalDate nu = LocalDate.now();
            LocalDate Ar = nu.minusYears(1);
            
            while((s = input.readLine())!=null){
                i++;
                if(i%2 ==1){
                    if(s.lastIndexOf(",")>1 && s.indexOf(",")>1){
                        namn = s.substring(s.lastIndexOf(",")+1).trim();
                        personNr = s.substring(0,s.indexOf(",")).trim();
                    }
                }
                else{
                    tid = LocalDate.parse(s);
                    
                    if((tid.isAfter(Ar)) & (tid.isBefore(nu))){          
                        Person person = new Person();
                        person.namn = namn;
                        person.personNummer = personNr;
                        person.medlem = true;
                        personer.add(person);

                    }
                    else{
                        Person person = new Person(); 
                        person.namn = namn;
                        person.personNummer = personNr;
                        person.medlem = false;
                        personer.add(person);
                    }
                }  
            }
        }
                       
        catch(NoSuchFileException e){
            System.out.println("Filen existerar inte");
            e.printStackTrace();
            System.exit(0);
        }
        
        catch(FileNotFoundException e){
            System.out.println("Filen kunde inte hittas");
            e.printStackTrace();
            System.exit(0);
        }
        
        catch (Exception e){
            System.out.println("Något gick fel");
            e.printStackTrace();
            System.exit(0);
        }
        
    }
    protected void indata(){
        
        while(true){
            Scanner scan = new Scanner(System.in);
            index = 0;
            System.out.println("Skriv in namn eller personnummer (ååmmddxxxx) "); //ååmmddxxxx
            String inmatning = scan.nextLine();
            
            if(sökLista(inmatning)){
               break; 
            }
            
        }
    }
    
    protected boolean sökLista(String namn){
         
        index = 0;
        SkrivTillFil skriva = new SkrivTillFil();
        
        for(Person p: personer){      
            if(namn.equalsIgnoreCase("alhambra aromes")||namn.equalsIgnoreCase("7603021234")){
                checkMedlem(p.medlem,0);
                return true;                       
            }  
            

            if(namn.equalsIgnoreCase(p.namn)){    
                if(checkMedlem(p.medlem,index) == true)
                    skriva.skrivTillFil(index,filnamn);
                return true;
                    
            }
            else if (namn.equalsIgnoreCase(p.personNummer)){
                if(checkMedlem(p.medlem,index) == true)
                    skriva.skrivTillFil(index,filnamn);
                return true;
            }
        
        if(index==personer.size())
            break;
        index++;
        }
        
        System.out.println("personen finns inte");
        return false;
    }
        
    protected boolean checkMedlem(boolean medlem,int index){
        
        if(medlem){
            System.out.println(personer.get(index).namn + " finns och är medlem");
            return true;
        }
        else{
            System.out.println(personer.get(index).namn + " finns men är inte medlem");
            return false;
        }
    }
    
    
    protected List<Person> getList(){
        return personer;
    }
}
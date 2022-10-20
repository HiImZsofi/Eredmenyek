import hu.petrik.versenyeredmenyek.Eredemny;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private static Map<String, List<Eredemny>> sportagEredmenyek = new HashMap<>();
    public static void main(String[] args) throws FileNotFoundException {
        try {
            beolvas("eredmenyek.txt");
        } catch (FileNotFoundException e){
            System.out.println("nem jo");
        }
        kiiras();
    }

    private static void beolvas(String fajlnev) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fajlnev));
        while(file.hasNext()){
            String[] sor = file.nextLine().split(" ");
            String sportag = sor[0];
            String reszIdo = sor[1];
            String nev = sor[2] + " " + sor[3];
            sportagEredmenyek.putIfAbsent(sportag, new ArrayList<>());
            Eredemny eredmeny = new Eredemny(reszIdo, nev);
            sportagEredmenyek.get(sportag).add(eredmeny);
        }
        file.close();
    }

    private static void kiiras(){
        for (Map.Entry<String, List<Eredemny>> entry : sportagEredmenyek.entrySet()) {
            String sportag = entry.getKey();
            List<Eredemny> eredmenyek = entry.getValue();
            System.out.println(sportag);
            for (Eredemny eredmeny : eredmenyek) {
                System.out.println("\t" + eredmeny);
            }
        }
    }
}
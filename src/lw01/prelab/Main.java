package lw01.prelab;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        List<PrintJob> printJobs = new ArrayList<>();

        Scanner sc = new Scanner(new File("src/lw01/prelab/jobs.txt"));
        
        while (sc.hasNext()) {
            String tipe = sc.next(); 
            String id = sc.next();
            int pages = sc.nextInt();

            if (tipe.equalsIgnoreCase("Mono")) {
                printJobs.add(new MonoPrint(id, pages));
            } else if (tipe.equalsIgnoreCase("Colour")) {
                printJobs.add(new ColourPrint(id, pages));
            }
        }
        sc.close();
                
        for (PrintJob job : printJobs) {
            System.out.println(job.summary());
        }
    }
}
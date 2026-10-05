package lw03.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

        List<String> checked = new ArrayList<>();
       
        Map<String, Integer> matkul = new HashMap<>();

        int rejected = 0;

        while (sc.hasNext()) {

            String line = sc.nextLine();
            String operation = line.substring(0, line.indexOf(" "));
            

            if (operation.equals("REGISTER")) {

                String parts = line.substring(line.indexOf(" ") + 1);        
                String course = parts.substring(0, parts.indexOf(" "));
                int count = Integer.parseInt(parts.substring(parts.indexOf(" ") + 1));

                if (matkul.containsKey(course)) {
                    matkul.put(course, matkul.get(course) + count);
                } else {
                    matkul.put(course, count);
                }

            } else if (operation.equals("WITHDRAW")) {

                String parts = line.substring(line.indexOf(" ") + 1);        
                String course = parts.substring(0, parts.indexOf(" "));
                int count = Integer.parseInt(parts.substring(parts.indexOf(" ") + 1));

                if (matkul.containsKey(course) && matkul.get(course) >= count) {
                    if ((matkul.get(course) - count ) >= 0) {
                        matkul.put(course, matkul.get(course) - count);
                    } else {
                        rejected++;
                    }
                } else {
                    rejected++;
                }

            } else if (operation.equals("CHECK")) {

                String course = line.substring(line.indexOf(" ") + 1);

                if (matkul.containsKey(course)){
                    checked.add(course + ": " + matkul.get(course) + " students");
                } else {
                    checked.add(course + ": Not Found");
                    rejected++;
                }

            }
        }

        System.out.println("==== Enrollment Check ====");

        for (String c : checked){
            System.out.println(c);
        }

        System.out.println();
        System.out.println("==== Final Enrollment ====");

        for (String m : matkul.keySet()){
            System.out.println(m + ": " + matkul.get(m) + " students");
        }

        System.out.println();
        System.out.println("Rejected Operations: " + rejected);

    }
}

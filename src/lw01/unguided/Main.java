package lw01.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Rental[] rental;

        Scanner sc = new Scanner(Main.class.getResourceAsStream("rentals.txt")); 

        int T = sc.nextInt();

        rental = new Rental[T];

        for (int i = 0; i < T; i++) {
            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            int units = sc.nextInt();

                if (type.equals("LAPTOP")) {
                    rental[i] = new LaptopRental(id, days, units);
                } else {
                    rental[i] = new ProjectorRental(id, days, units);
                }
            }
        
        for (Rental r : rental) {
            System.out.println(r.summary());
        }
    }
}


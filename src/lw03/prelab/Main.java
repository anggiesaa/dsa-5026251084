package lw03.prelab;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //PROBLEM 1
        
        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        List<String> playlist = new ArrayList<>();
    
        while (sc.hasNext()){

            String input = sc.nextLine();
            String action = input.substring(0, input.indexOf(" "));
            if (action.equals("ADD")){
                String judul = input.substring(input.indexOf(" ")+1);
                playlist.add(judul);
            } else if (action.equals("REMOVE")){
                String judul = input.substring(input.indexOf(" ")+1);
                playlist.remove(judul);
            } else {
                String details = input.substring(input.indexOf(" ")+1);
                int index = Integer.parseInt(details.substring(0, details.indexOf(" ")));
                String judul = details.substring(details.indexOf(" ")+1);
                playlist.add(index, judul);
            }
        }

        System.out.println("==== Problem 1 ====");
        System.out.println("Total Song: " + playlist.size());
        //System.out.println("Daftar lagu: ");
        int num = 1;
        for (String j : playlist){
            System.out.println(num + ": " + j);
            num++;
        }   

        // PROBLEM 2

        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("participant.txt"));

        Set<String> participants = new LinkedHashSet<>();
        int duplicate = 0;

        while (sc2.hasNext()){
            String nama = sc2.nextLine();
            if (participants.contains(nama)){
                duplicate++;
            } 
            participants.add(nama);
        }

        System.out.println("==== Problem 2====");
        System.out.println("Unique Participant: " + participants.size());

        int num2 = 1;
        for (String p : participants){
            System.out.println(num2 + ": " + p);
            num2++;
        }

        System.out.println("Duplicate Participant: " + duplicate);

        //PROBLEM 3

        Scanner sc3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failed = 0;

        while (sc3.hasNext()){

            String input = sc3.nextLine();
            String[] parts = input.split(" ");
                String action = parts[0];
                String item = parts[1];
                int quantity = Integer.parseInt(parts[2]);

            if(action.equals("ADD")){
                if(inventory.containsKey(item)){
                    inventory.put(item, inventory.get(item)+quantity);
                } else {
                    inventory.put(item, quantity);
                }
            } else {
                if (inventory.containsKey(item) && inventory.get(item) >= quantity){
                    inventory.put(item, inventory.get(item) - quantity);
                } else {
                    failed++;
                }
            }
        }

        System.out.println("==== Problem 3 ====");
        for (String key : inventory.keySet()){
            System.out.println(key + ": " + inventory.get(key));
        }
        System.out.println("Failed Sales: " + failed);
    }
}


package lw02.unguided;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        LinkedList<String[]> requests = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();

        Queue<String[]> processed = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        while (sc.hasNext()) {
            String[] request = new String[2];
            request[0] = sc.next();
            request[1] = sc.next();
            requests.add(request);
        }
        sc.close();

        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});

        processed.addAll(requests);
        int MAX_BORROW = 2;

        while (!processed.isEmpty()) {

            String[] request = processed.poll();

            String member = request[0];
            String book = request[1];

            String[] history = null;
            
            //cek apakah member sdh ada di list members
            for (String[] data : members) {
                if (data[0].equals(member)) {
                    history = data;
                    break;
                }
            }

            //kl blm ada, tambahkan
            if (history == null) {
                history = new String[]{member, "0"};
                members.add(history);
            }

            //cek juduk buku
            String[] borrowedBook = null;
            for (String[] data : books) {
                if (data[0].equals(book)) {
                    borrowedBook = data;
                    break;
                }
            }

            //cek member
            String[] borrowerMember = null;
            for (String[] data : members) {
                if (data[0].equals(member)) {
                    borrowerMember = data;
                    break;
                }
            }

            if (borrowedBook != null && borrowerMember != null) {
                int stok = Integer.parseInt(borrowedBook[1]);
                int count = Integer.parseInt(borrowerMember[1]);

                if (stok > 0 && count < MAX_BORROW) {

                    for (String[] dataBuku : books) {
                        if (dataBuku[0].equals(book)) {
                            dataBuku[1] = String.valueOf(stok - 1);
                            break;
                        }
                    }

                    for (String[] dataMember : members) {
                        if (dataMember[0].equals(member)) {
                            dataMember[1] = String.valueOf(count + 1);
                            break;
                        }
                    }


                } else {
                    failed.push(request);
                }

            } else {
                failed.push(request);
            }
        }

        //outpur

        System.out.println("=== Successfully Processed Requests ===\r\n");
       
        for (String[] request : requests) {
            System.out.println(request[0] + " " + request[1]);
        }

        System.out.println("\n=== Remaining Book Stock ===\r\n");

        for (String[] book : books) {
            System.out.println(book[0] + " " + book[1]);
        }

        System.out.println("\n=== Failed Requests ===\r\n");
        
        for (String[] request : failed) {
            System.out.println(request[0] + " " + request[1]);
        }
    }
}

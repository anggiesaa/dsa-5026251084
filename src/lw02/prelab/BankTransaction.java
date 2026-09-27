package lw02.prelab;

import java.util.*;

public class BankTransaction {
    public static void main(String[] args) {

    List<String[]> transactions =  new LinkedList<>();

    Scanner sc = new Scanner(BankTransaction.class.getResourceAsStream("transactions.txt"));

        while (sc.hasNext()) {

            String[] transaction = new String[3];
            transaction[0] = sc.next();
            transaction[1] = sc.next();
            transaction[2] = sc.next();
            transactions.add(transaction);

        }

    List<String[]> customerRecords =  new LinkedList<>();
    
    HashSet<String> namaCust = new HashSet<>();

    for (String[] transaction : transactions) {
        String nama = transaction[0]; 

            
        if (!namaCust.contains(nama)) {
            namaCust.add(nama); 
            customerRecords.add(new String[]{nama, "0"}); 
        }
    }

    Queue<String[]> processedTransactions = new LinkedList<>();

    while (!transactions.isEmpty()) {
        processedTransactions.offer(transactions.removeFirst());
    }

    Stack<String[]> failedTransactions = new Stack<>();

        while (!processedTransactions.isEmpty()) {
            String[] current = processedTransactions.poll();
            String name = current[0];
            String type = current[1];
            int amount = Integer.parseInt(current[2]);

            for (String[] customer : customerRecords) {
                if (customer[0].equals(name)) {
                    int balance = Integer.parseInt(customer[1]);

                    if (type.equals("DEPOSIT")) {
                        customer[1] = String.valueOf(balance + amount);
                    } else if (type.equals("WITHDRAW")) {
                        if (amount > balance) {
                            failedTransactions.push(current);
                        } else {
                            customer[1] = String.valueOf(balance - amount);
                        }
                    }
                    break;
                }
            }
        } 

    System.out.println("=== Final Balances ===");
        for (String[] customer : customerRecords) {
            System.out.println(customer[0] + " : " + customer[1]);
        }

        System.out.println("\n=== Failed Transactions ===");
        while (!failedTransactions.isEmpty()) {
            String[] failed = failedTransactions.pop();
            System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
        }
    }
}

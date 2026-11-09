package lw04.unguided;

import java.util.*;

public class Main {
    
    static void selectionSort(int[] a, int pass){
        for (int i = 0; i < pass && i < a.length; i++){
            int min = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[j] < a[min]){
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    static int search (int[]a, int target){
        for (int i = 0; i < a.length; i++){
            if (a[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));

        int n = sc.nextInt();

        int[] cards = new int[n];
        for (int i = 0; i < n; i++){
            cards[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        int[] targets = new int[m];
        for (int i = 0; i < m; i++){
            targets[i] = sc.nextInt();
        }

        selectionSort(cards, 2);

        for (int i = 0; i < cards.length; i++){
            System.out.print(cards[i] + " ");
        }
        System.out.println();

        for (int t : targets){
            int hasil = search(cards, t);

            if (hasil == -1){
                System.out.println(t + ": NOT FOUND");
            } else {
                System.out.println(t + ": FOUND at index " + hasil);
            }
        }
    }
}

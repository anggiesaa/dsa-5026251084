package lw04.prelab;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = sc.nextInt();

        int[] branches = new int[n];
        for (int i = 0; i < n; i++){
            branches[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        int[] targets = new int[m];
        for (int i = 0; i < m; i++){
            targets[i] = sc.nextInt();
        }

        sort(branches, 3);

        for (int i = 0; i < branches.length; i++){
            System.out.print(branches[i] + " ");
        }
        System.out.println();

        for (int t : targets){
            int hasil = search(branches, t);
    
            if (hasil == -1){
                System.out.println(t + ": NOT FOUND");
            } else {
                System.out.println(t + ": FOUND at index " + hasil);
            }
        }
    }

    static void sort(int[]array, int pass){
        for (int i = 1; i <= pass; i++){
            int temp = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j] < temp){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    static int search (int[]array, int target){
        for (int i = 0; i < array.length; i++){
            if (array[i] == target){
                return i;
            }
        }
        return -1;
    }
    
}

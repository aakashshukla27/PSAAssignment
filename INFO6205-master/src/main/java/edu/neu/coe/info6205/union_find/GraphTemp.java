package edu.neu.coe.info6205.union_find;
import java.util.Random;

public class GraphTemp {
    private static boolean cycle = false;


    static int generateRandomNumber(int n) {
        Random rand = new Random();
        return rand.nextInt(n);
    }


    public static int count(int n)  {
        int countReturn = 0;
        UF_HWQUPC uf = new UF_HWQUPC(n);
        int successfulUnion = 0;
        int redundant = 0;
        while (!cycle) {
            int p = generateRandomNumber(n);
            int q = generateRandomNumber(n);
            System.out.println("Random Pair Generated: (" + p + "," + q + ")");
            if (!uf.connected(p, q)) {
                System.out.println("Connecting pair :("+ p + "," + q + ")");
                successfulUnion++;
                uf.union(p, q);
                countReturn++;
            }
            else{
                redundant++;
                System.out.println("Pair (" + p + "," + q + ") already connected");
            }
            if(uf.isCycle()){
                cycle = true;
                System.out.println("Successful Unions: " + successfulUnion);
                System.out.println("Redundant Unions: " + redundant);
            }
        }
        return countReturn;
    }


    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        System.out.println(count(n));
    }
}

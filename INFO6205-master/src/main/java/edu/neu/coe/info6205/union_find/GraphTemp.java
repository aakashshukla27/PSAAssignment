package edu.neu.coe.info6205.union_find;



import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.TimeLogger;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class GraphTemp {
    private static boolean cycle1 = false;
    private static boolean cycle2 = false;
    private static boolean cycle3 = false;

    static int generateRandomNumber(int n) {
        Random rand = new Random();
        return rand.nextInt(n);
//        return ThreadLocalRandom.current().nextInt(0, n);
    }


    public static int count(int n)  {
        cycle1 = false;
        int countReturn = 0;
        UF_HWQUPC uf = new UF_HWQUPC(n);
        //WeightedQuickUnionWithPathCompression uf = new WeightedQuickUnionWithPathCompression(n);
        int successfulUnion = 0;
        int redundant = 0;
        while (!cycle1) {
            int p = generateRandomNumber(n);
            int q = generateRandomNumber(n);
            //System.out.println("Random Pair Generated: (" + p + "," + q + ")");
            if (!uf.connected(p, q)) {
                //System.out.println("Connecting pair :("+ p + "," + q + ")");
                successfulUnion++;
                uf.union(p, q);
                countReturn++;
            }
            else{
                redundant++;
                //System.out.println("Pair (" + p + "," + q + ") already connected");
            }

            if(uf.components() == 1){
                cycle1 = true;
//                System.out.println("Successful Unions: " + successfulUnion);
//                System.out.println("Redundant Unions: " + redundant);
            }

        }
        return countReturn;
    }


    public static int countPathCompression(int n)  {
        cycle2 = false;
        int countReturn = 0;
        WeightedQuickUnionWithPathCompression uf = new WeightedQuickUnionWithPathCompression(n);
        int successfulUnion = 0;
        int redundant = 0;
        while (!cycle2) {
            int p = generateRandomNumber(n);
            int q = generateRandomNumber(n);
            //System.out.println("Random Pair Generated: (" + p + "," + q + ")");
            if (!uf.connected(p, q)) {
                //System.out.println("Connecting pair :("+ p + "," + q + ")");
                successfulUnion++;
                uf.union(p, q);
                countReturn++;
            }
            else{
                redundant++;
                //System.out.println("Pair (" + p + "," + q + ") already connected");
            }

            if(uf.components() == 1){
                cycle2 = true;
//                System.out.println("Successful Unions: " + successfulUnion);
//                System.out.println("Redundant Unions: " + redundant);
            }

        }
        return countReturn;
    }



    public static int countUFHeight(int n)  {
        cycle3 = false;
        int countReturn = 0;
        WeightQuickUnionHeight uf = new WeightQuickUnionHeight(n);
        int successfulUnion = 0;
        int redundant = 0;
        while (!cycle3) {
            int p = generateRandomNumber(n);
            int q = generateRandomNumber(n);
            //System.out.println("Random Pair Generated: (" + p + "," + q + ")");
            if (!uf.connected(p, q)) {
                //System.out.println("Connecting pair :("+ p + "," + q + ")");
                successfulUnion++;
                uf.union(p, q);
                countReturn++;
            }
            else{
                redundant++;
                //System.out.println("Pair (" + p + "," + q + ") already connected");
            }

            if(uf.count() == 1){
                cycle3 = true;
//                System.out.println("Successful Unions: " + successfulUnion);
//                System.out.println("Redundant Unions: " + redundant);
            }
        }
        return countReturn;
    }



    public static void main(String[] args){

        System.out.println("With path compression - assignment");
        final Supplier<Integer> input = () -> {

            return 1600;
        };
        final double t1 = new Benchmark_Timer<Integer>("input size: " + 16000 ,
                xs -> countPathCompression(xs)).runFromSupplier( input, 100);

        System.out.println(t1);
        final Supplier<Integer> input2 = () -> {

            return 3200;
        };
        final double t2 = new Benchmark_Timer<Integer>("input size: " + 32000 ,
                xs -> countPathCompression(xs)).runFromSupplier( input2, 100);

        System.out.println(t2);
        final Supplier<Integer> input3 = () -> {

            return 6400;
        };
        final double t3 = new Benchmark_Timer<Integer>("input size: " + 64000 ,
                xs -> countPathCompression(xs)).runFromSupplier( input3, 100);

        System.out.println(t3);
        final Supplier<Integer> input4 = () -> {

            return 12800;
        };
        final double t4 = new Benchmark_Timer<Integer>("input size: " + 128000 ,
                xs -> countPathCompression(xs)).runFromSupplier( input4, 100);

        System.out.println(t4);
        final Supplier<Integer> input5 = () -> {

            return 25600;
        };
        final double t5 = new Benchmark_Timer<Integer>("input size: " + 256000 ,
                xs -> countPathCompression(xs)).runFromSupplier( input5, 100);
        System.out.println(t5);
        
        
        
        
        
        
        System.out.println("Without path compression - assignment");
        final Supplier<Integer> input6 = () -> {

            return 16000;
        };
        final double t6 = new Benchmark_Timer<Integer>("input size: " + 16000 ,
                xs -> countUFHeight(xs)).runFromSupplier( input6, 100);

        System.out.println(t6);
        final Supplier<Integer> input7 = () -> {

            return 32000;
        };
        final double t7 = new Benchmark_Timer<Integer>("input size: " + 32000 ,
                xs -> countUFHeight(xs)).runFromSupplier( input7, 100);

        System.out.println(t7);
        final Supplier<Integer> input8 = () -> {

            return 64000;
        };
        final double t8 = new Benchmark_Timer<Integer>("input size: " + 64000 ,
                xs -> countUFHeight(xs)).runFromSupplier( input8, 100);

        System.out.println(t8);
        final Supplier<Integer> input9 = () -> {

            return 128000;
        };
        final double t9 = new Benchmark_Timer<Integer>("input size: " + 128000 ,
                xs -> countUFHeight(xs)).runFromSupplier( input9, 100);

        System.out.println(t9);
        final Supplier<Integer> input10 = () -> {

            return 256000;
        };
        final double t10 = new Benchmark_Timer<Integer>("input size: " + 256000 ,
                xs -> countUFHeight(xs)).runFromSupplier( input10, 100);
        System.out.println(t10);
        
        
        System.out.println("With path compression - old");
        final Supplier<Integer> input11 = () -> {

            return 16000;
        };
        final double t11 = new Benchmark_Timer<Integer>("input size: " + 16000 ,
                xs -> count(xs)).runFromSupplier( input11, 100);

        System.out.println(t11);
        final Supplier<Integer> input12 = () -> {

            return 32000;
        };
        final double t12 = new Benchmark_Timer<Integer>("input size: " + 32000 ,
                xs -> count(xs)).runFromSupplier( input12, 100);

        System.out.println(t12);
        final Supplier<Integer> input13 = () -> {

            return 64000;
        };
        final double t13 = new Benchmark_Timer<Integer>("input size: " + 64000 ,
                xs -> count(xs)).runFromSupplier( input13, 100);

        System.out.println(t13);
        final Supplier<Integer> input14 = () -> {

            return 128000;
        };
        final double t14 = new Benchmark_Timer<Integer>("input size: " + 128000 ,
                xs -> count(xs)).runFromSupplier( input14, 100);

        System.out.println(t14);
        final Supplier<Integer> input15 = () -> {

            return 256000;
        };
        final double t15 = new Benchmark_Timer<Integer>("input size: " + 256000 ,
                xs -> count(xs)).runFromSupplier( input15, 100);
        System.out.println(t15);
        
    }
}

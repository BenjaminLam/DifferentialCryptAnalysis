import java.lang.reflect.Array;
import java.util.ArrayList;

public class CipherThree {
    static int[] S = {6, 4, 12, 5, 0, 7, 2, 14, 1, 15, 3, 13, 8, 10, 9, 11};
    static int[] R = {4, 8, 6, 10, 1, 3, 0, 5, 12, 14, 13, 15, 2, 11, 7, 9};


    public static void main (String[] args){
        Tuple pair0 = new Tuple(0,1,15,9);
        Tuple pair1 = new Tuple(1,13,14,7);
        Tuple pair2 = new Tuple(2,8,13,11);
        Tuple pair3 = new Tuple(3,10,12,5);
        Tuple pair4 = new Tuple(4,4,11,12);
        Tuple pair5 = new Tuple(5,3,10,14);
        Tuple pair6 = new Tuple(6,0,9,6);
        Tuple pair7 = new Tuple(7,2,8,15);

        ArrayList<Tuple> pairs = new ArrayList<>();
        pairs.add(pair0);
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);
        pairs.add(pair4);
        pairs.add(pair5);
        pairs.add(pair6);
        pairs.add(pair7);

        for (Tuple pair : pairs) {
            System.out.println(pair.toString());
            int c0= pair.getC0();
            int c1=pair.getC1();
            int counter=0;
            ArrayList<Integer> counterList = new ArrayList<>();
            //difference 12 (c)
            getDifference(12,counter,counterList,c0,c1);
        }
        ArrayList<Tuple> pairsAfterK3 = new ArrayList<>();

        //Best Guess for k3 = 6
        int k3 = 6;
        System.out.println("We guess for k3=" + k3);
        decryptOnce(pairs,k3,pairsAfterK3);

        for(Tuple pair : pairsAfterK3){
            System.out.println(pair.toString());
            int c0= pair.getC0();
            int c1=pair.getC1();
            int counter=0;
            ArrayList<Integer> counterList = new ArrayList<>();
            //getDifference 13 (d)
            getDifference(13,counter, counterList,c0,c1);
        }
        ArrayList<Tuple> pairsAfterK2 = new ArrayList<>();
        //Best quess for k2 = 3
        int k2 = 3;
        System.out.println("We guess for k2=" + k2);
        decryptOnce(pairsAfterK3,k2,pairsAfterK2);

        for(Tuple pair : pairsAfterK2){
            System.out.println(pair.toString());
            int c0= pair.getC0();
            int c1=pair.getC1();
            int counter=0;
            ArrayList<Integer> counterList = new ArrayList<>();
            //getDifference 15 (d)
            getDifference(15,counter, counterList,c0,c1);
        }
        //best guess for k1 = 4
        int k1 = 4;
        ArrayList<Tuple> pairsAfterK1 = new ArrayList<>();
        decryptOnce(pairsAfterK2,k1,pairsAfterK1);
        int k0=guessKO(pairsAfterK1.get(2), k1);
        //best guess for k0 = 1
        //in total we guess k0=1, k1=4, k2=3, k3=6


        //we check to see if we can encrypt every messages
        checkForEveryKeyAndPair(k0,k1,k2,k3,pairs);

    }

    public static void checkForEveryKeyAndPair(int k0, int k1, int k2, int k3, ArrayList<Tuple> pairs){
        for(Tuple pair : pairs){
            int m0= pair.getM0();
            int m1 = pair.getM1();
            int c0 = pair.getC0();
            int c1 = pair.getC1();

            boolean test1 = c0==(S[S[S[m0^k0]^k1]^k2]^k3);
            boolean test2 = c1==(S[S[S[m1^k0]^k1]^k2]^k3);
            System.out.println(test1);
            System.out.println(test2);
        }

    }
    public static int guessKO(Tuple pair, int k1){
        int m0 = pair.getM1();
        int w0 = pair.getC1();

        int k0 = m0^R[w0^k1];
        System.out.println("k0 = " + k0);
        return k0;
    }

    protected static void decryptOnce(ArrayList<Tuple> pairs, int key, ArrayList<Tuple> result){
        for (Tuple pair : pairs){
            int c0= pair.getC0();
            int c1=pair.getC1();
            int y0 = R[c0^key];
            int y1 = R[c1^key];
            result.add(new Tuple(pair.getM0(),y0,pair.getM1(),y1));
        }
    }


    protected static void getDifference(int d, int counter, ArrayList<Integer> counterList, int c0, int c1){
        for(int i = 0; i<16; i++) {

            int x0 = c0 ^ i;
            int x1 = c1 ^ i;

            int w0 = R[x0];
            int w1 = R[x1];

            int v = w0 ^ w1;

            if (v == d) {
                counter++;
                counterList.add(i);
            }
        }
        System.out.println("Counter = " + counter);
        System.out.println("Keys that give c: " + counterList.toString());

    }


}

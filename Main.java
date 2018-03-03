import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] S = {6,4,12,5,0,7,2,14,1,15,3,13,8,10,9,11};
    static int[] R = {4,8,6,10,1,3,0,5,12,14,13,15,2,11,7,9};

    // (m,c)
    // Pair one 0 (1,e)
    Tuple pairOne = new Tuple(1,14);
    Tuple pairTwo = new Tuple(14,9);

    Tuple pairThree = new Tuple(2,6);
    Tuple pairFour = new Tuple(13,10);

    Tuple pairFive = new Tuple(3,7);
    Tuple pairSix = new Tuple(13,11);

    ArrayList<Tuple> diffOne = new ArrayList<Tuple>();
    ArrayList<Tuple> diffTwo = new ArrayList<Tuple>();
    ArrayList<Tuple> diffThree = new ArrayList<Tuple>();

    //pair1,2 -> 2
    //   5, 2

    //pair3,4 -> 6
    //  0,2,3,12,14,15

    //pair5,6 -> 6
    // 1,2,3,13,14,15

    //As 2 is en every one of them, thats our best quess for k2.
    public static void main(String[] args) {
        int counter=0;
        ArrayList<Integer> counterList = new ArrayList<>();
        for(int i=0; i<16;i++){
            int c1 = 7;
            int c2 = 11;

            int x1 = c1^i;
            int x2 = c2^i;

            //System.out.println(x1);
            //System.out.println(x2);

            int w1 = R[x1];
            int w2 = R[x2];
            //System.out.println(w1);
            //System.out.println(w2);

            int v = w1^w2;

            if(v==13){
               counter++;
               counterList.add(i);
            }
            System.out.println(i + ": " + v + " ");
        }
        System.out.println("Counter = " + counter);
        System.out.println("Keys that give d: " + counterList.toString());
        /*
        int firstK = 13;
       int c1 = 14;
       int c2 = 9;

       int x1 = c1^firstK;
       int x2 = c2^firstK;
        System.out.println(x1);
        System.out.println(x2);

       int w1 = R[x1];
       int w2 = R[x2];
        System.out.println(w1);
        System.out.println(w2);

       int v = w1^w2;

       System.out.println(v);*/
    }

    public void initialize(){
        diffOne.add(pairOne);
        diffOne.add(pairTwo);

        diffTwo.add(pairThree);
        diffTwo.add(pairFour);

        diffThree.add(pairFive);
        diffThree.add(pairSix);
    }



    // ^ is bitwise xor.
}

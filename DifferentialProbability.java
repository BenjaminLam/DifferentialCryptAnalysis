import java.util.Arrays;

public class DifferentialProbability {
    public static int[][] differentials ={ {16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                            {0,0,6,0,0,0,0,2,0,2,0,0,2,0,4,0},
                                            {0,6,6,0,0,0,0,0,0,2,2,0,0,0,0,0},
                                            {0,0,0,6,0,2,0,0,2,0,0,0,4,0,2,0},
                                            {0,0,0,2,0,2,4,0,0,2,2,2,0,0,2,0},
                                            {0,2,2,0,4,0,0,4,2,0,0,2,0,0,0,0},
                                            {0,0,2,0,4,0,0,2,2,0,2,2,2,0,0,0},
                                            {0,0,0,0,0,4,4,0,2,2,2,2,0,0,0,0},
                                            {0,0,0,0,0,2,0,2,4,0,0,4,0,2,0,2},
                                            {0,2,0,0,0,2,2,2,0,4,2,0,0,0,0,2},
                                            {0,0,0,0,2,2,0,0,0,4,4,0,2,2,0,0},
                                            {0,0,0,2,2,0,2,2,2,0,0,4,0,0,2,0},
                                            {0,4,0,2,0,2,0,0,2,0,0,0,0,0,6,0},
                                            {0,0,0,0,0,0,2,2,0,0,0,0,6,2,0,4},
                                            {0,2,0,4,2,0,0,0,0,0,2,0,0,0,0,6},
                                            {0,0,0,0,2,0,2,0,0,0,0,0,0,10,0,2} };

    public static void main(String[] args){
        double maxProb=0;
        int a1 = differentials.length;
        int a2 = differentials[0].length;
        double prob;
        int a=0;
        int b=0;
        double[][] probabillities = new double[16][16];
        for(int i = 1; i<a1;i++){
            for (int j = 1; j<a2;j++){
                prob=differentialProb(i,j);
                probabillities[i][j]=prob;
                if(i==15 && j==14){
                    System.out.println(prob);
                }
                if(prob>maxProb){
                    maxProb=prob;
                    a=i;
                    b=j;
                }
            }
        }
        System.out.println(maxProb);
        System.out.println("a: " + a + " - b: " + b);


        for(int i =0; i<16 ; i++){
            for(int j=0;j<16;j++){
                System.out.print(probabillities[i][j] + " ");
            }
            System.out.println();
        }

    }



    public static double differentialProb(int a, int b){
        double sum = 0;
        double length=differentials.length;
        for(int i = 1; i<differentials.length; i++){
            sum += differentials[a][i]/length*differentials[i][b]/length;
            //System.out.println(differentials[a][i] + ", " + differentials[i][b] + ", sum = " + sum);
        }
        //System.out.println("sum= " + sum);
        return sum;
    }
}

public class DifferentialProbability {
    public int[][] differentials ={ {16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
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

    public DifferentialProbability(){

    }

    public int getBestDifferential(){
        int maxProb=0;
        int a1 = differentials.length;
        int a2 = differentials[0].length;
        int probability;

        int a = 0;
        int b = 0;
        for(int i = 0; i<a1;i++){
            for (int j = 0; j<a2;j++){
                probability=differentialProb(i,j);
                if( probability>maxProb){
                    maxProb=probability;
                    a=i;
                    b=j;
                }
            }
        }
        return maxProb;
    }


    public int differentialProb(int a, int b){
        int sum = 0;
        int l1 = differentials.length;
        for(int i = 2; i<differentials.length;i++){
            sum= sum + ((differentials[a][i]/l1)*(differentials[i][b])/l1);
            System.out.println(sum);
        }
        return sum;
    }
}

import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        Arrays.sort(w);
        int T[][]=new int[w.length][W+1];
        for(int i=0;i<w.length;i++){
            for(int j=0;j<W+1;j++){
                if(j==0){
                    T[i][j]=0;
                }
                else if(i==0) {
                    if (w[0] <= j) {
                        T[i][j] = w[0];
                    } else
                        T[i][j] = 0;
                }
                else{
                    if(w[i]>j){
                        T[i][j]=T[i-1][j];
                    }
                    else{
                        T[i][j]=Math.max(w[i]+T[i-1][j-w[i]],T[i-1][j]);
                    }
                }

            }
        }
        return T[w.length-1][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}


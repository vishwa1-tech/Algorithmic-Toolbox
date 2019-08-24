import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class hack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int i,j;
        int a[][] = new int[n][2];
        for (i = 0; i < n; i++) {
            for (j = 0; j < 2; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sortbyColumn(a, 0);
        double s=knapsack(n,w,a);
        double t=(double)Math.round(s * 10000d) / 10000d;
        System.out.println(t);
    }
    public static double knapsack(int n,int w,int[][] a){
        double v=0;
        int i=0;
        double k;
        while(i<n && w>0){
            if(a[i][1]<=w){
                w-=a[i][1];
                v+=a[i][0];
            }
            else{
                v=v+(((double)a[i][0])/((double)a[i][1]/w));
                w=0;
            }
            i++;
        }
        return v;
    }
    public static void sortbyColumn(int arr[][], int col) {
        // Using built-in sort function Arrays.sort
        // Compare values according to columns
        Arrays.sort(arr, (entry1, entry2) -> {

            // To sort in descending order revert
            // the '>' Operator
            if (entry1[col]/entry1[col+1] < entry2[col]/entry2[col+1])
                return 1;
            else
                return -1;
        });  // End of function call sort().
    }

}

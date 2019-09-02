package prime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleSieve {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(SieveSolve(n));
    }
    public static List SieveSolve(int n)
    {
        List<Integer> prime=new ArrayList<>();
        boolean[] touched=new boolean[n+1];
        prime.add(2);
        for(int i=2;i<=n;i+=2)
            touched[i]=true;
        for(int i=3;i<=Math.sqrt(n);i++)
        {
            if(touched[i]!=true)
            {
                for(int j=i*i;j<n;j+=(i*2))
                {
                    touched[j]=true;
                }
            }
        }
        for(int i=2;i<=n;i++)
        {
            if(touched[i]!=true)
                prime.add(i);
        }
        return prime;
    }
}

package prime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SegmentedSieve {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(sieveSegment(a,b));
    }
    public static List sieveSegment(int a,int b)
    {
        List<Integer> primelist=new ArrayList<>();
       primelist= SimpleSieve.SieveSolve((int)Math.sqrt(b));
       System.out.println(primelist);
       boolean[] touched=new boolean[b-a+1];
       List<Integer> ans=new ArrayList<>();
       for(int i=0;i<primelist.size();i++)
       {
           for(int j=a;j<=b;j++) {
               if (j % primelist.get(i) == 0)
                   touched[j - a] = true;
           }
       }
       for(int i=0;i<touched.length;i++)
       {
           if(touched[i]!=true)
               ans.add(i+a);
       }
       return ans;
    }
}

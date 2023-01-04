//PRINT DECREASING
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        printDecreasing(n);
    }

    public static void printDecreasing(int n){
        
        //step-2 -> base condition/stopping condition(so that nos 1 sew chote nhi print ho)
        if(n==0){
            return;
        }
        
        //my work(to print n)-> step 2
        System.out.println(n);
        
        //faith work(work delegated to other)-> step 3 - to print all nos less than n
        printDecreasing(n-1);
    }
}





//PRINT INCREASING
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        printIncreasing(n);
        
    }

    public static void printIncreasing(int n){
        
        //step1-> stopping condition
        if(n==0){
            return;
        }
        
        //step3 -> faith work
        printIncreasing(n-1);
        
        //step2 -> my work
        System.out.println(n);        
    }
}




//FACTORIAL
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        int ans=factorial(n);
        System.out.println(ans);
    }

    public static int factorial(int n){
        
        //base condition
        if(n==0){
            return 1;
        }
        
        //faith work
        int fac=factorial(n-1);
        
        //my work
        int ans=n*fac;
        return ans;
    }

}

// Expectation : gives answer for n factorial
// Faith: factorial for (n-1) all nos less than n




//POWER LOGARITHMIC
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int x=scn.nextInt();
        int n=scn.nextInt();
        
        int ans=power(x,n);
        System.out.println(ans);
    }

    public static int power(int x, int n){
        
        //base condition
        
        if(n==0){
            return 1;
        }
        
        //faith work
        int xpn=power(x,n/2);
        
        //my work
        
        int ans=xpn*xpn;  //only if n/2 even 
        
        if(n%2!=0){
            ans=ans*x;
        }

        return ans;
    }
}
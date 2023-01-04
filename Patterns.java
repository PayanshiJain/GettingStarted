//PATTERN 1
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n= scn.nextInt();
        int nst=1;
        
        for(int i=1;i<=n;i++)   //for rows
        {
           for(int j=1;j<=nst;j++){      //for printing star
               System.out.print("*	");
           } 
           nst=nst+1;
           System.out.println();
        }

    }
}



//PATTERN 2
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int nst=5;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=nst;j++){
                System.out.print("*	");
            }
            nst=nst-1;
            System.out.println();
        }
    }
}



//PATTERN 3
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        
        int nsp=n-1;
        int nst=1;
        
        //number of rows
        for(int i=1;i<=n;i++){
            
            //first inner loop for spaces
            for(int j=1;j<=nsp;j++){
                System.out.print("	");
            }
            
            //second inner loop for stars
            for(int j=1;j<=nst;j++){
                System.out.print("*	");
            }
            
            //nsp decrease
            nsp=nsp-1;
            //nst increase
            nst=nst+1;
            
            System.out.println();
        }
    }
}




//PATTERN 4
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        
        int nst=5;
        int nsp=n-5;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=nsp;j++){
                System.out.print("	");
            }
            for(int j=1;j<=nst;j++){
                System.out.print("*	");
            }
            nst-=1;
            nsp+=1;
            System.out.println();
        }
    }
}




//PATTERN 5
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        
        int nsp=n/2;
        int nst=1;
        
        //no of rows
        for(int i=1;i<=n;i++){
            
            //for loop for spaces
            for(int j=1;j<=nsp;j++){
                System.out.print("	");
            }
            
            //for stars
            for(int j=1;j<=nst;j++){
                System.out.print("*	");
            }
            
            if(i<=n/2){
                nst+=2;
                nsp-=1;
            }
            else{
                nst-=2;
                nsp+=1;
            }
            System.out.println();
        }
    }
}



//PATTERN 6
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n= scn.nextInt();
        int nst1= n/2+1;
        int nsp= 1;
        int nst2= n/2+1;
        
        for(int i=1; i<=n;i++){
            for(int j=1;j<=nst1;j++){
                System.out.print("*	");
            }
            for(int j=1;j<=nsp;j++){
                System.out.print("	");
            }
            for(int j=1;j<=nst2;j++){
                System.out.print("*	");
            }
            
            if(i<=n/2){
                nst1--;
                nsp+=2;
                nst2--;
            }
            else{
                nst1++;
                nsp-=2;
                nst2++;
            }
            System.out.println();            
        }
    }
}




//PATTERN 7
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n= scn.nextInt();
        int nsp=0;
        int nst=1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=nsp;j++){
                System.out.print("	");
            }
            System.out.println("*	");
            nsp+=1;
        }

    }
}



//PATTERN 8
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int nsp=n-1;
        int nst=0;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=nsp;j++){
                System.out.print("	");
            }
             System.out.println("*	");
             nsp--;
        }
    }
}




//PATTERN 9
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j || i+j==n+1){
                    System.out.print("*	");
                }
                else{
                    System.out.print("	");
                }
            }
            System.out.println();
        }
    }
}



//PATTERN 10

//PATTERN 11
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int nst=1;
        int num=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=nst;j++){
                System.out.print(num +"	");
                num++;
            }
            nst=nst+1;
            System.out.println();
        }

    }
}

// sir pattern 11 and 12 me nst kyu liya?
// kyuki ye similar hai hmare us pattern se or hme stars ki jagah numbers print krne hai to nst abhi bhi number of stars ki jagah number of numbers represent krra hai us specific row ke liye



//PATTERN 12
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n= scn.nextInt();
        int nst=1;
        int a=0;
        int b=1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=nst;j++){
                System.out.print(a+"	");
            
            int c=a+b;
            a=b;
            b=c;
        }
        nst=nst+1;
        System.out.println();
        }
    }
}



//PATTERN 13
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        //write your code here
        int n= scn.nextInt();
        for(int i=0;i<n;i++){
            int val=1;
            for(int j=0;j<=i;j++){
            System.out.print(val+"	");   
            val=(val*(i-j))/(j+1);
            }
            
            System.out.println();
        }
    }
}



//PATTERN 14

//PATTERN 15
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n= scn.nextInt();
        int nst=1;
        int nsp=n/2;
        int oval=1;
        
        
        for(int i=1;i<=n;i++){
            
            int ival=oval;
            for(int j=1;j<=nsp;j++){
                System.out.print("	");
            }
            for(int j=1;j<=nst;j++){
                if(j<=nst/2){
                  System.out.print(ival +"	");
                  ival++;
                }
                else{
                    System.out.print(ival +"	");
                    ival--;
                }
                
            }
           
       
         if(i<=n/2){
                nsp--;
                nst+=2;
                oval++;
            }
            else{
                nsp++;
                nst-=2;
                oval--;
            }
        
            System.out.println();
        }
    }
}



//PATTERN 16

//PATTERN 17
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int nsp=n/2;
        int nst=1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=nsp;j++){
                
            if(i==n/2+1){
                System.out.print("*	");
            }
            else{
                System.out.print("	");
            }
            }
            for(int j=1;j<=nst;j++){
                System.out.print("*	");
            }
            
            if(i<=n/2){
                nst++;
            }
            else{
                nst--;
            }
            
            System.out.println();
            
        }
    }
}


//PATTERN 18

//PATTERN 19

//PATTERN 20

//IS A NO PRIME
import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
  
       // write ur code here
       
       int t= scn.nextInt();
       for(int i=0; i<t; i++){
           int n=scn.nextInt();
           boolean isprime= true;
           for(int j=2; j<n;j++){
               if(n%j==0){
                   isprime= false;
                  break;
               }
               
           }
            if(isprime== true){
                   System.out.println("prime");
               }
               else
               {
                   System.out.println("not prime");
               }
        }
  
   }
  }




//PRINT ALL PRIMES TILL N
import java.util.*;

public class Main {
  public static void main(String[] args) {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int low = scn.nextInt();
    int high = scn.nextInt();

    for (int i = low; i <= high; i++)
    {
      boolean isprime = true;
      for (int j = 2; j <= i/2; j++) {
        if (i % j == 0) {
          isprime = false;
          break;
        }
      }
      if (isprime == true) {
        System.out.println(i);

      }
    }

  }
}





//PRINT FIBONACCI NOS TILL N
import java.util.*;
  
  public class Main{
  
    public static void main(String[] args) {
      // write your code here
      Scanner scn= new Scanner(System.in);
      int n= scn.nextInt();
      
      
      int a=0;
      int b=1;
      for(int i=0;i<n;i++){
          int c= a+b;
          System.out.println(a);
          a=b;
          b=c;
      }
      
      
      
   }
  }



  //COUNT DIGITS IN A NO
import java.util.*;

public class Main {

  public static void main(String[] args) {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int count = 0;
    while (n > 0)
    {
      //Step1- divide n by 10
      int j = n / 10;
      //step2- count increment by 1
      count = count + 1;
      //step3-update n;
      n = j;
    }
    System.out.println(count);
  }
}




//DIGITS OF A NO
import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      // write your code here  
      Scanner scn= new Scanner(System.in);
      int n= scn.nextInt();
      while(n>0)
      {
          //step1-find remainder
          int rem=n%10;
          //step2- now print that remainder
          System.out.println(rem);
          //step3- update the value of n by decreasing the no of digits
          n=n/10;
      }     
     }
    }




//REVERSE A NO
import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
     // write your code here 
     Scanner scn= new Scanner(System.in);
      int n= scn.nextInt();
      while(n>0)
      {
          //step1-find remainder
          int rem=n%10;
          //step2- now print that remainder
          System.out.println(rem);
          //step3- update the value of n by decreasing the no of digits
          n=n/10;
      }     
    }
   }


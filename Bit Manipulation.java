//BIT MANIPULATION FOR BEGINNERS

//BASICS OF BIT MANIPULATION
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    //write your code here
    //set the no
    int mask1= 1<<i;

    //unset
    int mask2= ~(1<<j);

    //toggle
    int mask3= 1<<k;

    //to check on or off
    int mask4= 1<<m;

    int ans1= n|mask1;
    int ans2= n&mask2;
    int ans3= n^mask3;
    int ans4= n&mask4;

    //to print the answers
    System.out.println(ans1);
    System.out.println(ans2);
    System.out.println(ans3);

    System.out.println(ans4==0?"false":"true");
  }

}



//PRINT VALUE OF RSB MASK
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    //write your code here
    int mask= ~n +1;
    int rsb= n&mask;

    System.out.println(Integer.toBinaryString(rsb));
  }

}



//KERNIGHANS ALGORITHM
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here

    int count=0;

    while(n!=0){
      int rsbm= ~(n&(-n));
      count ++;
      n=n&rsbm;
    }
    System.out.println(count);

    //but this brute force approach takes TC= O(32) bcz it checks all the bits
    // int count =0;
    // while(n>0){
    //   if((n&1)==1){
    //     count++;
    //   }
    //   n>>=1;
    // }
    // System.out.println(count);
  }

}
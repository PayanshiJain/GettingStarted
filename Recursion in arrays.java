//DISPLAY ARRAY
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        
        displayArr(arr,0);
    }

    public static void displayArr(int[] arr, int idx){
        
        //base condition
        if(idx==arr.length){
            return ;
        }
        
        //faith work
       System.out.println(arr[idx]); 
       
       //my work
       displayArr(arr,idx+1);        
    }
}





//DISPLAY ARRAY IN REVERSE
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int []arr=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        
        displayArrReverse(arr,0);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        
        //base condition
        if(idx==arr.length){
            return;
        }
        
        //faith
        displayArrReverse(arr,idx+1);
        
        //my work
        System.out.println(arr[idx]);

    }
}
//HASHMAP AND HEAP FOR BEGINNERS


//HIGHEST FREQUENCY CHARACTER
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn= new Scanner(System.in);
        String str=scn.next();  //to take input for string

        HashMap<Character,Integer> map = new HashMap<>();
        //2 var, one to store freq and other for char
        int maxfreq=0;
        char maxFreqChar=' ';

        //traverse the whole string
        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);

            if(map.containsKey(ch)==true){
                int freq= map.get(ch);
                freq+=1;
                map.put(ch, freq);
            }
            else{
                //means character ek hi baar aaya h sirf
                map.put(ch,1);
            }

            if(map.get(ch)>maxfreq){
                maxfreq=map.get(ch);
                maxFreqChar=ch;
            }
        }
        System.out.println(maxFreqChar);

        
    }

}


//DEMO OF HASHMAP FUNCTIONS

// import java.io.*;
// import java.util.*;

// public class Main {

//     public static void main(String[] args) throws Exception {
//         // write your code here
//         HashMap<String,Integer> map= new HashMap<>();

//         //put function
//         map.put("India",333);
//         map.put("INdia",123);
//         map.put("USA",90);
//         map.put("UK",70);

//         System.out.println(map);

//         //containsKey function
//         if(map.containsKey("InDia")==true){
//             System.out.println("Hurray!!");
//         }
//         else{
//             System.out.println("No");
//         }


//         if(map.containsKey("India")==true){
//             System.out.println("Hurray!!");
//         }
//         else{
//             System.out.println("No");
//         }    

//         //remove function
//         map.remove("INdia");
//         map.remove("Pakistan");
//         System.out.println(map);  

//         //get function
//         System.out.println(map.get("India"));
//         System.out.println(map.get("China")); 

//         //getOrDefault function
//         System.out.println(map.getOrDefault("China",5)); 
//         System.out.println(map.getOrDefault("USA",5)); 

//         //size function
//         System.out.println(map.size());

//         //keySet function
//         ArrayList<String>al= new ArrayList<>(map.keySet());  //we are storing all keys present in our hashmap in al
//         System.out.println(al); //al of string type bcz our key is also of string type
//     }

// }




//GET COMMON ELEMENTS-1
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn= new Scanner(System.in);
    int n1=scn.nextInt();
    int a1[]= new int[n1];
    for(int i=0;i<n1;i++){
        a1[i]=scn.nextInt();
    }

    int n2=scn.nextInt();
    int a2[]= new int[n2];
    for(int i=0;i<n2;i++){
        a2[i]=scn.nextInt();
    }

    // HashMap<Integer,Integer> map= new HashMap<>();  //M1 using HashMap
    //to put values of a1 in HM
    // for(int i=0;i<n1;i++){
    //     if(map.containsKey(a1[i])==true){
    //         int freq=map.get(a1[i]);
    //         freq+=1;
    //         map.put(a1[i],freq);
    //     }
    //     else{
    //         map.put(a1[i],1);
    //     }        
    // } 
    // for(int i=0;i<n2;i++){ //to check if a2 elements present in hm or not
    //     if(map.containsKey(a2[i])==true){
    //         System.out.println(a2[i]);
    //         map.remove(a2[i]);
    //     }
    // }

    //NOW USING HASHSET-> METHOD-2
    //create HashSet-> stores only unique values
    HashSet<Integer> set= new HashSet<>();
    //add all unique values of arr a1 in set
    for(int i=0;i<n1;i++){
        set.add(a1[i]);
    }
    //print common values present in a2
    for(int i=0;i<n2;i++){
        if(set.contains(a2[i])==true){
            System.out.println(a2[i]);
            set.remove(a2[i]);
        }
    }

 }

}




//GET COMMON ELEMENTS-2
import java.io.*;

import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
	  //Write your code here
    Scanner scn= new Scanner(System.in);
    int n1=scn.nextInt();
    int a1[]= new int[n1];
    for(int i=0;i<n1;i++){
      a1[i]=scn.nextInt();
    }

    int n2=scn.nextInt();
    int a2[]= new int[n2];
    for(int i=0;i<n2;i++){
      a2[i]=scn.nextInt();
    }    

    HashMap<Integer,Integer> map= new HashMap<>();
    for(int i=0;i<n1;i++){
      if(map.containsKey(a1[i])==true){
        int freq=map.get(a1[i]);
        freq+=1;
        map.put(a1[i],freq);
      }
      else{
        map.put(a1[i],1);
      }
    }
    for(int i=0;i<n2;i++){
      if(map.containsKey(a2[i])==true){
        System.out.println(a2[i]);
        int freq=map.get(a2[i]);
        freq-=1;

        if(freq==0){
          map.remove(a2[i]);
        }
        else{
          map.put(a2[i],freq);
        }
      }
    }
    
  }

}




//LONGEST CONSECUTIVE SEQUENCE OF ELEMENTS
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn= new Scanner(System.in);

    int n=scn.nextInt();
    int a[]= new int[n];

    for(int i=0;i<n;i++){
        a[i]=scn.nextInt();        
    }
    HashMap<Integer,Boolean>map= new HashMap<>();


    //Step-1: consider all elements as a starting point(sp)
    for(int i=0;i<n;i++){
        map.put(a[i],true);
    }
    //Step-2: Discard invalid sp
    for(int i=0;i<n;i++){
        if(map.containsKey(a[i]-1)==true){
            map.put(a[i],false);
        }
    }
    //Step-3: Find longest sequence
    int sp=0;
    int maxLength=0;
    for(int i=0;i<n;i++){
        if(map.get(a[i])==true){
            int curr=a[i];
            int len=1;

            while(map.containsKey(curr+1)==true){
                curr+=1;
                len++;
            }
            if(len>maxLength){
                maxLength=len;
                sp=a[i];
            }
        }
    }
    for(int i=0;i<maxLength;i++){
        System.out.println(sp+i);
    }
 }
}





//SORT K-SORTED ARRAY
import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());

      PriorityQueue<Integer> pq= new PriorityQueue<>();

      // write your code here

      //insert k+1 elements in pq
      for(int i=0;i<=k;i++){
         pq.add(arr[i]);
      }     

      //traverse min pq
      for(int i=k+1;i<n;i++){
         System.out.println(pq.remove());
         pq.add(arr[i]);
      } 
      //to print the ans
      while(pq.size()>0){
         System.out.println(pq.remove());
      }
   }

}

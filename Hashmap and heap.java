//K LARGEST ELEMENTS
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
      //put elements of arr in pq
      for(int i=0;i<k;i++){
          pq.add(arr[i]);
      }
      //traverse pq
      for(int i=k;i<n;i++){
          //check if peek > or <
          if(pq.peek()<arr[i]){
              pq.remove();
              pq.add(arr[i]);
          }
      }
      while(pq.size()>0){
          System.out.println(pq.remove());
      }
      
    }

}
//GRAPHS

//HAS PATH?
import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt){
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for(int i = 0; i < vtces; i++){
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for(int i = 0; i < edges; i++){
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      // write your code here
      //to make a visited array, its size will be equal to the no of vrtcs
      boolean visited[] = new boolean[vtces];
      System.out.println(hasPath(graph, src, dest, visited));
    }

public static boolean hasPath(ArrayList<Edge>[]graph, int src, int dest, boolean []visited){
   if(src==dest){
      return true;
   }
   visited[src]=true;

   for(Edge e: graph[src]){
      int nbr=e.nbr;

      //has path route tabhi dekho if visited arr false h toh
      if(visited[nbr]==false){
         boolean ntod= hasPath(graph, nbr, dest, visited);  //node to dest path
         if(ntod==true){
            return true;
         }
      }
   }
      return false;
      
         
      
   }
}







// //CONSTRUCTION OF ADJACENCY LIST
// import java.io.*;
// import java.util.*;

// public class Main {
//    public static class Edge {   //class
//       int src;
//       int nbr;
//       int wt;

//       public Edge(int src, int nbr, int wt){ //constructor
//          this.src = src;
//          this.nbr = nbr;
//          this.wt = wt;
//       }
//    }
//    public static void main(String[] args) throws Exception {

//       //make an arr
//       ArrayList<Edge>[]graph= new ArrayList[7];
//       //make an arr list correspondig to every arr
//       for(int i=0;i<7;i++){
//          graph[i]= new ArrayList<>();
//       }
//       //now start filling values in arr list
//       graph[0].add(new Edge(0,1,10));
//       graph[1].add(new Edge(1,0,10));

//       graph[1].add(new Edge(1,2,10));
//       graph[2].add(new Edge(2,1,10));

//       graph[0].add(new Edge(0,3,40));
//       graph[3].add(new Edge(3,0,40));

//       graph[3].add(new Edge(3,2,10));
//       graph[2].add(new Edge(2,3,10));

//       graph[3].add(new Edge(3,4,3));
//       graph[4].add(new Edge(4,3,3));

//       graph[4].add(new Edge(4,5,3));
//       graph[5].add(new Edge(5,4,3));

//       graph[5].add(new Edge(5,6,2));
//       graph[6].add(new Edge(6,5,2));

//       graph[4].add(new Edge(4,6,7));
//       graph[6].add(new Edge(6,4,7));

//    //print the data
//    for(int i=0;i<7;i++){
//       System.out.print(i+" -> ");
//       // for(int e=0;e<graph[i].size();e++)){
//          for(Edge e: graph[i]){
//          System.out.print("("+ e.src+" ,"+e.nbr+" ,"+e.wt+" )");
//       }
//       System.out.println();
//    }
//    }
   
// }





//PRINT ALL PATHS
import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      // write all your codes here
      //make a new visited arr of type boolean
      boolean[]visited= new boolean[vtces];

      allPaths(graph,src,dest,visited,src+"");
   }


   public static void allPaths(ArrayList<Edge>[]graph, int src, int dest, boolean[] visited, String psf){  //str path so far
      if(src==dest){
         System.out.println(psf);
         return;
      }
      visited[src]= true;
      //nbr ko call lagao
      for(Edge e: graph[src]){
         int nbr= e.nbr;
         if(visited[nbr]==false){
            allPaths(graph, nbr, dest, visited, psf+nbr);
         }
      }
      visited[src]= false; //jab return kar rhe ho toh false kardo so that we can get all the possible ans
   }


}




//Multisolver - Smallest, Longest, Ceil, Floor, Kthlargest Path
import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   static class Pair implements Comparable<Pair> {
      int wsf;
      String psf;

      Pair(int wsf, String psf){
         this.wsf = wsf;
         this.psf = psf;
      }

      public int compareTo(Pair o){
         return this.wsf - o.wsf;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      int criteria = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      boolean[] visited = new boolean[vtces];
      multisolver(graph, src, dest, visited, criteria, k, src + "", 0);
      
      System.out.println("Smallest Path = " + spath + "@" + spathwt);
      System.out.println("Largest Path = " + lpath + "@" + lpathwt);
      System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
      System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
      System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
   }



   static String spath;
   static Integer spathwt = Integer.MAX_VALUE;
   static String lpath;
   static Integer lpathwt = Integer.MIN_VALUE;
   static String cpath;
   static Integer cpathwt = Integer.MAX_VALUE;
   static String fpath;
   static Integer fpathwt = Integer.MIN_VALUE;
   static PriorityQueue<Pair> pq = new PriorityQueue<>();
   public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
      
      if(src==dest){
         //for smallest path
         if(spathwt>wsf){
            spathwt=wsf;  //spathwt=infinity initially so update it whenever u get a wsf smaller than it
            spath=psf;
         }
         //for longest path
         if(lpathwt<wsf){
            lpathwt=wsf; //lpathwt is initialised to -infinity so when u get wt larger than that then update it
            lpath=psf;
         }
         //for ceil path
         if(wsf>criteria && cpathwt>wsf){
            cpathwt=wsf;
            cpath=psf;
         }
         //for floor path
         if(wsf<criteria && fpathwt<wsf){
            fpathwt=wsf;
            fpath=psf;
         }
         //kth largest path
         if(pq.size()<k){
            pq.add(new Pair(wsf,psf));
         }
         else{
            if(pq.peek().wsf<wsf){
               pq.remove();
               pq.add(new Pair(wsf,psf));
            }
         }
         return;
      }

      //print all paths
      visited[src]=true;
      //call nbr
      for(Edge e: graph[src]){
         int nbr=e.nbr;
         int wt=e.wt;

         if(visited[nbr]==false){
            multisolver(graph, nbr, dest, visited, criteria, k, psf+nbr, wsf+wt);
         }
      }
      visited[src]=false;
   }
   
}






//GET CONNECTED COMPONENTS OF A GRAPH
import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      // write your code here
      ArrayList<ArrayList<Integer>> comps= new ArrayList<>();
      // int src=0; we have to travel all the other graphs too so use a loop for other vtces
      boolean []visited= new boolean[vtces]; 
      for(int i=0;i<vtces;i++){
         if(visited[i]==false){
            ArrayList<Integer>comp= new ArrayList<>();  //new arr list to store comp of new wala graph
            getComp(graph,i,visited,comp);

            comps.add(comp);
            //bahar wali al me add kardo comp ki al  
         }
      }

      System.out.println(comps);
   }

   public static void getComp(ArrayList<Edge>[]graph, int src, boolean[] visited, ArrayList<Integer>comp){
      //same code as hasPath
      visited[src]=true;
      //comp me src ko add karo then uske path ko
      comp.add(src);
      for(Edge e: graph[src]){
         int nbr= e.nbr;
         if(visited[nbr]==false){
            getComp(graph,nbr,visited,comp);
         }
         
      }
   }
}




//HAMILTONIAN PATH & CYCLE
import java.io.*;
import java.util.*;

public class Main {

   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());

      // write all your codes here
      boolean []visited= new boolean[vtces];

      hpc(graph,src,src,visited,src+"",0);
   }

   public static void hpc(ArrayList<Edge>[]graph, int src1, int src2, boolean[]visited,String asf, int vvsf){
      //base case
      if(vvsf==graph.length-1){ //means we've traversed all the vertices once
         //so print the ans
         System.out.print(asf);

         boolean hc=false; //let's assumne that it's not a hc
         for(Edge e:graph[src2]){
            int nbr=e.nbr;
            if(nbr==src1){
               hc=true;
               break;
            }
         }
         if(hc==true){
            System.out.println("*");
         }
         else{
            System.out.println(".");
         }
         return;
      }


      visited[src1]=true;
      for(Edge e:graph[src1]){
         int nbr=e.nbr;
         if(visited[nbr]==false){
            hpc(graph,nbr,src2,visited,asf+nbr,vvsf+1);
         }
      }
      visited[src1]=false;
   }


}




//BREADTH FIRST TRAVERSAL
import java.io.*;
import java.util.*;

public class Main {

   public static class Pair{ //make a class pair
      int vtx; 
      String psf;

      public Pair(int vtx, String psf){  //make a constructor of pair class
         this.vtx=vtx;
         this.psf=psf;
      }
   }

   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      Queue<Pair>q= new ArrayDeque<>();
      boolean visited[]=new boolean[vtces];

      q.add(new Pair(src,src+""));

      while(q.size()>0){
         //remove from queue
         Pair rp= q.remove();  //stors info about vertex and psf
         
         //check if visited or not
         if(visited[rp.vtx]==false){  //if not visited
            //mark visited and print
            visited[rp.vtx]=true;
            System.out.println(rp.vtx+"@"+rp.psf);
         
            //now check nbr and add dunvisited nbr in queue
            for(Edge e:graph[rp.vtx]){
               int nbr=e.nbr;

               if(visited[nbr]==false){
                  q.add(new Pair(nbr,rp.psf+nbr));
               }
            }
         }
         
      }

      // write your code here  
   }
   }
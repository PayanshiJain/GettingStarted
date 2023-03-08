//RECURSION AND BACKTRACKING FOR BEGINNERS


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






//FIRST INDEX
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

        int x=scn.nextInt();
        int ans=firstIndex(arr,0,x);

        System.out.println(ans);
    }

    public static int firstIndex(int[] arr, int idx, int x){
        
        //base condition
        if(idx==arr.length){
            return -1;
        }

        if(x==arr[idx]){
            return idx;
        }

        else{
            return firstIndex(arr,idx+1,x);
        }        
    }
}



//GET SUBSEQUENCE
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        ArrayList<String>ans=gss(str);
        System.out.println(ans);

    }

    public static ArrayList<String> gss(String str) {

        //base condition
        if(str.length()==0){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        
        char ch=str.charAt(0);
        String ros=str.substring(1);

        //faith
        ArrayList<String>rr=gss(ros);

        //my work
        ArrayList<String>myans=new ArrayList<>();

        //1)exclude charAt(0)
        // for (String rstr:rr){
        //     myans.add(rstr);
        // }
        //or insteD of for each loop
        for(int i=0;i<rr.size();i++){
            myans.add(rr.get(i));
        }

        //2)include
        for(int i=0;i<rr.size();i++){
             myans.add(ch+rr.get(i));
        }

        //now final my ans will include charat(0) and exclude and then combined will be the my ans
        return myans;       
    }
}




//GET KPC
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();

        ArrayList<String>ans= getKPC(str);
        System.out.println(ans);

    }

    static String[]arr={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    
    public static ArrayList<String> getKPC(String str) {

        if(str.length()==0){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        
        char ch=str.charAt(0);
        String ros=str.substring(1);
        ArrayList<String>rr=getKPC(ros);
        
        String code=arr[ch-'0'];

        //to make my ans
        ArrayList<String>myAns=new ArrayList<>();

        for(int i=0;i<code.length();i++){
            char c=code.charAt(i);
            for(int j=0;j<rr.size();j++){
                myAns.add(c+rr.get(j));
            }
        }
        return myAns;
    }
}




//GET STAIR PATHS
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        ArrayList<String> ans= getStairPaths(n);
        System.out.println(ans);

    }

    public static ArrayList<String> getStairPaths(int n) {

        //Positive base case
        if(n==0){
            ArrayList<String>base1=new ArrayList<>();
            base1.add("");
            return base1;
        }

        //negative base case
        if(n<0){
            ArrayList<String>base2=new ArrayList<>();
            return base2;
        }

        //faith1 for 1 step
        ArrayList<String>rr1=getStairPaths(n-1);

        //faith 2 for 2 steps
        ArrayList<String>rr2=getStairPaths(n-2);

        //faith 3 for 3 steps
        ArrayList<String>rr3=getStairPaths(n-3);

        //my work
        ArrayList<String>myAns=new ArrayList<>();
        for(int i=0;i<rr1.size();i++){
            myAns.add("1"+rr1.get(i));
        }

        for(int i=0;i<rr2.size();i++){
            myAns.add("2"+rr2.get(i));
        }

        for(int i=0;i<rr3.size();i++){
            myAns.add("3"+rr3.get(i));
        }

        return myAns;        
    }
}




//PRINT SUBSEQUENCE
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        printSS(str,"");

    }

    public static void printSS(String str, String asf) {
        //baser case
        if(str.length()==0){
            System.out.println(asf);
            return;
        }

        char ch=str.charAt(0);
        String ros=str.substring(1);

        //include
        printSS(ros,asf+ch);

        //exclude
        printSS(ros,asf);
    }
}





//PRINT MAZE PATHS
import java.io.*;
import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
            Scanner scn=new Scanner(System.in);
            int n=scn.nextInt();
            int m=scn.nextInt();

            printMazePaths(0,0,n-1,m-1,"");
	    }

	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
	    public static void printMazePaths(int sr, int sc, int dr, int dc, String asf) {
        //negative base case
         if(sr>dr || sc>dc){
            return;
        }

        //positive base case
        if(sr==dr && sc==dc){
            System.out.println(asf);
            return;            
        }
        
        //call for horizontal step
        printMazePaths(sr,sc+1,dr,dc,asf+"h");

        //call for vertical step
        printMazePaths(sr+1,sc,dr,dc,asf+"v");	        
	    }
	}




//PRINT PERMUTATIONS
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        printPermutations(str,"");

    }

    public static void printPermutations(String str, String asf) {

        //base condition
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String ros=str.substring(0,i)+str.substring(i+1);  //only i+1 means from i+1th position till last
            printPermutations(ros,asf+ch);
        }       
    }
}





//PRINT ENCODINGS
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        printEncodings(str,"");
    }

    public static void printEncodings(String str,String asf) {

        //base condition
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        
        //Step-01
        // char ch0=str.charAt(0);
        String ch0=str.substring(0,1);
        
        //Step-02
        String ros=str.substring(1);

        // if(ch0=='0'){
        //     return;
        // }    INCORRECT

        //Step-03
        if(ch0.equals("0")){
            return;
        }
        else{
            printEncodings(ros,asf+(char)(Integer.parseInt(ch0)-1+'a'));
        }

        //Step-04
        if(str.length()>=2){
            //step-05
            String ch01=str.substring(0,2);
            //Step-06
            String ros2=str.substring(2);
            //Step-07
            if(Integer.parseInt(ch01)<=26){
            printEncodings(ros2,asf+(char)(Integer.parseInt(ch01)-1+'a'));
            }
        }
    }
}





//FLOOD FILL
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        
        boolean visited[][]=new boolean[n][m];
        floodfill(arr, 0, 0, "",visited);
    }
    
    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String asf,boolean[][]visited) {

        //Negative Base case
        if(sr<0 || sc<0 || sr>=maze.length || sc>=maze[0].length || maze[sr][sc]==1 || visited[sr][sc]==true){
            return;
        }

        //Positive base case
        if(sr==maze.length-1 && sc==maze[0].length-1){
            System.out.println(asf);
            return;
        }
         
        visited[sr][sc]=true; 
        //call for t
        floodfill(maze, sr-1, sc, asf+"t",visited);
         
        //call for l 
        floodfill(maze, sr, sc-1, asf+"l",visited);

        //call for d
        floodfill(maze, sr+1, sc, asf+"d",visited );

        //call for r
        floodfill(maze, sr, sc+1, asf+"r",visited);

        visited[sr][sc]=false;
    
    }
}






//N QUEENS
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        boolean [][]chess=new boolean[n][n];
        //fn call
        printNQueens(chess,"",0);
        
    }

    public static void printNQueens(boolean[][] chess, String asf, int row) {
        //Base case
        if(row==chess.length){
            System.out.println(asf+".");
            return;
        }

        for(int col=0;col<chess.length;col++){
            if(isSafe(chess,row,col)==true){
                chess[row][col]=true;
                printNQueens(chess,asf+row+"-"+col+", ",row+1);
                chess[row][col]=false;
            }
        }
    }

        public static boolean isSafe(boolean[][] chess, int row, int col){

            //for diagonal d1
            for(int i=row-1,j=col+1; i>=0 && j<chess.length;i--,j++){
                //no brackets after chess.length
                if(chess[i][j]==true){
                    return false;
                }                
            }

            //for diagonal d2
            for(int i=row-1; i>=0; i--){
                if(chess[i][col]==true){
                    return false;
                }
            }

            //for diagonal d3
            for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
                //use && b/w 2 conditions
                if(chess[i][j]==true){
                    return false;
                }
            }

            return true;

        }

}

//STACKS AND QUEUES

//DUPLICATE BRACKETS
import java.io.*;
import java.util.*;

public class Main{
   public static void main(String[]args) throws Exception{
   //write your code
   Scanner scn=new Scanner(System.in);
   String exp=scn.nextLine();
   Stack<Character>st=new Stack<>();

   for(int i=0;i<exp.length();i++){    //loop to traverse the exp
      char ch=exp.charAt(i);  

      if(ch==')'){
         if(st.peek()=='('){
            System.out.println(true);
            return;
         }
         else{
            while(st.peek()!='('){
               st.pop();                 
            }
            st.pop();
         }
      }
      else{
          st.push(ch);
      }
   }
   System.out.println(false);   
   
}
}







// import java.io.*;
// import java.util.*;

// public class Main{
//    public static void main(String[]args) throws Exception{
//       //Syntax
//       Stack<Integer>st =new Stack<>();

//       //push -> st.push(val)
//       st.push(10);
//       st.push(20);
//       st.push(30);
//       st.push(40);
//       st.push(50);

//       //peek
//       System.out.println(st.peek());

//       //size
//       int size=st.size();
//       //size before popping
//       System.out.println("Size of stack before popping :" + size);

//       //to pop all elements
//       while(st.size()>0){
//          System.out.println(st.pop());
//       }

//       size=st.size(); //updating the value of size after popping the element
//       //size after popping
//       System.out.println("Size of stack after popping :" + size);

//       //now if we pop any element then we get error bcz size of stcak is zero as elements have been popped out
//       st.pop();  //gives error bcz size of stack is zero

//    }
// }









//BALANCED BRACKETS
import java.io.*;
import java.util.*;

public class Main{

public static boolean check(Stack<Character>st,char bracket){
   //less opening bracket
   if(st.size()==0){
      return false;
   }
   else if(st.peek()!=bracket){
      return false;
   }
   else{
      st.pop();
      return true;
   }
}

   public static void main(String[]args) throws Exception{
   //write your code
   Scanner scn=new Scanner(System.in);
   String exp=scn.nextLine();
   Stack<Character>st=new Stack<>();

   
   for(int i=0;i<exp.length();i++){
      char ch=exp.charAt(i);
      //opening bracket
      if(ch=='(' || ch=='[' || ch=='{'){
         st.push(ch);
      }

      //closing bracket
      else if(ch==')'){
         boolean ans=check(st,'(');
         if(ans==false){
            System.out.println(false);
            return;
         }
      }

      else if(ch==']'){
         boolean ans=check(st,'[');
         if(ans==false){
            System.out.println(false);
            return;
         }
      }

      else if(ch=='}'){
         boolean ans =check(st,'{');
         if(ans==false){
            System.out.println(false);
            return;
         }
      }
   }

   //less closing brackets
   if(st.size()!=0){
      System.out.println(false);
   }
   else{
      System.out.println(true);
   }
   
   
   }
}   






//STOCK SPAN
import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
   // solve

   int ans[]=new int[arr.length];
   Stack<Integer>st=new Stack<>();
   st.push(0);
   ans[0]=1;

   for(int i=1;i<arr.length;i++){
     while(st.size()>0 && arr[i]>arr[st.peek()]){
       st.pop();
     }
     if(st.size()==0){
       ans[i]=i+1;
     }
     else{
       ans[i]=i-st.peek();
     }
     st.push(i);
   }
   return ans;
 }

}






//SLIDING WINDOW MAXIMUM
import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    // code
   //  Scanner scn=new Scanner(System.in);
   //  int k=scn.nextInt();
    Deque<Integer>dq= new ArrayDeque<>();

    //first k elements
    for(int i=0;i<k;i++){
       while(dq.size()>0 && a[dq.getLast()]<a[i]){   //not dq.peek()
          dq.removeLast();
       }

       dq.addLast(i);
     }

     //Print answer for first k elements
     System.out.println(a[dq.peek()]);

     //now for rest 
     for(int i=k;i<n;i++){
         while(dq.size()>0 && a[dq.getLast()]<a[i]){
            dq.removeLast();
         }
         dq.addLast(i);   

       if(dq.peek()<=i-k){
          dq.removeFirst();
       }

       System.out.println(a[dq.getFirst()]);
     }
      }
}






//INFIX EVALUATION
import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code

    Stack<Integer>st1=new Stack<>();  //operands
    Stack<Character>st2=new Stack<>();  //operator

    for(int i=0;i<exp.length();i++){
        char ch=exp.charAt(i);

        //if character is operand
        if(ch>='0'&& ch<='9'){
            st1.push(ch-'0');
        }
        else if(ch=='('){
            st2.push(ch);
        }
        else if(ch=='+'|| ch=='-'|| ch=='*'|| ch=='/'){
            while(st2.size()>0 && precedence(st2.peek())>=precedence(ch)){
                char operator=st2.pop();
                int op2=st1.pop();
                int op1=st1.pop();

                int result=solve(op1,op2,operator);
                st1.push(result);
            }
            st2.push(ch);
        }
        else if(ch==')'){
            while(st2.peek()!='('){
                char operator=st2.pop();
                int op2=st1.pop();
                int op1=st1.pop();

                int result=solve(op1,op2,operator);
                st1.push(result);
            }
            st2.pop();
        }
        else{
            //do nothing
        }
    }

    while(st2.size()!=0){
        char operator=st2.pop();
        int op2=st1.pop();
        int op1=st1.pop();

        int result= solve(op1,op2,operator);
        st1.push(result);
    }
    System.out.println(st1.peek());
 }

 public static int solve(int op1,int op2,char operator){
     if(operator=='+'){
         return op1+op2;
     }
     else if(operator=='-'){
         return op1-op2;
     }
     else if(operator=='*'){
         return op1*op2;
     }
     else{
         return op1/op2;
     }
 }

 public static int precedence(char ch){
     if(ch=='+' || ch=='-'){
         return 1;
     }
     else if(ch=='*' || ch=='/'){
         return 2;
     }
     else{
         return 0;
     }
 }
}






//NORMAL STACK
import java.io.*;
import java.util.*;

public class Main {

  public static class CustomStack {
    int[] data;
    int tos;

    public CustomStack(int cap) {
      data = new int[cap];
      tos = -1;
    }

    int size() {
      // write ur code here
      return tos+1;
    }

    void display() {
      // write ur code here
      for(int i=tos;i>=0;i--){
        System.out.print(data[i]+" ");
      }
      System.out.println();
    }

    void push(int val) {
      // write ur code here

      // if(data.length>tos){
      //   tos++;
      //   data[tos]=val;
      // }
      // else{
      //   System.out.println("Stack overflow");
      // return;
      // }     //this is giving runtime error

      if(data.length-1==tos){
        System.out.println("Stack overflow");
        return;
      }
      tos++;
      data[tos]=val;
      

    }

    int pop() {
      // write ur code here
      if(tos==-1){
        System.out.println("Stack underflow");
        return -1;
      }
      int rv=data[tos];  //rv is the element which was popped out
      tos--;

      return rv;
    }

    int top() {
       // write ur code here
       if(tos==-1){
         System.out.println("Stack underflow");
         return -1;
       }
       return data[tos];

    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomStack st = new CustomStack(n);

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      } else if(str.startsWith("display")){
        st.display();
      }
      str = br.readLine();
    }
  }
}







//DYNAMIC STACK
import java.io.*;
import java.util.*;

public class Main {

  public static class CustomStack {
    int[] data;
    int tos;

    public CustomStack(int cap) {
      data = new int[cap];
      tos = -1;
    }

    int size() {
      return tos + 1;
    }

    void display() {
      for (int i = tos; i >= 0; i--) {
        System.out.print(data[i] + " ");
      }
      System.out.println();
    }

    // change the code of this function according to question
    void push(int val) {
      if (tos == data.length - 1) {   //if size of array full
        // System.out.println("Stack overflow");
        int oa[]= new int[2*data.length];  //double the size of array to accomodate new elements 
        //put all old array elements into new one of double size
        for(int i=0;i<data.length;i++){
          oa[i]=data[i];
        }       
        data=oa;  //data will point to new array of double size
      } 
        tos++;
        data[tos] = val;
      
    }

    int pop() {
      if (tos == -1) {
        System.out.println("Stack underflow");
        return -1;
      } else {
        int val = data[tos];
        tos--;
        return val;
      }
    }

    int top() {
      if (tos == -1) {
        System.out.println("Stack underflow");
        return -1;
      } else {
        return data[tos];
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomStack st = new CustomStack(n);

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("display")) {
        st.display();
      }
      str = br.readLine();
    }
  }
}







//NORMAL QUEUE
import java.io.*;
import java.util.*;

public class Main {

  public static class CustomQueue {
    int[] data;
    int front;
    int size;

    public CustomQueue(int cap) {
      data = new int[cap];
      front = 0;
      size = 0;
    }

    int size() {
      // write ur code here 
      return size;
    }

    void display() {
      // write ur code here
      for(int i=0;i<size;i++){
        System.out.print(data[(front+i)%data.length]+" ");
      }
      System.out.println();
    }

    void add(int val) {
      // write ur code here
      if(data.length==size){
        System.out.println("Queue overflow");
        return;
      }
      //find rear
      int rear=(front+size)%data.length;
      
      data[rear]=val;
      size++;
    }

    int remove() {
      // write ur code here
      if(size==0){
        System.out.println("Queue underflow");
        return -1;
      }

      int rv=data[front];
      //if front reaches out of index so to bring front in range use modulus
      front=(front+1)%data.length;
      size--;
      return rv;
            
    }

    int peek() {
       // write ur code here
       if(size==0){
         System.out.println("Queue underflow");
         return -1;
       }
       return data[front];
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomQueue qu = new CustomQueue(n);

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("add")){
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if(str.startsWith("remove")){
        int val = qu.remove();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("peek")){
        int val = qu.peek();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(qu.size());
      } else if(str.startsWith("display")){
        qu.display();
      }
      str = br.readLine();
    }
  }
}
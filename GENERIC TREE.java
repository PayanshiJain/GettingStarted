//GENERIC TREE FOR BEGINNERS

//SIZE OF GENERIC TREE
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node){
    // write your code here
    int sz=0;
    //faith
    for(Node child:node.children){
      sz+=size(child);
    }
    //my work
    return sz+1;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    int sz = size(root);
    System.out.println(sz);
    // display(root);
  }

}




//CODE TO CONSTRUCT AND DISPLAY A GENERIC TREE
// import java.io.*;
// import java.util.*;

// public class Main {
//   public static class Node{
//     int data;
//     ArrayList<Node> children;

//     Node(int data){
//       this.data=data;
//       children=new ArrayList<>();
//     }
//   }
//   public static void display(Node node){
//     String str=node.data+" -> ";
//     for(Node child:node.children){
//       str+=child.data+", ";
//     }
//     str+=" . ";

//     System.out.println(str);
//     for(Node child:node.children){
//       display(child);
//     }
//     //or this for loop can also be written as
//     // for(int i=0;i<node.children.size();i++){
//     //   Node child=node.children.get(i);
//     //   display(child);
//     // }
//   }

//   public static Node construct(int []arr){
//     Stack<Node>st=new Stack<>();
//     Node root=new Node(arr[0]);
//     st.push(root);

//     for(int i=1;i<arr.length;i++){
//       if(arr[i]==-1){
//         st.pop();
//       }
//       else{
//         Node nn=new Node(arr[i]);
//         st.peek().children.add(nn);
//         st.push(nn);
//       }
//     }
//     return root;
//   }

//   public static void main(String[]args){
//     int arr[]={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
//     Node root=construct(arr);
//     display(root);
//   }


// }



//HEIGHT OF A GENERIC TREE
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    // write your code here
    int ht=-1;
    //faith
    for(Node child: node.children){
      ht=Math.max(ht,height(child));
    }
    //my work
    return ht+1;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    int h = height(root);
    System.out.println(h);
    // display(root);
  }

}




//GENERIC TREE- TRAVERSALS(PRE,POST ORDER)
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node){
    // write your code here
    System.out.println("Node Pre "+ node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre "+ node.data + "--"+ child.data);
      traversals(child);
      System.out.println("Edge Post "+ node.data+ "--"+ child.data);
    }
    System.out.println("Node Post "+ node.data);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    traversals(root);
  }

}




//LEVEL ORDER OF GENERIC TREE
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }

  public static void levelOrder(Node node){
    // write your code here
    //create a new queue
    Queue<Node>q= new ArrayDeque<>();
    //add root to the q
    q.add(node);
    //run loop until queue is not empty
    while(q.size()>0){
      //remove element/node
      Node nn=q.remove();
      //print that in a single line
      System.out.print(nn.data+" ");
      //adding all children of removed data into q
      for(Node child:nn.children){
        q.add(child);
      }
    }
    System.out.print(".");
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    levelOrder(root);
  }

}



//LEVEL ORDER(LINEWISE) GT
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }

  public static void levelOrderLinewise(Node node){
    // write your code here
    //create a queue
    Queue<Node>q=new ArrayDeque<>();
    //add root to the queue
    q.add(node);
    //run a loop until queue is not empty
    while(q.size()>0){
      int sz=q.size();
      while(sz-->0){
        Node nn=q.remove();
        System.out.print(nn.data+" ");

        //adding children
        for(Node child:nn.children){
          q.add(child);
        }
        }
      System.out.println();

      }      
    }  

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    levelOrderLinewise(root);
  }

}



//LEVEL ORDER LINEWISE ZIG-ZAG
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }

  public static void levelOrderLinewiseZZ(Node node){
    // write your code here
    Stack<Node>c1= new Stack<>();
    Stack<Node>c2= new Stack<>();

    c1.push(node);

    int level=0;

    while(c1.size()>0){
      node=c1.pop();
      System.out.print(node.data+" ");

      //if level is even, traverse from L to R
      if(level%2==0){
        for(int i=0;i<node.children.size();i++){
          Node child=node.children.get(i);
          c2.push(child);
        }
      }
      else{
        for(int i=node.children.size()-1;i>=0;i--){
          Node child=node.children.get(i);
          c2.push(child);
        }
      }

      if(c1.size()==0){
        c1=c2;
        c2=new Stack<>();
        level++;
        System.out.println();
      }
    }
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    levelOrderLinewiseZZ(root);
  }

}




//MIRROR A GENERIC TREE
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }

  public static void levelOrderLinewiseZZ(Node node){
    Stack<Node> stack = new Stack<>();
    stack.add(node);

    Stack<Node> cstack = new Stack<>();
    int level = 0;

    while(stack.size() > 0){
      node = stack.pop();
      System.out.print(node.data + " ");

      if(level % 2 == 0){
        for(int i = 0; i < node.children.size(); i++){
          Node child = node.children.get(i);
          cstack.push(child);
        }
      } else {
        for(int i = node.children.size() - 1; i >= 0; i--){
          Node child = node.children.get(i);
          cstack.push(child);
        }
      }

      if(stack.size() == 0){
        stack = cstack;
        cstack = new Stack<>();
        level++;
        System.out.println();
      }
    }
  }

  public static void mirror(Node node){
    // write your code here
    
    //faith
    for(Node child: node.children){
      mirror(child);
    }

    //my work --> to reverse the array list
    int left=0;
    int right=node.children.size()-1;

    while(left<right){
      Node ln=node.children.get(left); //to get the value of left node
      Node rn=node.children.get(right);  //to get the value of right node

      node.children.set(left,rn);
      node.children.set(right,ln);

      left++;
      right--;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    display(root);
    mirror(root);
    display(root);
  }

}




//REMOVE LEAVES IN GENERIC TREE
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node) {
    System.out.println("Node Pre " + node.data);

    for (Node child : node.children) {
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }

  public static void levelOrderLinewiseZZ(Node node) {
    Stack<Node> stack = new Stack<>();
    stack.add(node);

    Stack<Node> cstack = new Stack<>();
    int level = 0;

    while (stack.size() > 0) {
      node = stack.pop();
      System.out.print(node.data + " ");

      if (level % 2 == 0) {
        for (int i = 0; i < node.children.size(); i++) {
          Node child = node.children.get(i);
          cstack.push(child);
        }
      } else {
        for (int i = node.children.size() - 1; i >= 0; i--) {
          Node child = node.children.get(i);
          cstack.push(child);
        }
      }

      if (stack.size() == 0) {
        stack = cstack;
        cstack = new Stack<>();
        level++;
        System.out.println();
      }
    }
  }

  public static void mirror(Node node) {
    for (Node child : node.children) {
      mirror(child);
    }
    Collections.reverse(node.children);
  }

  public static void removeLeaves(Node node) {
    // write your code here

    //4 : remove leaf nodes first and then call children
    for(int i=0;i<node.children.size();i++){
      Node child=node.children.get(i);
      if(child.children.size()==0){
        node.children.remove(child);
        i--;
      }
    }

       //2--->if use normal for loop to modify then we get wrong ans 
       //3--> so we use i-- to rectify the problem but still we get o/p as 10 only
       //4--> we are working in post order isliye only 10 so pehle leaf nodes remove kardo and then call children


       for(Node child: node.children){
        removeLeaves(child);
       }

      //1--->gives error concurrent modification exception 
    // for(Node child: node.children){
    //   removeLeaves(child);
    // }
    // for(Node child:node.children){
    //   if(child.children.size()==0){
    //     node.children.remove(child);
    //   }
    // }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    removeLeaves(root);
    display(root);
  }

}




//FIND IN GENERIC TREE
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static boolean find(Node node, int data) {
    // write your code here
    if(node.data==data){
      return true;
    }
    for(Node child: node.children){
      boolean ans=find(child,data);

      if(ans==true){
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    boolean flag = find(root, data);
    System.out.println(flag);
    // display(root);
  }

}



//NODE TO ROOT PATH IN GENERIC TREE
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

 public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    // write your code here
    if(node.data==data){
      ArrayList<Integer>base=new ArrayList<>(); //mke new arr list
      base.add(data);  //fill data in arr list
      return base;
    }
    //if not found in root node then explore children
    for(Node child: node.children){
      ArrayList<Integer> result= nodeToRootPath(child,data);
      //to chrck if ans mila ki nhi
      if(result.size()>0){
        result.add(node.data);
        return result;
      }
    }
    //if data match nhi kiya then return blank arr list
    return new ArrayList<>();
 }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    ArrayList<Integer> path = nodeToRootPath(root, data);
    System.out.println(path);
    // display(root);
  }

}




//LOWEST COMMON ANCESTOR (GT)
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    if (node.data == data) {
      ArrayList<Integer> path = new ArrayList<>();
      path.add(node.data);
      return path;
    }

    for (Node child : node.children) {
      ArrayList<Integer> ptc = nodeToRootPath(child, data);
      if (ptc.size() > 0) {
        ptc.add(node.data);
        return ptc;
      }
    }

    return new ArrayList<>();
  }

  public static int lca(Node node, int d1, int d2) {
    // write your code here
    //2 array lists which will bring node to root path of both data
    ArrayList<Integer>a1= nodeToRootPath(node,d1);
    ArrayList<Integer>a2= nodeToRootPath(node,d2);

    int i=a1.size()-1;
    int j=a2.size()-1;

    while(i>=0 && j>=0 && a1.get(i)==a2.get(j)){
      i--;
      j--;
    }
    //if aisa nhi hua then
    return a1.get(i+1);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int d1 = Integer.parseInt(br.readLine());
    int d2 = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    int lca = lca(root, d1, d2);
    System.out.println(lca);
    // display(root);
  }

}



//DISTANCE B/W 2 NODES IN A GT
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    if (node.data == data) {
      ArrayList<Integer> path = new ArrayList<>();
      path.add(node.data);
      return path;
    }

    for (Node child : node.children) {
      ArrayList<Integer> ptc = nodeToRootPath(child, data);
      if (ptc.size() > 0) {
        ptc.add(node.data);
        return ptc;
      }
    }

    return new ArrayList<>();
  }

  public static int lca(Node node, int d1, int d2) {
    ArrayList<Integer> p1 = nodeToRootPath(node, d1);
    ArrayList<Integer> p2 = nodeToRootPath(node, d2);

    int i = p1.size() - 1;
    int j = p2.size() - 1;

    while(i >= 0 && j >= 0 && p1.get(i) == p2.get(j)){
      i--;
      j--;
    }

    return p1.get(i + 1);
  }

  public static int distanceBetweenNodes(Node node, int d1, int d2){
    // write your code here
    ArrayList<Integer>a1= nodeToRootPath(node, d1);
    ArrayList<Integer>a2= nodeToRootPath(node, d2);

    int i=a1.size()-1;
    int j=a2.size()-1;

    while(i>=0 && j>=0 && a1.get(i)==a2.get(j)){
      i--;
      j--;
    }
    i++;
    j++;
    return i + j;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int d1 = Integer.parseInt(br.readLine());
    int d2 = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    int dist = distanceBetweenNodes(root, d1, d2);
    System.out.println(dist);
    // display(root);
  }

}




//ARE TREES SIMILAR IN SHAPE
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static boolean areSimilar(Node n1, Node n2) {
    // write your code here
    if(n1.children.size()!=n2.children.size()){
      return false;
    }
    //if = then explore children
    for(int i=0;i<n1.children.size();i++){
      Node c1= n1.children.get(i);
      Node c2= n2.children.get(i);

      boolean ans= areSimilar(c1,c2);
      if(ans==false){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n1 = Integer.parseInt(br.readLine());
    int[] arr1 = new int[n1];
    String[] values1 = br.readLine().split(" ");
    for (int i = 0; i < n1; i++) {
      arr1[i] = Integer.parseInt(values1[i]);
    }
    Node root1 = construct(arr1);

    int n2 = Integer.parseInt(br.readLine());
    int[] arr2 = new int[n2];
    String[] values2 = br.readLine().split(" ");
    for (int i = 0; i < n2; i++) {
      arr2[i] = Integer.parseInt(values2[i]);
    }
    Node root2 = construct(arr2);

    boolean similar = areSimilar(root1, root2);
    System.out.println(similar);
  }

}





//ARE TREES MIRROR IN SHAPE
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static boolean areMirror(Node n1, Node n2) {
    // write your code here
    if(n1.children.size()!=n2.children.size()){
      return false;
    }
    for(int i=0;i<n1.children.size();i++){
      Node c1= n1.children.get(i);
      Node c2= n2.children.get(n2.children.size()-1-i);

      boolean ans= areMirror(c1,c2);
      if(ans==false){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n1 = Integer.parseInt(br.readLine());
    int[] arr1 = new int[n1];
    String[] values1 = br.readLine().split(" ");
    for (int i = 0; i < n1; i++) {
      arr1[i] = Integer.parseInt(values1[i]);
    }
    Node root1 = construct(arr1);

    int n2 = Integer.parseInt(br.readLine());
    int[] arr2 = new int[n2];
    String[] values2 = br.readLine().split(" ");
    for (int i = 0; i < n2; i++) {
      arr2[i] = Integer.parseInt(values2[i]);
    }
    Node root2 = construct(arr2);

    boolean mirror = areMirror(root1, root2);
    System.out.println(mirror);
  }

}




//PREDECESSOR AND SUCCESSOR OF AN ELEMENT
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  static int state;
  static Node predecessor;
  static Node successor;
  public static void predecessorAndSuccessor(Node node, int data) {
    // write your code here

    if(state==0){
        if(node.data!=data){
            predecessor=node; //data type of prec is a node so prec = node and not node.data
        }
        else{ //state=0 and node.data=data means 130 as per our dry run
            state=1;
        }
    }
    else if(state==1){
        successor=node;
        state=2;
    }
    for(Node child:node.children){
        predecessorAndSuccessor(child,data);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    predecessor = null;
    successor = null;
    predecessorAndSuccessor(root, data);
    if(predecessor == null){
      System.out.println("Predecessor = Not found");
    } else {
      System.out.println("Predecessor = " + predecessor.data);
    }

    if(successor == null){
      System.out.println("Successor = Not found");
    } else {
      System.out.println("Successor = " + successor.data);
    }
  }

}




//CEIL nd FLOOR IN GENERIC TREE
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  
  static int ceil;
  static int floor;
  public static void ceilAndFloor(Node node, int data) {
    // Write your code here
    if(node.data<data && floor<node.data){
      floor=node.data;
    }
    if(node.data>data && ceil>node.data){
      ceil=node.data;
    }
    for(Node child: node.children){
      ceilAndFloor(child,data);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    ceil = Integer.MAX_VALUE;
    floor = Integer.MIN_VALUE;
    ceilAndFloor(root, data);
    System.out.println("CEIL = " + ceil);
    System.out.println("FLOOR = " + floor);
  }

}




//Kth LARGEST ELEMENT IN TREE
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  
  static int ceil;
  static int floor;
  public static void ceilAndFloor(Node node, int data) {
    if(node.data > data){
      if(node.data < ceil){
        ceil = node.data;
      }
    }

    if(node.data < data){
      if(node.data > floor){
        floor = node.data;
      }
    }

    for (Node child : node.children) {
      ceilAndFloor(child, data);
    }
  }

  public static int kthLargest(Node node, int k){
    // write your code here

    int data= Integer.MAX_VALUE;  //initialise data with +infinity
    floor=Integer.MIN_VALUE;

    for(int i=0;i<k;i++){
        ceilAndFloor(node,data);
        data=floor;
        floor=Integer.MIN_VALUE;
    }
    return data;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    int kthLargest = kthLargest(root, k);
    System.out.println(kthLargest);
  }

}



//DIAMETER OF GENERIC TREE
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

   //own code
  static int diameter;
  public static int height(Node node){

    int maxH=-1;
    int secMaxH=-1;

    for(Node child:node.children){
      int ch=height(child);

      if(ch>maxH){
        secMaxH=maxH;
        maxH=ch;
      }
      else if(ch>secMaxH){
        secMaxH=ch;
      }
    }

    diameter= Math.max(diameter, maxH+secMaxH+2);

    return maxH+1;
    
  }

  

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    // write your code here

    height(root);

    System.out.print(diameter);
  }

}

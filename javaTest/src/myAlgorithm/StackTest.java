package myAlgorithm;

import java.util.Stack;

public class StackTest {
    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push((node));
}

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int temp = stack1.peek();
                stack2.push(temp);
                stack1.pop();
            }
        }
        int node = stack2.peek();
        stack2.pop();
        return node;
    }

   /* //用两个队列实现栈
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    //入栈
    public void  push(int node){
        if(!queue1.isEmpty()){
            queue1.offer(node);
        }else{
            queue2.offer(node);
        }
    }
    //弹出并删除元素,将元素从一个队列放入另一个队列，直到最后一个元素时弹出
    public int pop(){
        if(queue1.isEmpty() && queue2.isEmpty()){
            System.out.println("队列为空");
        }
        if(!queue1.isEmpty() && queue2.isEmpty()){
            while(queue1.size()>1){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }

        if(!queue2.isEmpty() && queue1.isEmpty()){
            while(queue2.size()>1){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
        return 0;
    }*/

   // 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
   //注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
        Stack<Integer> stackTotal = new Stack<Integer>();
        Stack<Integer> stackMin = new Stack<Integer>();
       public void push1(int node) {
           stackTotal.push(node);
           if(stackMin.isEmpty()){
               stackMin.push(node);
           }else if(node <= stackMin.peek()){
               stackMin.push(node);
           }else{
               stackMin.push(stackMin.peek());
           }
       }

        public void pop1() {
            stackTotal.pop();
            stackMin.pop();
        }

        public int top1() {
           return stackTotal.peek();
        }

        public int min1() {
            return stackMin.peek();
        }
//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
// 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
// （注意：这两个序列的长度是相等的）

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0 || pushA.length != popA.length){
            return false;
        }

        Stack<Integer> tempStack = new Stack<>();
        for (int i = 0,j=0; i <popA.length; i++) {
            tempStack.push(pushA[i]);
            while(j<pushA.length && popA[j] == tempStack.peek()){
                tempStack.pop();
                j++;
            }
        }
        return tempStack.isEmpty();
    }



    public static void main(String[] args) {
        StackTest st = new StackTest();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }

    /**
     * @author wl
     * @date 2020-06-30 09:22
     *以下是每日一题
     */
    //用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
    // (若队列中没有元素，deleteHead 操作返回 -1 )
   /* public CQueue() {

    }*/
    Stack<Integer> myStack1 = new Stack<>();
    Stack<Integer> myStack2 = new Stack<>();
    public void appendTail(int value) {
            myStack1.push(value);
    }

    public int deleteHead() {
        while(myStack2.isEmpty()){
            while(!myStack1.empty()){
                myStack2.push(myStack1.pop());
            }
        }
        if(myStack2.isEmpty()){
            return -1;
        }else{
            int node = myStack2.pop();
            return node;
        }

    }
}

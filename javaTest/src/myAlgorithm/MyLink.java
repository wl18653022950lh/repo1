package myAlgorithm;

import java.util.*;

public class MyLink {
    //    //实现链表反转
//    //思路：压栈弹栈
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null)
            return list;
        ListNode head = listNode;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            list.add(temp.val);
        }
        return list;
    }

    //实现链表反转
    public static ListNode reverseList(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return null;
        }
        //定义一个带头节点的
        ListNode resultList = new ListNode(-1);
        //循环节点
        ListNode p = listNode;
        while (p != null) {
            //保存插入点之后的数据
            ListNode next = p.next;
            p.next = resultList.next;//每次都往头插
            resultList.next = p;
            p = next;
        }
        return resultList.next;

    }


    //输入一个链表，输出该链表中倒数第k个结点。
    //思路：快慢指针,快指针先走k步，然后快慢指针一起走，当快指针为null时，慢指针刚好到达倒数第k个
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //输入一个链表，反转链表后，输出新链表的表头。链表反转
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;//反转
            pre = head;
            head = next;
        }
        return pre;
    }

    //合成链表： 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
    //非递归
    public static ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newlist = new ListNode(0);
        ListNode newhead = newlist;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                newhead.next = list1;
                list1 = list1.next;
            } else {
                newhead.next = list2;
                list2 = list2.next;
            }
            newhead = newhead.next;

        }
        if (list1 == null) {
            newhead.next = list2;
        }
        if (list2 == null) {
            newhead.next = list1;
        }
        return newlist.next;
    }

    //合并两个单链表 递归
    public static ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode newhead = null;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                newhead = list2;
                newhead.next = Merge2(list1, list2.next);
            } else {
                newhead = list1;
                newhead.next = Merge2(list1.next, list2);
            }
        }
        return newhead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode((3));
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        System.out.println(removeDuplicateNodes(head));
       /* ListNode list1 = new ListNode(1);
        list1.next= new ListNode(3);
        list1.next.next= new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next= new ListNode(4);
        list2.next.next= new ListNode(6);
        System.out.println(Merge1(list1,list2));*/
    }

    //输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
    // 请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
    public RandomListNode Clone1(RandomListNode pHead) {
        //思路：用HashMap来保存新旧链表节点的对应关系，遍历旧链表，给新链表赋next与random指针
        if(pHead == null){
            return pHead;
        }
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode oldNode = pHead;
        RandomListNode newNode = pHead;
        while(oldNode != null){
            map.put(oldNode,new RandomListNode(oldNode.label));//{(p1,p1'),(p2,p2')....}
            oldNode = oldNode.next;
        }
        while(newNode != null){
            if(newNode.next != null){
                map.get(newNode).next = map.get(newNode.next);
            }else{
                map.get(newNode).next = null;
            }
            map.get(newNode).random = map.get(newNode.random);
            newNode = newNode.next;
        }
        return map.get(pHead);

    }

    public RandomListNode Clone2(RandomListNode pHead) {
        //思路：复制每个节点插入到该节点的后面，然后再拆分
        if(pHead == null){
            return pHead;
        }
        RandomListNode currentNode = pHead;
        //复制各节点插入各节点后面(1->1'-<2-<2'-<3-<3'......)
        while(currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }
        //重新遍历链表，复制老结点的随机指针给新结点，如1'.random = 1.random.next;
        currentNode = pHead;
        while(currentNode != null){
            currentNode.next.random = currentNode.random == null? null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //拆分链表，将新链表拆出来
        currentNode = pHead;
        RandomListNode newHead = pHead.next;
        while(currentNode != null){
            RandomListNode cloneNodes = currentNode.next;
            currentNode.next = cloneNodes.next;
            cloneNodes.next = cloneNodes.next==null? null:cloneNodes.next.next;
            currentNode = currentNode.next;
        }
        return newHead;
    }

    //输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
            if(p1 != p2){
                if(p1 == null) {
                    p1 = pHead2;
                }
                if(p2 == null){
                    p2 = pHead1;
                }
            }
        }
        return p1;
    }

    //给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
    public ListNode EntryNodeOfLoop(ListNode pHead){
        //方法一：
        if(pHead == null){
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while(slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = pHead;
                while(fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }

    //方法二：
    public ListNode EntryNodeOfLoop2(ListNode pHead){
        if(pHead == null){
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode head = pHead;
        while(head != null){
            if(set.contains(head)){
               return head;
            }else{
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode deleteDuplication(ListNode pHead){
        //方法一：先遍历再删除
        if(pHead == null ){
            return null;
        }
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        HashSet<Integer> set = new HashSet<>();
        while(cur != null){
            if(pre.val == cur.val){
                set.add(cur.val);
            }
            pre = cur;
            cur = cur.next;
        }
        //删除头结点
        while(pHead != null && set.contains(pHead.val)){
            pHead = pHead.next;
        }
        if(pHead == null){
            return null;
        }
        //删除中间节点
        pre = pHead;
        cur = pHead.next;
        while(cur != null){
            if(set.contains(cur.val)){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }

    /*public static ListNode deleteDuplication1(ListNode pHead){
        //方法二：边遍历同时删除
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = pHead;
        ListNode cur = pHead;
        while(cur != null){
            if(cur.next != null && cur.next.val == cur.val){
                // 相同节点一直找
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }*/

    /**
    * @author wl
    * @date 2020-06-26 09:50
    *以下是leetcode每日一题
    */
    //编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
    public static ListNode removeDuplicateNodes(ListNode head) {
        if(head == null){
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode cur= head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        while(cur != null){
            if(!set.contains(cur.val)){
                set.add(cur.val);
                pre = cur;
            }else{
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return head;
    }
}

class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}


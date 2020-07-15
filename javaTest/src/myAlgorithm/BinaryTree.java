package myAlgorithm;


import sun.awt.datatransfer.DataTransferer;

import java.util.*;

public class BinaryTree {

    public static void main(String[] args) {
        /*BinaryTree bt = new BinaryTree();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode node = bt.reConstructBinaryTree(pre, in);
        printTree(node);*/
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(7);
        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(8);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;
        /*Mirror(root1);*/
      /*  System.out.println(PrintFromTopToBottom(root1));*/
        BinaryTree bt = new BinaryTree();
        System.out.println(bt.KthNode(root1,1));
      /*  int[] arrays = {5,7,6,9,11,10,8};
        System.out.println(VerifySquenceOfBST(arrays));*/
        /*System.out.println(Convert(root1));*/
    }
    /*输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。*/
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        //思路：前序遍历第一个为根节点，从中序中找出根节点，就能知道左子树，右子树，递归实现
        if(pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for(int i=0;i<in.length;i++){
            if(pre[0] == in[i]){
                //知识点：Arrays.copyOfRange(pre,1,i+1)包括下标，不包括上标
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }

    //输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        boolean result = false;
        if(root1.val == root2.val) {
            result = HasRoot1ContainsRoot2(root1, root2);
        }
        if(result == false){
            result = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return result;
    }

    public boolean HasRoot1ContainsRoot2(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return  HasRoot1ContainsRoot2(root1.left, root2.left) && HasRoot1ContainsRoot2(root1.right,root2.right);
    }

    public static void printTree(TreeNode root){
        if(root != null){
            printTree(root.left);
            System.out.println(root.val+"");
            printTree(root.right);
        }
    }


    //操作给定的二叉树，将其变换为源二叉树的镜像。
    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        //递归
        TreeNode temp =  root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null){
            Mirror(root.left);
        }
        if(root.right != null){
            Mirror(root.right);
        }
        /*//非递归方式
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root1, temp;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                root1 = queue.poll();
                temp = root1.left;
                root1.left = root1.right;
                root1.right = temp;
                if (root1.left != null) queue.offer(root1.left);
                if (root1.right != null) queue.offer(root1.right);
            }
        }*/
    }

    //从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //层次遍历，利用队列先进先出
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new  LinkedList();
        //将第一个元素加进队列
        queue.offer(root);
        while(!queue.isEmpty()){
            //出队列，将值存入list
            TreeNode temp = queue.poll();
            list.add(temp.val);
            //判断有无左右子树
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
        return list;
    }

    //输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    // 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
    public static boolean VerifySquenceOfBST(int[] sequence) {
        //知识点：二叉搜索树特征，根节点左边都比他小，右边都比他大
        if(sequence.length == 0 || sequence== null){
            return false;
        }
        int i;
        int len = sequence.length;
        //找到第一个比根节点大的位置
        for (i = 0; i <len-1 ; i++) {
            if(sequence[i]>sequence[len-1]){
                break;
            }
        }
        boolean res = true;
        //判断i的左右两边，递归
        for(int j = i;j<len-1;j++){
            //如果右边有比根节点小的，肯定不是
            if(sequence[j+1]<sequence[len-1]){
                return false;
            }else if(i>0 && i<len){
                //左右用递归
                res = VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,i)) && VerifySquenceOfBST(Arrays.copyOfRange(sequence,i,len-1));
            }
        }
        return res;
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<>();
    //输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
    // 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null || target == 0){
            return res;
        }
        target -= root.val;
        path.add(root.val);
        if(target == 0 && root.left == null && root.right == null){
           // 这里new path是因为左右都会在下次递归path.add(root.val);
            res.add(new ArrayList<>(path));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        path.remove(path.size()-1);
        return res;
    }

    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList();
        //中序遍历，添加至list
        mid(pRootOfTree, list);
        //遍历list，给元素赋双向指针
        return Convert(list);
    }
        public static void mid(TreeNode pRootOfTree,ArrayList<TreeNode> list){
            //中序遍历
            if(pRootOfTree.left!=null){
                mid(pRootOfTree.left,list);
            }
            list.add(pRootOfTree);
            if(pRootOfTree.right!=null){
                mid(pRootOfTree.right,list);
            }
        }

    public static TreeNode Convert(ArrayList<TreeNode> list){
        TreeNode head = list.get(0);
        TreeNode currentNode = head;
        for (int i = 1; i <list.size();i++) {
            TreeNode node = list.get(i);
            node.left = currentNode;
            currentNode.right = node;
            currentNode = node;
        }
        return head;
    }

    //输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //递归实现
    public static int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        if(leftDepth<rightDepth){
            depth = 1+rightDepth;
        }else{
            depth = 1+leftDepth;
        }
        return depth;
    }
    //非递归实现,层次遍历
    public static int TreeDepth1(TreeNode root){
        if(root == null) return 0;
        // 创建辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 0;
        int level= 0;
        TreeNode tmp;
        // 层次遍历
        while(!queue.isEmpty()){
            level++;
            size = queue.size();
            while(size-->0){
                tmp = queue.poll();
                if(tmp.left != null) queue.offer(tmp.left);
                if(tmp.right != null) queue.offer(tmp.right);
            }
        }
        // 返回层次
        return level;
    }

    //输入一棵二叉树，判断该二叉树是否是平衡二叉树。
    //在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
    public static boolean IsBalanced_Solution(TreeNode root) {
        return  depth(root) != -1;
    }

    private static int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = depth(root.left);
        if(left == -1) return -1;
        int right = depth(root.right);
        if(right == -1) return -1;
        if(Math.abs(right - left) >1){
            return -1;
        }else{
            return 1+(left > right?left:right);
        }
    }

    //给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
    ArrayList<TreeLinkNode> list = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode == null){
            return null;
        }
        TreeLinkNode node = pNode;
        //找出根节点，进行中序遍历
        while(node.next != null){
            node = node.next;
        }
        //中序遍历
        inOrder(node);
        //找节点的下一个节点
        for (int i = 0; i < list.size() ; i++) {
            if(pNode == list.get(i)){
                if(i != list.size()-1){
                    return list.get(i+1);
                }else{
                    return null;
                }
            }
        }
        return null;
    }

    private void inOrder(TreeLinkNode pNode) {
        if(pNode!= null){
            inOrder(pNode.left);
            list.add(pNode);
            inOrder(pNode.right);
        }

    }

    //请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null ){
            return true;
        }
        return isSymmetrical1(pRoot.left,pRoot.right);
    }

    private boolean isSymmetrical1(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null  || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }else{
            return isSymmetrical1(left.left,right.right) && isSymmetrical1(right.left,left.right);
        }
    }

    //请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean flag = true;
        while(!queue.isEmpty()){
            int len  = queue.size();
            ArrayList<Integer> treeList = new ArrayList<>();
            for (int i = 0; i <len; i++) {
                TreeNode node = queue.poll();
                if(node == null){continue;}
                if(flag){
                    treeList.add(node.val);
                }else{
                    treeList.add(0,node.val);
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            flag = !flag;
            if(treeList.size() != 0){
                res.add(treeList);
            }
        }
        return res;
    }

    //从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
    public ArrayList<ArrayList<Integer> > Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(pRoot);
        while(!q.isEmpty()){
            int len = q.size();
            ArrayList<Integer> nodeList = new ArrayList<>();
            for (int i = 0; i < len ; i++) {
                TreeNode node = q.poll();
                if(node == null){continue;}
                nodeList.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            if(nodeList.size() != 0){
                res.add(nodeList);
            }
        }
        return res;

    }

    //二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
    // 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以!表示一个结点值的结束（value!）。
    //二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
    //例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树

    String Serialize(TreeNode root) {
        if(root == null){
            return "#";
        }else{
           return root.val+","+ Serialize(root.left) +","+Serialize(root.right);
        }
    }
    int index = -1;
    TreeNode Deserialize(String str) {
        String[] node = str.split(",");
        index++;
        if(index > node.length){
            return null;
        }
        TreeNode treeNode = null;
        if(!node[index].equals("#")){
            treeNode = new TreeNode(Integer.parseInt(node[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;
    }


    ArrayList<Integer> array = new ArrayList<>();
    //给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
    TreeNode KthNode(TreeNode pRoot, int k){
       if(pRoot == null || k <= 0){
           return null;
       }
       preOrder(pRoot);
       Collections.sort(array);
       if(k<=array.size()){
           TreeNode node = new TreeNode(array.get(k-1));
           return node;
       }
      return null;

    }

    private void preOrder(TreeNode pRoot) {
        if(pRoot != null){
            array.add(pRoot.val);
            preOrder(pRoot.left);
            preOrder(pRoot.right);

        }
    }


    /**
    * @author wl
    * @date 2020-07-03 15:47
    *以下是每日一题
    */

    //将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid-1);
        root.right = helper(nums,mid+1,right);
        return root;
    }

    //给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null ){
            return false;
        }
        if(root.left == null && root.right == null){
            return sum==root.val;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
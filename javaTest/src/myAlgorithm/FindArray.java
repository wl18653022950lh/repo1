package myAlgorithm;

/*在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。*/


import java.util.*;

/**
 * @author wl
 * 剑指offer 题目
 *
 */
public class FindArray {
    public boolean Find(int target,int[][] array){
        //思路：从右上角开始遍历，大于向下移，小于向左移
        if(array.length == 0 || target > array[array.length-1][array[0].length-1] || target<array[0][0]){
            return false;
        }
        int rows = array.length;
        int cols = array[0].length;
        int m = 0;
        int n = cols -1;
        while (m>=0 && m < rows && n>=0 && n<cols){
            if(array[m][n] == target){
                return true;
            }else if(array[m][n] > target){
                n--;
            }else{
                m++;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] oddArr = new int[50];
        oddArr[0] = 1;
        for (int i = 2; i <= 50; i++) {
            oddArr[i - 1] = 2 * i - 1;
        }
        int[] evenArr = new int[50];
        for (int j = 1; j <= 50; j++) {
            evenArr[j - 1] = j * 2;
        }
        while (in.hasNext()) {
            String input1 = in.nextLine();
            int N = Integer.parseInt(input1);
            String input2 = in.nextLine();
            String[] cutTrees = input2.split(" ");
            List<Integer> oddList = new ArrayList<>();
            List<Integer> evenList = new ArrayList<>();
            for (int j = 0; j < cutTrees.length; j++) {
                int temp = Integer.parseInt(cutTrees[j]);
                if ((temp & 1) == 0) {
                    evenList.add(temp);
                } else {
                    oddList.add(temp);
                }
            }
            int[] oddLongest = getLongestTreeSequence(oddArr, oddList);
            int[] evenLongedt = getLongestTreeSequence(evenArr, evenList);
            if (oddLongest[1] > evenLongedt[1]) {
                System.out.print(oddLongest[0] + " " + oddLongest[1]);
            } else if (oddLongest[1] < evenLongedt[1]) {
                System.out.print(evenLongedt[0] + " " + evenLongedt[1]);
            } else {
                if (evenLongedt[0] < oddLongest[0]) {
                    System.out.print(evenLongedt[0] + " " + evenLongedt[1]);

                } else {
                    System.out.print(oddLongest[0] + " " + oddLongest[1]);
                }
            }
        }
      /*  Scanner in = new Scanner(System.in);
        int num = 1, max = 1;
        int tree = in.nextInt();
        if (tree <= 100000) {
            int[] c = new int[tree];
            int[] cc = new int[tree];
            for (int i = 0; i < tree; i++) {
                c[i] = in.nextInt();
            }
            if (tree < c.length)
                System.out.println(0);
            for (int i = 0; i < tree; i++) {
                cc[i] = c[i];
                for (int j = i + 1; j < tree; j++) {
                    cc[j] = c[j];
                    if (cc[i] + 1 == cc[j]) {
                        num += 1;
                        cc[i] = cc[j];
                    }
                }
                if (num > max) {
                    max = num;
                }
                num = 1;
            }
            System.out.println(tree - max);
        }*/
        /*int[][] array = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int num = 10;
        FindArray fa = new FindArray();
        System.out.println(fa.Find(num,array));
        System.out.println(fa.Find(87,array));

        int[] arrayRoate = {2,2,3,4,5,6,6};
        System.out.println(fa.minNumberInRotateArray(arrayRoate));

        int[] arrays = {1,4,2,5,6,3,8};
        reOrderArray(arrays);*/

//      int[][] arrays = {{1,2,3,4,5},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        /*int[][] arrays = {{1,2,3,4,5}};
        ArrayList<Integer> list1 = printMatrix(arrays);
        for (Integer integer : list1) {
            System.out.println(integer);
        }*/


       /* Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int target = Integer.parseInt(line.split(" ")[1]);
        String[] nums = line.split(" ")[0].split(",");
        int[] number = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            number[i] = Integer.parseInt(nums[i]);
        }*/
   /* int[] array = {1,2,3,2,4,2,2,2,3};
    System.out.println(MoreThanHalfNum_Solution2(array));*/
    /*int[] array = {-6,-3,-2,-7,-15,-1,-2,-2};
    System.out.println(FindGreatestSumOfSubArray(array));*/
    /*int[] array = {2,4,3,6,3,2,5,5};
    int[] num1 = new int[1];
    int[] num2 = new int[1];*/
  /*  System.out.println(NumberOf1Between1AndN_Solution(13));*/
    /*FindNumsAppearOnce(array,num1,num2);*/
       /* System.out.println(FindContinuousSequence(3));*/
        /*int[] array = {1,2,3,4,5,6};
        System.out.println(FindNumbersWithSum(array,6));*/
       /* System.out.println(LastRemaining_Solution(10,3));*/
        /*int[] num = {};
        int length = num.length;
        int[] num2 = new int[1];
        System.out.println(duplicate(num,length,num2));*/
        /*int[] num = {1,3,-1,-3,5,3,6,7};
        System.out.println(maxInWindows(num,3));*/
        /*System.out.println(cutRope(8));*/
        /*int[] nums = {5,2,6,1};
        int[] nums2 = {2,6};
        System.out.println(intersect(nums,nums2));*/
       /*String[] str = {"flower","flow","flight"};
        System.out.println(replaceSpace(str));*/
    }

    //把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    //输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    //例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    //NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0 || array == null)
            return 0;
        int left = 0;
        int right = array.length-1;
        while(left <= right){
            int mid = (left + right) /2;
            if(array[mid]<array[right]){
                right = mid;
            }else if(array[mid] == array[right]){
                right = right - 1;
            }else{
                left = mid + 1;
            }
        }
        return array[left];
    }

    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    // 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
    // 并保证奇数和奇数，偶数和偶数之间的相对位置不变。

    public static void reOrderArray(int [] array) {
        //冒泡排序
        if(array == null || array.length == 0){
            System.out.println("数组为空数组");
        }
        int len = array.length;
        for(int i= 0;i<len;i++){
            for(int j=0;j<len-i-1;j++){
                if(array[j]%2==0&&array[j+1]%2==1){
                    int t = array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
             }
        }
       /* for(int i= 0;i<len;i++){
            System.out.println(array[i]);
        }*/
        for (int i : array) {
            System.out.println(i);
        }

    }

    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
    // 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
    // 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList list = new ArrayList();
        if(matrix == null ||matrix.length == 0 || matrix[0].length == 0){
            return list;
        }
        int top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        int left = 0;

        while(top<=bottom && left<=right){
            //最上边一行
            for (int topRow = left; topRow <= right; topRow++) {
                list.add(matrix[top][topRow]);
            }
            //最右边
            for(int rightCol = top+1;rightCol <= bottom;rightCol++){
                list.add(matrix[rightCol][right]);
            }
            //最下边  note:刚开始没有写判断，然后测试只有一行的二维数组出现问题
            if(top < bottom){
                for(int bottomRow = right-1;bottomRow >= left;bottomRow-- )
                    list.add(matrix[bottom][bottomRow]);
            }

            //最左边
            if(left < right){
                for(int leftCol = bottom-1;leftCol >= top+1;leftCol--){
                    list.add(matrix[leftCol][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;

        }
        return list;
    }
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
// 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
    /*public static int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int temp = array[0];
        int time = 1;
        for (int i = 1; i < array.length; ++i) {
            if(time == 0){
                temp = array[i];
                time = 1;
            }else if(temp == array[i]){
                ++time;
            }else{
                --time;
            }
        }
        int count = 0;
        for (int i = 0; i < array.length ; i++) {
            if(temp == array[i]){
                ++count;
            }
        }
        if(count > array.length/2){
            return temp;
        }else{
            return 0;
        }
    }*/
    public static int MoreThanHalfNum_Solution2(int[] array) {
        if(array.length == 0){
            return 0;
        }
        Arrays.sort(array);
        int mid = array[array.length/2];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == mid){
                count++;
            }
        }
        if(count>array.length/2){
            return mid;
        }else{
            return 0;
        }
    }

    /*public static int MoreThanHalfNum_Solution2(int[] array){
        //暴力解法
        int max=array.length/2;
        int temp = array[0];
        for (int i = 0; i < array.length; i++) {
            int count=0;
            for (int j = i+1; j < array.length-1-i; j++) {
                if(array[i] == array[j]){
                    temp = array[i];
                    count++;
                }
            }
            if(count>max){
                return temp;
            }else{
                return 0;
            }
        }
        return temp;
    }*/

    //输入n个整数，找出其中最小的K个数。
    // 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        //简单解法：
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length == 0 || k == 0 || k > input.length){
            return list;
        }
        Arrays.sort(input);
        for (int i = 0; i <= k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    //HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了
    // :在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
    // 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
    // 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？

    public static int FindGreatestSumOfSubArray(int[] array) {
        //思路：动态规划
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i-1]>0){
                array[i] += array[i-1];
            }else{
                array[i] += 0;
            }
            max = Math.max(max, array[i]);
        }
        return max;
    }

    //求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
    // 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
    // ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            //判断当前数包含多少个1
            int temp = i;
            while(temp > 0){
                if(temp %10 == 1){
                    count++;
                }
                temp = temp/10;
            }
        }
        return count;
    }
    //输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    // 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
    public static String PrintMinNumber(int[] numbers) {
        if(numbers.length == 0){
            return "";
        }
        for (int i = 0; i <numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int sum1 = Integer.parseInt(numbers[i]+""+numbers[j]);
                int sum2 = Integer.parseInt(numbers[j]+""+numbers[i]);
                if(sum1>sum2){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }

        }
        String res = "";
        for (int i = 0; i <numbers.length ; i++) {
            res+=numbers[i];
        }
        return res;
    }

    //判断list集合中各元素包含的字符是否相等，相等就加入list集合中
    public static ArrayList<ArrayList<String>> find(List<String> list1){
        ArrayList<ArrayList<String>>  resList = new ArrayList<ArrayList<String>>();
        ArrayList<String> list2 = new ArrayList<>(list1);
        for (int i = 0; i < list1.size(); i++) {
            char[] chars;
            chars = list1.get(i).toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            list1.set(i,str);
        }

        for (int i = 0; i < list2.size()-1; i++) {
            ArrayList<String> list3 = new ArrayList<>();
            list3.add(list2.get(i));
            for (int j = i+1; j < list2.size(); j++) {
                if(list1.get(i).equals(list1.get(j))){
                    list3.add(list2.get(j));
                    list1.remove(j);
                    list2.remove(j);
                    j--;
                }
            }
            if(list3.size()!=1){
                resList.add(list3);
            }

        }

        return resList;
    }

    //统计一个数字在排序数组中出现的次数。
    public static int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0 || k <array[0] || k > array[array.length-1]){
            return -1;
        }
        int left = 0;
        int right = array.length-1;
        int count = 0;
        while(left <= right){
            int mid = left +(right-left)/2;
            if(array[mid]< k){
                left = mid +1;
            }else if(array[mid] == k){
                count++;
                right = mid - 1;
                while(right>=0){
                    if(array[right] == k){
                        count++;
                        right--;
                    }else{
                        break;
                    }
                }
                left = mid+1;
                while(left < array.length){
                    if(array[left]==k){
                        count++;
                        left++;
                    }else{
                        break;
                    }
                }

            }else{
                right = mid-1;
            }
        }
        return count;
    }

    //一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i <array.length ; i++) {
            if(map.containsKey(array[i])){
                map.put(array[i],2);
            }else{
                map.put(array[i],1);
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(map.get(array[i]) == 1){
                if(count == 0){
                    num1[0] = array[i];
                    count++;
                }else{
                    num2[0] = array[i];
                }
            }
        }
        System.out.println(num1[0]);
        System.out.println(num2[0]);

    }

    //输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
       /* ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        int temp = 0;//用来存储当前序列的和
        for(int i=1;i<sum;i++){
            temp+=i;
            for(int j=i+1;j<sum;j++){
                temp+=j;
                if(temp==sum){
                    ArrayList<Integer> resList = new ArrayList<>();
                    for(int k=i;k<j;k++){
                        resList.add(k);
                    }
                    res.add(resList);
                    break;
                }
            }
            temp=0;
        }
        return res;*/
       //滑动窗口解法
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        int left= 1,right = 1;
        int temp = 0;
        while(left<=sum/2){
            if(temp <sum){
                temp+=right;
                ++right;
            }else if(temp > sum){
                temp-=left;
                ++left;
            }
            else{
                ArrayList<Integer> resList = new ArrayList<>();
                for(int k=left;k<right;++k){
                    resList.add(k);
                }
                res.add(resList);
                temp -= left;
                ++left;
            }
        }
        return res;
    }

    //输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        /*ArrayList<Integer> res = new ArrayList<>();
        if(array.length <= 1 || array == null || sum <array[0]) {
            return res;
        }
         int min = 0;
         int temp = (int) Math.pow(2,31);
            for (int i = 0; i < array.length; i++) {
                for (int j = i+1; j <array.length ; j++) {
                    if(array[i]+array[j] == sum){
                        min = array[i]*array[j];
                        if(min<temp){
                            res.add(array[i]);
                            res.add(array[j]);
                        }
                        temp = min;
                    }
                }
            }
            return res;*/

        //边界条件，最外层的乘积最小，所以第一次加进来的最小
        ArrayList<Integer> res = new ArrayList<>();
        if(array.length <= 1 || array == null ||sum <array[0]) {
            return res;
        }
        int slow=0;
        int high = array.length-1;
        while(slow<high){
            int current = array[slow]+array[high];
            if(current<sum){
                slow++;
            }else if(current>sum){
                high--;
            }else if(current==sum){
                res.add(array[slow]);
                res.add(array[high]);
                break;
            }
        }
        return res;
    }


    //首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
    // 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
    // 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
    // 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
    //如果没有小朋友，请返回-1
    public static int LastRemaining_Solution(int n, int m) {
        if(n == 0 || m == 0){
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int cur = -1;
        while(list.size()>1){
            for(int i = 0;i<m;i++){
                cur++;
                if(cur == list.size()){
                    cur = 0;
                }
            }
            list.remove(cur);
            cur--;//cur--的原因，因为新的list中cur指向了下一个元素，为了保证移动m个准确性，所以cur向前移动一位。
        }
        return list.get(0);
    }


    //求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    public int Sum_Solution(int n) {
        int dd=n;
        boolean r=(n>0) && ( (dd=dd+Sum_Solution(n-1))>0 );
        return dd;

    }

    //写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
    //第一步：相加各位的值，不算进位，二进制每位相加就相当于各位做异或操作；
    //第二步：计算进位值，相当于各位做与操作，再向左移一位。
    //第三步重复上述两步， 各位相加 ，计算进位值。进位值为0，跳出循环。
    public int Add(int num1,int num2) {
        while (num2!=0) {
            int temp = num1^num2;//相加
            num2 = (num1&num2)<<1;//进位
            num1 = temp;
        }
        return num1;
    }

    //在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
    // 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length <= 0 || numbers == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<length;i++){
            if(set.contains(numbers[i])){
                duplication[0]=numbers[i];
                return true;//返回第一个出现重复的数字
            }else{
                set.add(numbers[i]);
            }
        }
        return false;
    }

    //给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
    // 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）

    public int[] multiply(int[] A) {
        int[] res = new int[A.length];
        int temp = 0;
        for (int i = 0; i < A.length ; i++) {
            temp = A[i];
            A[i] = 1;
            res[i] = 1;
            for (int j = 0; j < A.length; j++) {
                res[i] *= A[j];
            }
            A[i] = temp;
        }
        return res;
    }

    //如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
    // 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
    // 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
    ArrayList<Integer> numList = new ArrayList<>();
    public void Insert(Integer num) {
        numList.add(num);
        Collections.sort(numList);

    }

    public Double GetMedian() {
        int listSize = numList.size();
        if(listSize%2 != 0){
            int mid = listSize/2;
            return Double.valueOf(numList.get(mid));
        }else if(listSize%2 == 0){
            int left = (listSize/2)-1;
            int right = listSize/2;
            Double midNum = (numList.get(left)+numList.get(right))/2.0;
            return midNum;
        }
        return -1.0;
    }

    //给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
    // 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
    // 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
    // {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
    public static ArrayList<Integer> maxInWindows(int[] num, int size){
       /* //暴力解法：
        ArrayList<Integer> maxList = new ArrayList<>();
        if(num.length == 0 || size <=0){
            return maxList;
        }
        int len = num.length;
        for (int i = 0; i <= len-size; i++) {
            int max = num[i];
            for (int j = i+1; j < i+size; j++) {
                if(num[j]>max){
                    max = num[j];
                }
            }
            maxList.add(max);
        }
        return maxList;*/

       //解法二：定义滑动窗口左右边界
        ArrayList<Integer> maxList = new ArrayList<>();
        if(num.length == 0 || size <=0){
            return maxList;
        }
        int len = num.length;
        int max = num[0];
        int low  = 0;
        int high = size-1;
        while(high<len){
            max = num[low];
            for (int i = low; i <= high; i++) {
                if(max < num[i]){
                    max = num[i];
                }
            }
            maxList.add(max);
            low++;
            high++;

        }
        return maxList;
    }

    //请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
    // 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length == 0 || matrix == null || str.length == 0 || matrix.length < str.length) {
            return false;
        }
        char[][] array = new char[rows][cols];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = matrix[k++];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //标记是否重复访问
                boolean[][] visited = new boolean[rows][cols];
                boolean flag = judge(array,rows,cols,i,j,str,visited,0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean judge(char[][] array, int rows,int cols,int row, int col, char[] str, boolean[][] visited,int index) {
        //已经匹配完
       if(index >= str.length){
            return true;
        }
       //如果下标越界\当前元素已经访问过\和当前元素匹配不上
        if(row<0 || row>=rows || col<0 || col>=cols || array[row][col] != str[index] || visited[row][col] == true){
            return false;
        }
        //否则将当前元素置为已经访问,匹配下一个字符
        visited[row][col] = true;
        index++;
        //判断当前元素的前后左右
                //向下
        return judge(array,rows,cols,row+1,col,str,visited,index) ||
                //向左
                judge(array,rows,cols,row,col-1,str,visited,index)||
                //向上
                judge(array,rows,cols,row-1,col,str,visited,index)||
                //向右
                judge(array,rows,cols,row,col+1,str,visited,index);
    }

    //地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
    //例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

    //判断坐标是否大于threshold
    private boolean isValid(int threshold, int row, int col) {
        int sum = 0;
        while(row>0){
            sum+=row%10;
            row=row/10;
        }
        while(col>0){
            sum+=col%10;
            col = col/10;
        }
        if(sum>threshold){
            return false;
        }else{
            return true;
        }
    }

    //统计总次数
    int moveCount = 0;
    private void move(int threshold, int row,int col,int rows, int cols, boolean[][] isVisited) {
        //坐标是否符合
        if(row<0 || row>=rows || col<0 || col>=cols){
            return;
        }
        //已经走过，不计数
        if(isVisited[row][col]){
            return;
        }
        if(!isValid(threshold,row,col)){
            isVisited[row][col] = true;//如果不满足坐标各项和小于threshold，不计数，并且标记是访问过的
            return;
        }
        isVisited[row][col] = true;
        moveCount++;
        //向上
        move(threshold,row-1,col,rows,cols,isVisited);
        //向下
        move(threshold,row+1,col,rows,cols,isVisited);
        //向左
        move(threshold,row,col-1,rows,cols,isVisited);
        //向右
        move(threshold,row,col+1,rows,cols,isVisited);
    }

    public int movingCount(int threshold, int rows, int cols){
        boolean[][] isVisited = new boolean[rows][cols];
        move(threshold,0,0,rows,cols,isVisited);
        return moveCount;
    }


    //给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[1],...,k[m]。
    // 请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
    public static int cutRope(int target) {
        return cutRope(target,0);
    }

    private static int cutRope(int target, int max) {
        int maxValue = max;
        for (int i = 1; i < target; i++) {
            int value = i*cutRope(target-i,target-i);
            maxValue = Math.max(maxValue,value);
        }
        return maxValue;
    }


    /**
     * @author wl
     * @date 2020-06-24 09:07
     *以下是leetcode  每日一题
     */

    //给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
    // 返回这三个数的和。假定每组输入只存在唯一答案。

    /*//方法一：暴力破解
    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    sum = nums[i]+nums[j]+nums[k];
                    min = Math.min(Math.abs(sum-target),min);
                }
            }
        }
        return min+target;
    }*/
    //  方法二：双指针
    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                sum = nums[i]+ nums[start] +nums[end];
                if(sum>target){
                    end--;
                }else{
                    start++;
                }

            }
            min = Math.min(Math.abs(sum-target),min);
        }
        return min+target;
    }

    //查找字符串数组最长公共前缀，如果不存在，就返回" "
    public static String replaceSpace(String[] strs) {
        // 如果检查值不合法及就返回空串
        if (!checkStrs(strs)) {
            return "";
        }
        // 数组⻓度
        int len = strs.length;
        // ⽤于保存结果
        StringBuilder res = new StringBuilder();
        // 给字符串数组的元素按照升序排序(包含数字的话，数字会排在前⾯)
        Arrays.sort(strs);
        int m = strs[0].length();
        int n = strs[len - 1].length();
        int num = Math.min(m, n);
        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else
                break;
        }
        return res.toString();
    }
    private static boolean checkStrs(String[] strs) {
        boolean flag = false;
        if (strs != null) {
            // 遍历strs检查元素值
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null && strs[i].length() != 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    //给定一个包含大写细目和小写字母的字符串，找到通过这些字母构成的最长回文串的长度。
    // 比如：输入abccccdd,输出：7，最长回文串为：dccaccd
    //字符串出现双数的组合    字符串出现双数的组合加一个只出现一次的字符
    public int longestPalindrome(String s){
        if(s.length() == 0){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if(!set.contains(chars[i])){
                set.add(chars[i]);
            }else{
                set.remove(chars[i]);
                count++;
            }

        }
        return set.isEmpty()?count*2:count*2+1;
    }

    //给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }

    //给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length ==0){
            return 0;
        }
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;
        for (int i = end; i < nums.length; i++) {
            sum+=nums[i];
            while(sum>=s){
              minLength = Math.min(minLength,end-start+1);
              sum-=nums[start];
              start++;
            }
            end++;
        }
        return minLength == Integer.MAX_VALUE?0:minLength;
    }


    //在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static int findKthLargest2(int[] nums, int k) {
        k = nums.length - k;//注意这里的k已经变了
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int i = lo;
            //这里把数组以A[lo]的大小分为两部分，
            //一部分是小于A[lo]的，一部分是大于A[lo]的
            // [lo,i]<A[lo]，[i+1,j)>=A[lo]
            for (int j = lo + 1; j <= hi; j++)
                if (nums[j] < nums[lo])
                    swap(nums, j, ++i);
            swap(nums, lo, i);
            if (k == i)
                return nums[i];
            else if (k < i)
                hi = i - 1;
            else
                lo = i + 1;
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[j];
            nums[j] = nums[i];
            nums[i] = nums[j];
        }
    }

    //给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
    //动态规划 dp[i][j]含义是以A[i] B[j]结尾的最大公共子串的长度的较大值
    public int findLength(int[] A, int[] B) {
        if(A.length == 0 || B.length == 0){
            return 0;
        }
        int[][] dp =  new int[A.length+1][B.length+1];
        int count = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    count = Math.max(count,dp[i][j]);
                }
            }

        }
        return count;
    }

    //给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
    //请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
    //二分查找:如果小于等于mid的元素个数小于k，说明mid不是第k小的数，比mid小的数就更不可能是了。所以第k小的数至少是mid + 1。
    //如果小于等于mid的元素个数大于等于k，说明mid可能为第k小的数，比它小的数也有可能是答案。

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length -1;
        int left = matrix[0][0];
        int right = matrix[n][n];
        while(left < right){
            int mid = left+(right-left)/2;
            int count = notMoreThan(matrix,mid,n);
            if(count < k){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    private int notMoreThan(int[][] matrix, int mid, int n) {
        int count = 0;
        int j = 0;
        int i = n;
        while(i>=0 && j<=n){
            if(matrix[i][j] <= mid){
                count+= i+1;
                j++;
            }else{
                i--;
            }
        }
        return count;
    }


    //一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    //机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    //现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return totalPathNum(obstacleGrid,0,0,new HashMap<String,Integer>());
    }

    private int totalPathNum(int[][] obstacleGrid, int down, int right,Map<String,Integer> map) {
        String key = down +"and" + right;
        int result = 0;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(obstacleGrid[down][right] == 1){
            result = 0;
            map.put(key,result);
            return result;
        }
        if(down == obstacleGrid.length-1 && right ==obstacleGrid[0].length-1){
            if(obstacleGrid[down][right] == 1){
                result =  0;
            }else{
                result =  1;
            }
            map.put(key,result);
            return result;
        }
        if(down == obstacleGrid.length-1 || right ==obstacleGrid[0].length-1){
            if(down == obstacleGrid.length-1){
                result =  totalPathNum(obstacleGrid,down,right+1,map);
            }else{
                result =  totalPathNum(obstacleGrid,down+1,right,map);
            }
            map.put(key,result);
            return result;
        }
        result =  totalPathNum(obstacleGrid,down+1,right,map) + totalPathNum(obstacleGrid,down,right+1,map);
        map.put(key,result);
        return result;
    }
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        // 定义 dp 数组并初始化第 1 行和第 1 列。
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        // 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    //你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
    //返回的长度需要从小到大排列。
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0){
            return new int[0];
        }
        if(shorter == longer){
            return new int[]{k*shorter};
        }
        int[] res = new int[k+1];
        for (int i = 0; i <= k; i++) {
             res[i] = shorter*(k-i) + i*longer;
        }
        return res;
    }
    //哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"
    // 已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。
    // 当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
    public int respace(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        for (String s : dictionary) {
            set.add(s);
        }
        int len = sentence.length();
        //dp[i]表示前i个字符串中未识别的字符数
        int[] dp = new int[len+1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i-1] +1;//先假设当前字符是未识别的
            for (int j = 0; j < i; j++) {
                if(set.contains(sentence.substring(j,i))){
                    dp[i] = Math.min(dp[i],dp[j]);
                }
            }
        }
        return dp[len];
    }
    //给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
    //设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
    //你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        //状态转移方程
        int dp[][] = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //三种情况：
            // 在第 i 天结束之后持有股票的最大收益,（前一天就持有的，当天买的并且前一天不处于冷冻期）取最大值
            dp[i][0] = Math.max(dp[i-1][0],(dp[i-1][2] -prices[i]));
            //在第 i 天结束之后不持有股票，并在冷冻期的最大收益。那么说明在第 i-1天时我们必须持有一支股票，对应的状态为 f[i-1][0]f[i−1][0] 加上卖出股票的正收益prices[i]
            dp[i][1] = dp[i-1][0]+prices[i];
            //在第 i 天结束之后不持有任何股票并且不处于冷冻期的最大收益。说明当天没有做任何操作，即第i-1天时不持有任何股票，
            // 如果第i-1天处于冷冻期，对应的状态为 f[i-1][1]f[i−1][1]；如果不处于冷冻期，对应的状态为 f[i-1][2]f[i−1][2]
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

    //给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
    public static List<Integer> countSmaller(int[] nums) {
        if(nums.length == 0 || nums == null){
            return new ArrayList<Integer> ();
        }
        //使用链表头插法
        ArrayList<Integer> res = new ArrayList<>();
        int len = nums.length;
        //反向插入排序
        for(int i = len - 2; i >= 0; i--){
            int j = i + 1;
            int temp = nums[i];
            while(j < len && nums[j] >= temp){
                nums[j - 1] = nums[j];
                j++;
            }
            nums[j - 1] = temp;
            //len - j就表示计数个数
            res.add(0,len - j);
        }
        //添加最后一个数
        res.add(0);
        return res;
    }

    //一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
    //骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
    //有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
    //为了尽快到达公主，骑士决定每次只向右或向下移动一步。
    public int calculateMinimumHP(int[][] dungeon) {
        //从右下往左上进行动态规划
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m-1] = dp[n-1][m] = 1;
        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >=0 ; j--) {
                dp[i][j] = Math.max(Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
    //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    //如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
    //注意：你不能在买入股票前卖出股票。
    public int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                min = prices[i];
            }else if(prices[i]-min >maxProfit){
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }

    //给定两个数组，编写一个函数来计算它们的交集。
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else{
                map.put(nums1[i],1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums2.length; j++) {
            if(map.containsKey(nums2[j]) && map.get(nums2[j]) > 0){
                list.add(nums2[j]);
                map.put(nums2[j],map.get(nums2[j])-1);
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }

   /* 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
    相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。*/

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i-1][0]+triangle.get(i).get(0);//j=0时,dp[i-1][j-1]没有意义
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);//状态转移方程
            }
            //j=i时，dp[i-1][j]没有意义
            dp[i][i] = dp[i-1][i-1]+triangle.get(i).get(i);

        }
        //最终最小值为dp[n-1][i]中的某一个
        int minSum = dp[len-1][0];
        for (int j = 1; j < len; j++) {
            minSum = Math.min(minSum,dp[len-1][j]);
        }
        return minSum;
    }


       /* private static int[] oddArr;
        private static int[] evenArr;*/
        public static int[] getLongestTreeSequence(int[] arr, List<Integer> cutTreeList) {

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < arr.length; i++) {
                queue.add(arr[i]);
            }
            Collections.sort(cutTreeList);
            int pos = -1;
            int longest = 0;
            int i = 0;
            while (!queue.isEmpty() && i < cutTreeList.size()) {
                int cutTreeVal = cutTreeList.get(i);
                int curLen = 0;
                int curPos = queue.peek();
                while (!queue.isEmpty() && queue.peek() < cutTreeVal) {
                    queue.poll();
                    curLen++;
                }
                if (!queue.isEmpty() && cutTreeVal == queue.peek()) {
                    queue.poll();
                }
                if (curLen > longest) {
                    pos = curPos;
                    longest = curLen;
                }
                i++;
            }
            if (!queue.isEmpty()) {
                if (queue.size() > longest) {
                    pos = queue.peek();
                    longest = queue.size();
                }
            }
            int[] ret = new int[2];
            ret[0] = pos;
            ret[1] = longest;
            return ret;
        }



}



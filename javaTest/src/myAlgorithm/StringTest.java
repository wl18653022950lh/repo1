package myAlgorithm;

import java.util.*;


/**
* @author wl
* 剑指offer 题目
*
*/

public class StringTest {
    public static void main(String[] args) {
       /* StringBuffer str = new StringBuffer("We Are Happy");
        StringTest st = new StringTest();
        System.out.println(st.replaceSpace(str));*/
       /*String str = "student. a am I";*/
       /*ArrayList<String> list = new ArrayList<>();
        Permutation(str);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i)+" ");
        }*/
       /*int[] arr = {0,3,2,6,4};
       System.out.println(isContinuous(arr));*/
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[1]);
        System.out.print(a/b+" "+a%b);

    }
    /*1、请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。*/
    public String replaceSpace(StringBuffer str) {
        //思路：定义新数组
        String res = "";
        if(str == null){
            return null;
        }else{
            for (int i = 0;i<str.length();i++){
                char c = str.charAt(i);
                if(c ==' '){
                    res += "%20";
                }else{
                    res += c;
                }
            }
        }
        return res;
       /* //直接用字符串的replaceAll方法
        return str.toString().replaceAll(" ","%20");*/
    }

    //输入一个字符串,按字典序打印出该字符串中字符的所有排列。
    // 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
    public static ArrayList<String> Permutation(String str) {
        //递归回溯
        if(str == null){
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        char[] pStr = str.toCharArray();
        Permutation(pStr,0,list);
        Collections.sort(list);
        return list;
    }

    private static void Permutation(char[] str, int i, ArrayList<String> list) {
        if(str == null){
            return;
        }
        if(i == str.length-1){
            if(list.contains(String.valueOf(str))){
                return;
            }
            list.add(String.valueOf(str));
        }else{
            for (int j = i; j < str.length; j++) {
                //把做排列操作的字符串的第一个字符和后面的所有字符交换
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;
                //交换后对i后面的字符串递归做排列操作
                Permutation(str,i+1,list);
                //每一轮结束后换回来进行下一轮排列操作
                temp = str[j];
                str[j] = str[i];
                str[i] =temp;
            }
        }
    }

    //把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
    // 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
    public static int GetUglyNumber_Solution(int index) {
        if(index == 0){
            return 0;
        }
        if(index<7){
            return index;
        }
        int[] result = new int[index];
        result[0] =1;
        int n2 = 0;//2的队列
        int m3 = 0;//3的队列
        int k5 = 0;//3的队列
        for (int i = 1; i < index; i++) {
            result[i] = Math.min( Math.min(result[n2]*2,result[m3]*3),result[k5]*5);
            if (result[i] == result[n2] * 2) {
                n2++;
            }

            if (result[i] == result[m3] * 3) {
                m3++;
            }

            if (result[i] == result[k5] * 5) {
                k5++;
            }
        }
        return result[index-1];
    }

    //在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
    // 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
    public static int FirstNotRepeatingChar(String str) {
        if(str.length() == 0 || str == null){
            return -1;
        }
        char[] chars = str.toCharArray();
        int index = -1;
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                if(chars[i] == chars[j]){
                    count ++;
                }
            }
            if(count == 1){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int FirstNotRepeatingChar1(String str) {
        if(str.length() == 0 || str == null){
            return -1;
        }

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < str.length();i++){
            if(!map.keySet().contains(str.charAt(i))){
                map.put(str.charAt(i),1);
            }else{
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }
        }

        for(int i = 0; i < str.length();i++){
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    //在数组中的两个数字，如果前面一个数字大于后面的数字，
    // 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
    //1,2,3,4,5,6,7,0   7
    public static int InversePairs(int[] array) {
        if(array.length == 0|| array == null){
            return -1;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]){
                    count++;
                }
            }

        }
        return count%1000000007;
    }

    //数组中的逆序对，归并排序
    private static int cnt;
    private static void MergeSort ( int[] array, int start, int end){
        if (start >= end) return;
        int mid = start + (end-start) / 2;
        MergeSort(array, start, mid);
        MergeSort(array, mid + 1, end);
        MergeOne(array, start, mid, end);
    }
    private static void MergeOne(int[] array, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int k=0,i=start,j=mid+1;
        while(i<=mid && j<= end){
            //如果前面的元素小于后面的不能构成逆序对
            if(array[i] <= array[j])
                temp[k++] = array[i++];
            else{
                //如果前面的元素大于后面的，那么在前面元素之后的元素都能和后面的元素构成逆序对
                temp[k++] = array[j++];
                cnt = (cnt + (mid-i+1))%1000000007;
            }
        }
        while(i<= mid)
            temp[k++] = array[i++];
        while(j<=end)
            temp[k++] = array[j++];
        for(int l=0; l<k; l++){
            array[start+l] = temp[l];
        }
    }
    public static int InversePairs1(int [] array) {
        MergeSort(array, 0, array.length-1);
        return cnt;
    }

    //对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
    // 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
    public static String LeftRotateString(String str,int n) {
        if(n>str.length()){
            return str;
        }
        return str.substring(n)+str.substring(0,n);
        /*char[] c = str.toCharArray();
        String s = "";
        String s1 = "";
        for (int i = 0; i <c.length ; i++) {
            if(i<n){
                s1+=c[i];
            }
            else{
                s+=c[i];
            }
        }
        s+=s1;
        return s;*/
    }

    //牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
    // 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
    public static String ReverseSentence(String str) {
        if (str == null || str.trim().length() == 0) return str;
        String[] ss = str.split(" ");
        String s = "";
        for (int i = ss.length-1; i >= 0; i--) {
            if(i == 0){
                s+=ss[i];
            }else{
                s+= ss[i]+" ";
            }

        }
        return s;
    }
        /*char[] chars = str.toCharArray();
        swap(chars,0,str.length()-1);
        int left = 0;
        int right = 0;
        while(left<chars.length){
            if(chars[right] == ' '){
                swap(chars,left,right-1);
                right++;
                left = right;
            }
            if(right == chars.length-1){
                swap(chars,left,right);
                break;
            }*9
            right++;
        }
    return String.valueOf(chars);
    }

    private static void swap(char[] str, int a, int b) {
        while(a<b){
            char tmp =  str[a];
            str[a] = str[b];
            str[b] = tmp;
            a++;
            b--;
        }
    }*/

   /* LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,
    看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
    他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
    LL决定去买体育彩票啦。现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
    为了方便起见,你可以认为大小王是0。*/
    public static boolean isContinuous(int[] numbers) {
        //5个数的数组，连续不重复，最大值与最小值相差不超过5
        if(numbers.length <5  || numbers.length > 5){
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int min = 0;
        int max = 13;
        for (int number : numbers) {
            if (number > 0) {
                if (list.contains(number)) {
                    return false;
                }else{
                    list.add(number);
                }
            }
        }
                Collections.sort(list);
                max  = list.get(list.size()-1);
                min = list.get(0);
        return max - min < 5;
    }

    //将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
    //输入一个字符串,包括数字字母符号,可以为空
    //如果是合法的数值表达则返回该数字，否则返回0
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0 || str == "+" || str == "-") return 0;
        int limit = -Integer.MAX_VALUE;
        int label = 1;
        int result = 0;
        for (int i = 0; i < str.length(); i++){
            if (i == 0 && ((str.charAt(i) == '-') || str.charAt(i) == '+')){  // 第一位如果是0,"+"或者"-"
                if (str.charAt(i) == '-'){  // 若是"-",则改变边界条件(limit)和符号位(label)
                    limit = Integer.MIN_VALUE;
                    label = -1;
                }
                continue;
            }else if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){    // 如果是数字,继续分析
                int num = str.charAt(i) - '0';
                int temp = result * 10;
                if (result >= (limit / 10) && temp >= (limit + num) ){  // 关键在这里
                    result = result * 10 - num;
                }else {     // 数值溢出, 返回0
                    return 0;
                }
            }else {     // 如果是非法字符, 返回0
                return 0;
            }
        }
        return label > 0 ? -result: result;

    }

    //请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
    // 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
    public boolean match(char[] str, char[] pattern){
        if(str == null || pattern == null){
            return false;
        }
        return matchStr(str,0,pattern,0);
    }

    private boolean matchStr(char[] str, int i, char[] pattern, int j) {
        if(i == str.length && j == pattern.length){
            return true;
        }else if(i < str.length && j == pattern.length){
            return false;
        }
        if(j+1<pattern.length && pattern[j+1] == '*'){
            if((i<str.length && pattern[j] == '.')|| (i<str.length && pattern[j] == str[i])){
                return matchStr(str,i,pattern,j+2) || matchStr(str,i+1,pattern,j);//abcdeeded 与a.*d匹配
            }else{
                return matchStr(str,i,pattern,j+2);
            }
        }
        if(i<str.length && (pattern[j] == '.' || str[i] == pattern[j])){
            return matchStr(str,i+1,pattern,j+1);
        }else{
            return false;
        }
    }

    //请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
    // 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
    //
    private boolean isNumeric(char[] str, int i) {
        if (str.length==0 || str == null)
            return false;
        //判断第一位是否是符号位，isE表示之前E或e出现过没，isPoint表示之前小数点出现过没
        if (str[0]=='-'||str[0]=='+')
            return IsNumber(str,1,false,false);
        else
            return IsNumber(str,0,false,false);
    }

    public boolean IsNumber(char str[],int i,boolean isE,boolean isPoint){
        if (i>str.length)
            return false;
        else if (i==str.length)
            return true;
        if (str[i]<='9'&&str[i]>='0'){
            return IsNumber(str,i+1,isE,isPoint);
        } else if(str[i]=='.' || str[i]=='e' || str[i]=='E'){
            if (str[i]=='e' || str[i]=='E'){
                isE=true;
            }
            if (str[i]=='.' && isE)
                return false;   //小数点出现过了，又遇到e或E肯定错 124e+1.2算错

            if (str[i]=='.'){
                if (isPoint)//小数点出现过了，又遇到小数点肯定错
                    return false;
                isPoint=true;
                return IsNumber(str,i+1,isE,isPoint);
            } else{
                if (i+1>=str.length){
                    return false;
                }else {
                    if (str[i+1]=='+'||str[i+1]=='-'){
                        return IsNumber(str,i+2,isE,isPoint);
                    }else {
                        return IsNumber(str,i+1,isE,isPoint);
                    }
                }
            }
        } else {
            return false;
        }
    }

    //请实现一个函数用来找出字符流中第一个只出现一次的字符。
    // 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
    Map<Character,Integer>  map = new LinkedHashMap<>();
    public void Insert(char ch)
    {
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }else{
            map.put(ch,1);
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                char mapKey = entry.getKey();
                return mapKey;
            }
        }
        return '#';
    }


   /* 洗牌
   public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            for(int m = 0;m<T;m++){
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] a = new int[n];
                for(int i = 0;i<n;i++){
                    a[i] = sc.nextInt();
                }
                for(int i = 0 ; i<k;i++){
                    method(a,n);
                }
                for (int i = 0; i < n  - 1; i ++) {
                    System.out.print(a[i] + " ");
                }
                System.out.println(a[n  - 1]);
            }
        }
        private static void method(int[] a, int n) {
            ArrayList<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < n / 2; i ++) {
                list.add(a[i]);
                list.add(a[i + n / 2]);
            }
            for (int i = 0; i < n/2; i ++) {
                a[i] = list.get(i);
            }
        }
    }*/

    /**
     * @author wl
     * @date 2020-06-24 09:07
     *以下是leetcode  每日一题
     */

    //给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j,i))){ //substring包含下标，不包含上标
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //统计一个字符串中各个字符出现的次数
    public  void countStr(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            map.put(c, !map.containsKey(c)?1:(map.get(c)+1));
        }
        for (Character c : map.keySet()) {
            System.out.println(c+":"+map.get(c));
        }
    }

}


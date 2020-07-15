package myAlgorithm;

/**
 * @Author wl
 * @Date 2020/5/29 13:28
 * @Version 1.0
 */

public class MiGong {
    public static void main(String[] args) {
        //创建二维数组，模拟迷宫，1表示墙
        int[][] map = new int[8][7];
        //上下全部置为1
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[map.length - 1][i] = 1;

        }
        //左右都置为1
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][map[0].length - 1] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        map[1][2] = 1;
        map[2][2] = 1;

        //输出地图
        System.out.println("地图的情况：");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println(" ");
        }

        //使用递归回溯给小球找路
        setWay(map, 1, 1);

        //输出新的地图
        System.out.println("小球走过，并标识过的地图的情况：");
        for (int k = 0; k < 8; k++) {
            for (int m = 0; m < 7; m++) {
                System.out.print(map[k][m] + " ");
            }
            System.out.println(" ");
        }
    }



    private static boolean setWay(int[][] map, int i, int j) {
        //找路的策略，上右下左
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {//当前这个点还没走过
                map[i][j] = 2;//假定当前点可以走通
                if (setWay(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左走
                    return true;
                } else {//走不通，说明是死路
                    map[i][j] = 3;
                    return false;
                }
            }else{//map[i][j]!=0;可能是1，2，3
                return false;
            }
        }
    }

}
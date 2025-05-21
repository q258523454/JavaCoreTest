package resume.swordoffer66;

import java.util.ArrayList;

/**
 * Created By
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * @author :   zhangj
 * @date :   2018-12-27
 */


public class Solution27 {


    public ArrayList<String> Permutation(String str) {

        ArrayList<String> arrayList = new ArrayList<>();
        if (str == null || str.length() <= 0) {
            return arrayList;
        }

        char[] chars = new char[str.length()];
        int[] flag = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
            flag[i] = 1;
        }

        SubPermutation(arrayList, chars, flag, "");


        System.out.println("原始:" + arrayList.toString());

        // 删除重复序列(重复元素导致)—— 不删除重复元素就是全排列
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(i).equals(arrayList.get(j))) {
                        arrayList.remove(j);
                    j--;
                }
            }
        }

        return arrayList;
    }


    /***
     * 全排列
     * @param arrayList
     * @param chars
     * @param flag 初始化全部为1, 1:已使用 0:不可用
     * @param path 当前路径(排列)
     * @return
     */
    public ArrayList<String> SubPermutation(ArrayList<String> arrayList, char[] chars, int[] flag, String path) {
        if (path.length() == chars.length) {
            arrayList.add(path);
        }

        for (int j = 0; j < chars.length; j++) {
            if (flag[j] == 1) {
                int[] nFlag = flag.clone();
                nFlag[j] = 0;

                // 注意细节:这里必须复制path重新传递新变量, 因为当前循环的path不能在下一次循环使用
                String nPath = path;
                nPath += chars[j];
                SubPermutation(arrayList, chars, nFlag, nPath);
            }
        }
        return arrayList;
    }




    public static void main(String[] args) {
        String str = "aab";
        Solution27 solution27 = new Solution27();
        System.out.println(solution27.Permutation(str));
    }

}

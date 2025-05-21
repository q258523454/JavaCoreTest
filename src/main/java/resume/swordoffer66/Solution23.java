package resume.swordoffer66;

/**
 * Created By
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 关键点: 根节点的左子树一定比它小，根节点的右子树一定比它大，而后序遍历会有如下规律:
 * 1.根节点一定是最后1个元素
 * 2.如果有右子树,那么最后一个元素的后面一定有一串连续x个节点比根节点大
 * 3.如果有左子树,那么最后一个元素的前面一定有一串连续y个节点比根节点小,而且这些连续的节点一定在(2)的前面
 * 例如: 3,2,6,5,10,12,11,9, 其中{3,2,6,5}是连续的比9小的左子树,{10,12,11}是连续的比9大的右子树
 * @author :   zhangj
 * @date :   2018-12-25
 */
public class Solution23 {

    public boolean VerifySquenceOfBST(int[] sequence) {

        if (sequence.length == 0 || null == sequence) {
            return false;
        }

        if (sequence.length == 1) {
            return true;
        }

        return VerifySubSquenceOfBST(sequence, 0, sequence.length - 1);
    }


    public boolean VerifySubSquenceOfBST(int[] sequence, int start, int end) {

        if (end - start <= 0 || end <= 1) {
            return true;
        }

        int root = sequence[end];

        int r = end - 1;
        while (r >= start && sequence[r] > root) {
            r--;
        }
        if (r < start) {
            // 只有右子树
            return true && VerifySubSquenceOfBST(sequence, start, end - 1);
        }
        // 至此, 二叉搜索树, 右子树范围确定: [r+1,end-1]


        // 左子树
        int l = r;
        while (l >= start && sequence[l] < root) {
            l--;
        }
        if (l >= start) {
            // 左子树只能比根节点小
            return false;
        }
        // 至此, 二叉搜索树, 左子树范围确定: [0,r]

        //printConsole(sequence, start, r, end);

        return true && VerifySubSquenceOfBST(sequence, start, r) && VerifySubSquenceOfBST(sequence, r + 1, end - 1);
    }


    public static void printConsole(int[] sequence, int start, int r, int end) {
        System.out.print("left:");
        for (int i = start; i <= r; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.print("right:");
        for (int i = r + 1; i <= end - 1; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.print("r=" + r);
        System.out.println(" end=" + (end - 1));
    }


    public static void main(String[] args) {
        int a[] = new int[]{};
        System.out.println(new Solution23().VerifySquenceOfBST(a));
    }

}

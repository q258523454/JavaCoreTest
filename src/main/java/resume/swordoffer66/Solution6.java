package resume.swordoffer66;

/**
 * Created By
 * 旋转数组的最小元素
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author :   zhangj
 * @date :   2019-01-18
 */
public class Solution6 {


    public int minNumberInRotateArray(int[] array) {

        if (array == null || array.length <= 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }

        int i = 0;
        while (i + 1 < array.length && array[i] <= array[i + 1]) {
            i++;
        }
        if (i + 1 < array.length) {
            return array[i + 1];
        }

        return array[0];

    }
}

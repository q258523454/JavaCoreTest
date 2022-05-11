package resume.onlineAC.linkedlist;

import java.util.HashMap;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2022-05-10
 */
public class Solution_hasCycle_2 {
    private HashMap<ListNode, Integer> map = new HashMap<>();

    /**
     * 判断给定的链表中是否有环
     * 核心:快慢指针
     */
    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode temp = head;
        while (null != temp) {
            ListNode cur = temp;
            temp = temp.next;
            cur.next = null;
            if (null == map.get(cur)) {
                map.put(cur, -1);
            } else {
                return true;
            }
        }
        return false;
    }
}

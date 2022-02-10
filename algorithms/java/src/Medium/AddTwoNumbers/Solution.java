package Medium.AddTwoNumbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode l3 = result;
        boolean carryOver = false;

        while (l1 != null || l2 != null) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (carryOver) {
                sum++;
                carryOver = false;
            }

            if (sum >= 10) {
                sum = sum - 10;
                carryOver = true;
            }

            l3.next = new ListNode(sum);
            l3 = l3.next;
        }

        if (carryOver) {
            l3.next = new ListNode(1);
        }

        return result.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    // Ye function do sorted linked lists ko merge karta hai
    public ListNode mergetowlist(ListNode l1, ListNode l2){

        // Agar first list khatam ho gayi to second list return kar do
        if(l1 == null) return l2;

        // Agar second list khatam ho gayi to first list return kar do
        if(l2 == null) return l1;

        // Dono nodes ke values compare karo
        if(l1.val <= l2.val){

            // Agar l1 chota hai to usko result me rakho
            // aur baaki list ko recursively merge karo
            l1.next = mergetowlist(l1.next, l2);
            return l1;
        }
        else{

            // Agar l2 chota hai to usko result me rakho
            // aur baaki list ko recursively merge karo
            l2.next = mergetowlist(l1, l2.next);
            return l2;
        }
    }

    // Ye function divide and conquer approach use karta hai
    // lists array ko do parts me divide karke unko merge karta hai
    public ListNode partitionandmerge(int s, int e, ListNode[] lists){

        // Agar start index end se bada ho gaya to null return
        if(s > e) return null;

        // Agar sirf ek list bachi hai to wahi return
        if(s == e) return lists[s];

        // Middle index nikal rahe hain
        int mid = s + (e - s) / 2;

        // Left half ko merge karo
        ListNode l1 = partitionandmerge(s, mid, lists);

        // Right half ko merge karo
        ListNode l2 = partitionandmerge(mid + 1, e, lists);

        // Dono merged lists ko mergeTwoList se merge karo
        return mergetowlist(l1, l2);
    }

    public ListNode mergeKLists(ListNode[] lists) {

        // Starting index
        int s = 0;

        // Ending index
        int e = lists.length - 1;

        // Divide and conquer se sab lists merge karo
        return partitionandmerge(s, e, lists);
    }
}
// public 2073. Time Needed to Buy Tickets
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and the (n - 1)th person is at the back of the line.

// You are given a 0-indexed integer array tickets of length n where the number of tickets that the ith person would like to buy is tickets[i].

// Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has to go back to the end of the line (which happens instantaneously) in order to buy more tickets. If a person does not have any tickets left to buy, the person will leave the line.

// Return the time taken for the person initially at position k (0-indexed) to finish buying tickets.

 

// Example 1:

// Input: tickets = [2,3,2], k = 2

// Output: 6

// Explanation:

// The queue starts as [2,3,2], where the kth person is underlined.
// After the person at the front has bought a ticket, the queue becomes [3,2,1] at 1 second.
// Continuing this process, the queue becomes [2,1,2] at 2 seconds.
// Continuing this process, the queue becomes [1,2,1] at 3 seconds.
// Continuing this process, the queue becomes [2,1] at 4 seconds. Note: the person at the front left the queue.
// Continuing this process, the queue becomes [1,1] at 5 seconds.
// Continuing this process, the queue becomes [1] at 6 seconds. The kth person has bought all their tickets, so return 6.
// Example 2:

// Input: tickets = [5,1,1,1], k = 0

// Output: 8

// Explanation:

// The queue starts as [5,1,1,1], where the kth person is underlined.
// After the person at the front has bought a ticket, the queue becomes [1,1,1,4] at 1 second.
// Continuing this process for 3 seconds, the queue becomes [4] at 4 seconds.
// Continuing this process for 4 seconds, the queue becomes [] at 8 seconds. The kth person has bought all their tickets, so return 8.
 

// Constraints:

// n == tickets.length
// 1 <= n <= 100
// 1 <= tickets[i] <= 100
// 0 <= k < n timeneededtobuytickets {
    
// }
import java.util.*;
class Solution {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        if(tickets.length == 1) return tickets[0];
        boolean last=false;
        if( k == tickets.length -1) last = true;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < tickets.length ; i++) {
            list.add(tickets[i]);
        }
        // k-=1;
        int seconds  = 0;
        while(list.isEmpty() == false && list.get(k) != 0 ) {
            // System.out.println(list);
            if(k == 0 && list.get(k) == 1) return seconds + 1;
            if(list.getFirst()-1 != 0 ) list.add(list.getFirst()-1);         
            System.out.println(list);
            list.removeFirst();
            seconds++;

            k--;
            if(k<0) k = list.size() - 1;
        }
        if(last) return seconds -1;
        return seconds ;
    }

    public static void main(String[] args) {
        int[] tickets = {84,49,5,24,70,77,87,8};
        int k = 3;
        // int[] tickets = {2,3,2};
        // int k = 2;

        System.out.println(timeRequiredToBuy(tickets, k));
    }
}
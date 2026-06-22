package ProblemsOnArrays.Medium;

/*
 * Link             : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Problem          : Stock buy and sell
 * Difficulty       : Easy-Medium
 * Approach         : Linear search
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */

class StockBuySell {
    static int maxProfit(int[] prices) {
        int buy = prices[0];
        int max_profit = 0;
        for(int sell : prices){
            buy = Math.min(buy, sell);
            max_profit = Math.max(max_profit, sell-buy);
        }
        return max_profit;      
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Maximum possible profit : "+maxProfit(prices));
    }
}
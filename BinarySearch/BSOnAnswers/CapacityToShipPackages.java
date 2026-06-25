package BinarySearch.BSOnAnswers;

/*
 * Link             : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * Problem          : Capacity to ship packages within D days
 * Difficulty       : Medium
 * Approach         : Binary Search
 * Time complexity  : O(n*log(S)), where S = sum of weights
 * Space complexity : O(1)
 */

class CapacityToShipPackages {

    public static void main(String[] args){
        int[] weights = {1,2,3,1,1};
        int days = 4;
        System.out.println("Minimum weight capacity of ship : "+shipWithinDays(weights, days));
    }
    static int shipWithinDays(int[] weights, int days) {
        int min_weight = weights[0]; //min weight capacity of ship should be at least the largest weight in the weights
        int max_weight = 0;
        for (int weight : weights){
            max_weight += weight;
            if(weight>min_weight) min_weight = weight;
        }
        int least_cap = 0;
        //apply binary search from min_weight to max_weight to find least weight capacity 
        int low = min_weight;
        int high = max_weight;
        int answer = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(daysTaken(weights, mid)> days){
                //more time is being taken, then increase least_cap
                low = mid+1;
            }
            else{
                //time equals to or less than days, decrease the capacity
                answer = mid;
                high = mid-1;
            }
        } 
        return answer;
    }

    static int daysTaken(int[] weights, int cap) {
        int days = 1;
        int current = 0;

        for (int weight : weights) {
            if (current + weight > cap) {
                days++;
                current = weight;
            } else {
                current += weight;
            }
        }

        return days;
    }
}
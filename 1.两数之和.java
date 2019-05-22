import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (45.84%)
 * Likes:    5061
 * Dislikes: 0
 * Total Accepted:    352.7K
 * Total Submissions: 769.3K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 
 */
/*
 //错误方法：同样是两层循环，但没有注意到自己和自己相加的问题
 //比如：nums=[3,2,4];target=6;那么3+3=6，会返回[0,0]
 //且重复计算
class Solution {
    public int[] twoSum(int[] nums, int target) {
       for(int i=0; i<nums.length; i++)
       {
           for(int j=0; j<nums.length; j++)
           {
               if(nums[i] + nums[j] == target)
               return new int[]{i,j};
           }
       }
       return new int[]{-1,-1};
    }
}
*/

/*
//暴力方法：两层循环，所有元素两两相加，遍历一遍
//时间复杂度：n个元素，最多需要判断(n-1)+(n-2)+...+1=(n^2-n)/2
//O(n^2)
//空间复杂度：O(1)
class Solution{
    public int[] twoSum(int[] nums,int target){
        for(int i=0; i<nums.length-1; i++)
        {
            for(int j=i+1; j<nums.length; j++)
            {
                if(nums[i] + nums[j] == target )
                return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
}
*/

/*哈希表法,可以遍历两次，也可以遍历一次。
遍历两次的话，第一次遍历将所有value及key存入哈希表中，第二次遍历查找
target-nums[i]在不在哈希表中

遍历一次：一边遍历一边将value及key存入哈希表中。
时间复杂度：O(n)
空间复杂度：O(n)
注意代码中把元素当作key，把索引当作value，因为返回需要获得索引
但哈希表中没有通过value获得key的方法，所以反过来映射能够解决问题。
*/
class Solution{
    public int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0; i<nums.length; i++)
        {
            int tmp = target - nums[i];
            if(map.containsKey(tmp))
            {
                return new int[]{map.get(tmp),i};
            }
            else{
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}

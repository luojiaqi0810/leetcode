/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (32.24%)
 * Likes:    997
 * Dislikes: 0
 * Total Accepted:    118.2K
 * Total Submissions: 366.8K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 * 
 */


 /*
 声明一个long变量，讲反转后的数放入这个变量中，再判断是否在int类型中溢出
  */
//时间复杂度：O(logn)
//空间复杂度：O(1)
class Solution {
    public int reverse(int x) {
        long tmp = 0;
        while(x!=0)
        {
            tmp = tmp*10 + x%10;
            x = x/10;
        }
        if(tmp>Integer.MAX_VALUE || tmp<Integer.MIN_VALUE) 
            return 0;
        return (int)tmp;
    }
}


/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 *
 * https://leetcode-cn.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (55.86%)
 * Likes:    578
 * Dislikes: 0
 * Total Accepted:    102.9K
 * Total Submissions: 184.2K
 * Testcase Example:  '121'
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 示例 1:
 * 
 * 输入: 121
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 
 * 
 * 示例 3:
 * 
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 
 * 
 * 进阶:
 * 
 * 你能不将整数转为字符串来解决这个问题吗？
 * 
 */

 /*
 所有负数都不可能是回文。
 末尾是0的数也不是回文，除了0本身。
 思路：1.讲数字转换为字符串，检测字符串是否为回文。但需要额外空间，且题目不允许。
 2.将数字反转，按照第7题的方法，然后与原数比较
 3.只反转后一半，然后跟前一半比较。
    如何反转：按照第7题，对原数%10得到最后一位，然后原数/10去掉    最后一位，
            再继续%10得到倒数第二位，循环操作
    如何判断是否进行到一半位置了：将原数操作后的数，和得到的数，作比较，
    如果数字长度为奇数怎么办：判断revertedNum/10==原数
    */
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0)) 
            return false;
        int revertedNum = 0;
        while(x>revertedNum)
        {
            revertedNum = revertedNum*10 + x%10;
            x = x/10;
        }
        return revertedNum==x || revertedNum/10==x;
    }
}


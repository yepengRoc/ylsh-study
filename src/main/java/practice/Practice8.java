package practice;

public class Practice8 {

    /**
     * 用数组 实现规定的栈和队列
     * 栈 先进后出
     * 从尾部进。从尾部出
     *
     * 队列，先进先出
     * 满了判断
     * tail + 1 % 队列size = head 满了
     * 如果
     * tail = head 说明空了
     */

    /**
     * 取栈中的最小元素
     *
     * 用两个栈实现
     * 一个栈 存元素
     * 另外一个栈 如果为空则 直接压入元素
     * 如果不为空
     * 则取栈顶元素 比较大小，如果当前 元素小则入站，
     * 如果当前元素大，则把 取到的栈顶元素再压一次栈
     *
     * 取栈中剩余元素的 最小元素，直接 从 另外一个栈弹出即可
     */
    /**
     * 用队列实现栈结构
     * 需要两个队列
     * 每次往写队列存元素
     * 取元素的时候 把前面 n-1的元素出队 放入help队列。然后弹出剩余的一个元素
     * 然后交换 help 和写队列。
     */

    /**
     * 用栈实现队列结构
     *
     * 队列是先进先出
     *
     * 两个栈
     * 压入输入 放入写队列
     * 取数据 把写队列 弹出放入 辅助队列，从辅助队列弹出元素即可
     *
     * 如果写栈满了，入股辅助栈为空，是可以往 辅助栈 倒入一次数据
     * 如果不为空，则不能倒入数据，否则乱套了
     * 取数据的时候，如果写入栈不为空，需要倒入一次数据 到辅助栈，则取数据
     */





}

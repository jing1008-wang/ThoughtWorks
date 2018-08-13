package thoughtWorks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestThoughtWorks {
	/*
	 * 一、对道路矩阵行数和列数输入的测试，这个是可以在main函数中进行测试的
	 *测试数据：
	 *		①输入行数、列数为负数时；
	 *		②输入行数、列数超出最大范围时；
	 *		③输入行数列数为非整数时
	 *此时输入不符合要求，输出：Number out of range
	 */
	@Test
	public void checkMN() {
		assertEquals(false,new MiGong().checkMN(-1,0));
	}
	/*
	 * 二、对输入的道路网格连通性字符串的格式判断：
	 * 1、除了数字、英文逗号，英文分号，空格之外不能含有其他字符
	 * 2、开头必须为数字，结尾必须为数字
	 * 3、划分后的数字必须为非负整数
	 * 4、一组连通数据必须行相同，或者列相同才可以进行联通
	 */
	@Test
	public void checkLianTong() {
		assertEquals(false,new MiGong().checkLianTong(2, 1, 0, 2));
	}
}

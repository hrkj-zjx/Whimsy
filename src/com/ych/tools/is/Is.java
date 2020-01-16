package com.ych.tools.is;

/**
 * 2020年1月5日下午7:10:40<br>
 * 
 * @version V-1.0
 * @author QAQ
 *         <p>
 *         <h3>简介
 *         <h3>该类是一个对字符串判断的类
 */
public final class Is {

	/**
	 * 该类不允许有实例所以该类的构造为空
	 */
	private Is() {
	}

	/**
	 * 该方法用于判断传进来的字符串是否是数字
	 * 
	 * @param message 被判断的字符串信息
	 * @param falag   该标识用于规定判断模式,为 1 时表示只判断正整数,为2是表示判断是否是正数,为 -1
	 *                时表示只判断负整数,为-2时表示判断是否时负数,为 0 时判断是否是数
	 * @return 返回值是布尔类型,符合时返回true反之false
	 */
	public static boolean isNumber(String message, int flag) {
		// 判断字符串是否为空
		if (message != null && message != "") {
			// 选择判断条件
			switch (flag) {
			case -2:// 判断是否是负数
				return isNegative(message, flag);
			case -1:// 判断是否是负整数
				return isNegative(message, flag);
			case 0:// 判断是否是数
				return isNegative(message, flag) || isPositive(message, flag) ? true : false;
			case 1:// 判断是是否时正整数
				return isPositive(message, flag);
			case 2:// 判断是否是整数
				return isPositive(message, flag);
			default: {
				System.out.println("判断条件不对 ! ! !");
				return false;
			}
			}
			//
//			if (flag == -2) {
//				return isNegative(message, flag);
//			} else if (flag == -1) {
//				return isNegative(message, flag);
//			} else if (flag == 0) {
//				if (isNegative(message, flag) || isPositive(message, flag)) {
//					return true;
//				}
//			} else if (flag == 1) {
//				return isPositive(message, flag);
//			} else if (flag == 2) {
//				return isPositive(message, flag);
//			} else {
//				System.out.println("判断条件不对 ! ! !");
//				return false;
//			}
		} else
			System.out.println("被判断的字符串是空的! ! ! !");

		return false;
	}

	/**
	 * 判断指定字符串的元素是否都是正方向的数字组成
	 * 
	 * @param message 被判断的字符串信息
	 * @param flag    标识根据此表示进行相应的判断
	 * @return 返回一个布尔值,如果该字符的运输全部是数字组成返回true反之false
	 */
	private static boolean isPositive(String message, int flag) {
		// 是数字的个数
		int nums = 0;
		// 小数点的个数
		int points = 0;
		if (message != null && message != "") {
			// 讲传进来的字符串转换换成它对应元素组成的字符数组
			char[] numbers = message.toCharArray();
			// 遍历数字字符数组
			for (char num : numbers) {
				// 判断该数组的每一位元素是否是数字
				if (num >= 48 && num <= 57) {
					// 如果是数字,数字(nums)的数量加1
					nums++;
				}
				// 判断该数组的每一位元素是否是"."
				if (num == 46) {
					// 如果是点(points)的数量加1
					points++;
				}
			}

		} else
			System.out.println("被判断的字符串是空的! ! ! !");
		// 判断查询条件
		if (flag == 1 || flag == -1) {
			// 如果查询条件等于1或者-1表示数字的个数等于字符串的长度
			if (nums == message.length()) {
				// 数字长度等于字符串长度返回true
				return true;
			}
		} else if (flag == 2 || flag == -2 || flag == 0) {
			// 如果查询条件 等于2,-2或者0表示字符串中的小数点的个数大于小于1,其他字符必须都是数字,且数字数量加小数点数量等于字符串的长度
			if (points <= 1 && (nums + points) == message.length()) {
				// 如果小数点数量小于等于1且数字数量加小数点数量等于字符串长度返回true
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断字符串是否是负数、负整数
	 * 
	 * @param message 被判断的信息
	 * @param flag    判断条件
	 * @return 返回布尔值，符合返回true反之false
	 */
	private static boolean isNegative(String message, int flag) {
		// 判断字符串是否为空
		if (message != null && message != "") {
			// 不为空，判断第一位字符是否是‘-’号
			if (message.startsWith("-")) {
				// 第一位是‘-’号，拿到‘-’好后一位到结束的所有字符
				String numbers = message.substring(message.indexOf('-') + 1);
				// 判断拿到的字符集是否是数字组成或是小数组成
				// 是小数或是数字组成返回true
				return isPositive(numbers, flag);

			} else if (isPositive(message, 0)) {
				// 第一位不是‘-’号，判断字符串是不是数字或小数组成，然后提示，并返回false
				System.out.println(message + " -->这个数不是负数、负整数，而是正数、正整数。");
				return false;
			} else {
				// 如果第一位不是‘-’号，字符串也不是数字或小数组成提示并返回false
				System.out.println("您输入的数字有误");
				return false;
			}

		} else
			System.out.println("被判断的字符串是空的! ! ! !");
		return false;
	}

}

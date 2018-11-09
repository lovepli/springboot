

/**
 * Description:<br>
 * ��վ: <a href="http://www.crazyit.org">���Java����</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com<br>
 * @version 1.0<br>
 */

fun main(args: Array<String>) {
	// ��0b��0B��ͷ��������ֵ�Ƕ����Ƶ�����
	var binValue1 = 0b1010101
	var binValue2 = 0B10101110
	// ��0x��0X��ͷ��������ֵ��ʮ�����Ƶ�����
	var hexValue1 = 0x13
	var hexValue2 = 0XaF
	println("binValue1��ֵΪ��$binValue1")
	println("binValue2��ֵΪ��$binValue2")
	println("hexValue1��ֵΪ��$hexValue1")
	println("hexValue2��ֵΪ��$hexValue2")

	val oneMillion = 1_000_000
	val price = 234_234_234 // priceʵ�ʵ�ֵΪ234234234
	val android = 1234_1234 // androidʵ�ʵ�ֵΪ12341234

    print(oneMillion)
    print(price)
    print(android)
}
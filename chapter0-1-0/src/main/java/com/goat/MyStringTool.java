package com.goat;

import java.nio.charset.StandardCharsets;

/**
 * Created by 64274 on 2018/7/11.
 *
 * @author ɽ������
 * @Description: TODO
 * @date 2018/7/11---9:54
 */
public class MyStringTool {
    private MyStringTool() { }

    /**
         * @Description: �������������ַ�������ָ�����Ƚ��зָ�
         * @author: �
         * @Param: 1234567890    MyStringTool.StrSplit(marks,3);
         * @Return:  123,456,789
         * @Date:   2018/7/11
    */
    public static String[] StrSplit(String str, int len){
        int length = str.length() / len;
        String[] shcuy = new String[length];
        for (int i = 0; i < length; i++){
            shcuy[i] = str.substring(0,len);
            str = str.substring(len);
        }
        return shcuy;
    }

    /**
         * @Description: ����������4 �ֽ�(8λ)�ַ���     ÿ n ���ֽڵ��� ������ n ���ȱ����ܱ� �����ַ����ĳ������� �������ݶ�ʧ��
         * @author: �
         * @Param:   String ret = MyStringTool.StrReverse("1234567890",5);  1234567890 ---- 6789012345
         * @Param:   String ret = MyStringTool.StrReverse("1234567890",2);  1234567890 ---- 9078563412
         * @Return:
         * @Date:   2018/7/11
    */
    public static String strReverse(String str,int mark) {
        StringBuilder heihei = new StringBuilder();
        for (int i = mark; i <= str.length(); i = i + mark){
            heihei.append(str.substring(str.length() - i, str.length() - i +mark));
        }
        return heihei.toString();
    }

    /**
     *
     *
     * @param b byte[] ��Ҫת�����ֽ�����
     * @return String ʮ�������ַ���
     */
    /**
         * @Description: �����������ֽ�����ת��Ϊʮ�������ַ���
         * @author: �
         * @Param:  byte[] temp = {0x7e,0x09,0x0A}; MyStringTool.bytes2hex(temp);
         * @Return:  7E090A
         * @Date:   2018/7/12
    */
    public static  String bytes2hex(byte[] b) {
        if (b == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        StringBuilder hs = new StringBuilder();
        String stmp ;
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xff);
            if (stmp.length() == 1) {
                hs.append("0"+stmp);
            } else {
                hs.append(stmp);
            }
        }
        return hs.toString().toUpperCase();
    }
    /**
     * ʮ�����ƴ�ת��Ϊbyte����
     *
     * @return the array of byte
     */
    public static final Integer MARK = 2;

    //  final��ʾ����������ܱ���д, ��Ȼstatic���������Ͳ��߱���д������, �ټ�final���Եö�����
//    public static final Byte[] hex2bytes(String hex) throws IllegalArgumentException {
    public static  Byte[] hex2bytes(String hex) throws IllegalArgumentException {
        if (hex.length() % MARK != 0) {
            throw new IllegalArgumentException();
        }
        char[] arr = hex.toCharArray();
        Byte[] b = new Byte[hex.length() / 2];
        for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
            String swap = "" + arr[i++] + arr[i];
            int byteint = Integer.parseInt(swap, 16) & 0xFF;
            b[j] = new Integer(byteint).byteValue();
        }
        return b;
    }

    /**
         * @Description: ����������(������һ�仰�����������������)
         * @author: �
         * @Param:
         * @Return:
                        src��byteԴ����
                        srcPos����ȡԴbyte������ʼλ�ã�0λ����Ч��
                        dest,��byteĿ�����飨��ȡ���ŵ����飩
                        destPos����ȡ���ŵ�������ʼλ�ã�0λ����Ч��
                        length����ȡ�����ݳ���
         * @Date:   2018/7/12
    */
//    public static String AscToInt(String temp ){  // 31323334  ���� 1234
//        try {
//            // 0x31,0x32,0x33,0x34
//            Byte[] gaga2 = hex2bytes(temp);
//            for(int i = 0;i<gaga2.length;i++){
////                if(gaga2[i]== 0){
//                    byte[] temp11  = new byte[i];
//                    System.arraycopy(gaga2, 0, temp11, 0, i);
//                    // 1234
//                    String  productNo = new String(temp11,"UTF-8");
//                    return productNo;
////                }
//            }
//
//        }
//        catch (Exception e){ System.out.println("11111111111");}
//        return "";
//    }
    /**
         * @Description: ����������(������һ�仰�����������������)
         * @author: �
         * @Param:    String ret = MyStringTool.IntToAsc("1234");
         * @Return:  31323334
         * @Date:   2018/7/12
    */
    public static String  intToAsc(String haha){
        String temp2 = "";
        try{
            // 0x31,0x32,0x33,0x34
//            // �����Ż�  ʹ�� StandardCharsets.UTF_8 ȡ�� "UTF-8"  ������ħ��ֵ����
            byte[] gaga = haha.getBytes(StandardCharsets.UTF_8);
            // "31323334"
            temp2 = bytes2hex(gaga);
        }
        catch (Exception e){}
        return temp2;
    }
}

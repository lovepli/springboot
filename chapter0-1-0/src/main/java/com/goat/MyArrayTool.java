package com.goat;

/**
 * Created by 64274 on 2018/7/8.
 *
 * @author ɽ������
 * @Description: TODO
 * @date 2018/7/8---13:16
 */
public class MyArrayTool<T>{

    private final static MyArrayTool INSTANCE = new MyArrayTool();
    public static MyArrayTool getInstance(){
        return INSTANCE;
    }
    private MyArrayTool() {} //sos ���캯��˽�л� ��ֹ���ⲿ����
    /**
         * @Description: ���������� ��ȡ��Сֵ�±�
         * @author: �
         * @Param:   int[] arrs = {2, 1, 14, 22, 18, 3, 27, 20};
         * @Return:  1
         * @Date:   2018/7/8
    */
    public static int getMin(int[] arr){
        int min = 0;
        for (int i = 1; i < arr.length; i++){
            //��min��Ϊ����ĽǱ�ʹ�á�
            if (arr[min] > arr[i])   {min = i;}
        }
        return min;
    }
    /**
     * @Description: ���������� ��ȡ���ֵ�±�
     * @author: �
     * @Param:   int[] arrs = {2, 1, 14, 22, 18, 3, 27, 20};
     * @Return:  6
     * @Date:   2018/7/8
     */
    public static int getMax(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++){
            //��max��Ϊ����ĽǱ�ʹ�á�
            if (arr[max] < arr[i])   { max = i;}
        }
        return max;
    }
    /**
     * @Description: ����������ѡ������(����)���������� ��С��������
     * @author: �
     * @Param:  Integer[] temp ={2, 1, 14, 22, 18, 3, 27, 20};
     * @Return:  1,2,3,14,18,20,22,27
     * @Date:   2018/7/8
     */
    public static  Integer[] selectSort(Integer[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] > arr[j]) {swap(arr, i, j);}
            }
        }
        return arr;
    }
    /**
         * @Description: ���������� ����һ���������� Ȼ�����ַ�����ʽ���
         * @author: �
         * @Param:  int[] arrs = {2, 1, 14, 22, 18, 3, 27, 20};
         * @Return:  2,1,14,22,18,3,27,20
         * @Date:   2018/7/8
    */
    public <T> String strPrint (T[] arrs){
        StringBuffer haha = new StringBuffer();
        for(T e:arrs){
            haha.append(e + ",");
        }
        String lolo = haha.toString();
        // ȥ�� ���һ�� �����
        lolo = lolo.substring(0,lolo.length()-1);
        return lolo;
    }

    /**
         * @Description: ����������(Ԫ��λ���û�)
         * @author: �
         * @Param:
         * @Return:
         * @Date:   2018/7/11
    */
    private static void swap(Integer[] arr, int a, int b){
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    /**
         * @Description: �����������۰����(���ֲ���)�����뱣֤��������������������ɣ������ؽ�һ��������������е�λ�á�
         * @author: �
         * @Param: int[] arrs = {2, 1, 14, 22, 18, 3, 27, 20};      int hoho1 = MyArrayTool.halfSearch(arrs,14);
         * @Return:  2
         * @Date:   2018/7/11
    */
    public static int halfSearch(int[] arr, int key){
        int start = 0, end = arr.length - 1, mid;
        int max = getMax(arr);
        int min = getMin(arr);
        //��keyֵ�������ֵ��С����Сֵ�����ز���Ԫ�ص�λ��
        if (key > arr[max]) {return max;}
        else if (key < arr[min]) {return min;}
        //whileѭ���������������ڵ�Ԫ�ؽ����ж�
        while (start <= end){
            mid = (start + end) >> 1;
            if (key > arr[mid]){
                //�ж������������ǽ���
                if (arr[0] <= arr[arr.length - 1]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            } else if (key < arr[mid]){
                if (arr[0] >= arr[arr.length - 1]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            } else {
                return mid;
            }
        }
        //���ؽ�һ��Ԫ�ز���������е�λ�á�
        return start;
    }

  /**
       * @Description: �������������鷴ת
       * @author: �
       * @Param:    byte[] byteArrs = {2, 1, 14, 22, 18, 3, 27, 20};   byte[] hoho1 = MyArrayTool.reverseArray(byteArrs);
       * @Return:   20,27,3,18,22,14,1,2
       * @Date:   2018/7/12
  */
    public static Byte[] reverseArray(byte[] Array) {
        Byte[] new_array = new Byte[Array.length];
        for (int i = 0; i < Array.length; i++) {
            // ��ת������ĵ�һ��Ԫ�ص���Դ��������һ��Ԫ�أ�
            new_array[i] = Array[Array.length - i - 1];
        }
        return new_array;
    }
}
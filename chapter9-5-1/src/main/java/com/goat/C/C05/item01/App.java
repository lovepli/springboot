package com.goat.C.C05.item01;



public class App {

	public static void main(String[] args) {
		// 声明出所有的处理节点
		Handler pm = new PM();
		Handler dm = new DM();
		Handler vp = new VP();
		// 设置链中的阶段顺序,1-->2-->3
		pm.setNext(dm);
		dm.setNext(vp);
		// 提交请求，返回结果
		Response response1 = pm.handlerMessage(new Request(1));
        System.out.println(response1);
		
		Response response2 = pm.handlerMessage(new Request(2));
        System.out.println(response2);

		Response response3 = pm.handlerMessage(new Request(3));
        System.out.println(response3);
	}

}

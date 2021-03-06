package com.goat.B.B06.item03;

/**
 * Created by 64274 on 2019/7/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/15---21:18
 */
public class Client {


    /**
     * 我们先建立一个这样的文件系统
     *    总文件夹
     *   a.txt     b.jpg     c文件夹
     *   c_1.text  c_1.rmvb    c_1.jpg
     *
     */
    public static void main(String[] args) {

        //总文件夹
        Folder root = new Folder("总文件夹");
        //向总文件夹中放入三个文件：1.txt、2.jpg、1文件夹
        Folder cFolder = new Folder("C文件夹");
        root.add(new TextFile("a.txt"));
        root.add(new ImagerFile("b.jpg"));
        root.add(cFolder);

        //向C文件夹中添加文件：c_1.txt、c_1.rmvb、c_1.jpg
        TextFile cText = new TextFile("c_1.txt");

        cFolder.add(cText);
        cFolder.add(new ImagerFile("c_1.jpg"));
        cFolder.add(new VideoFile("c_1.rmvb"));
        //遍历C文件夹
        cFolder.display();
        //将c_1.txt删除
        cFolder.remove(cText);
        System.out.println("-----------------------");
        cFolder.display();
    }
}

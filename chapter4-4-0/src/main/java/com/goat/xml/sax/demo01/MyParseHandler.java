package com.goat.xml.sax.demo01;

import com.goat.xml.bean.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 用SAX解析xml文件时需要的handler
 */
public class MyParseHandler extends DefaultHandler {

	private List<Book> list;         //存放解析到的book数组
	private Book book;               //存放当前解析的book
	private String content = null;   //存放当前节点值
	
	/**
	 * 开始解析xml文档时调用此方法
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("开始解析xml文件");
		list = new ArrayList<>();
	}
    /**
     * 开始解析节点时调用此方法
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        System.out.println("发现节点开始：" +  qName );
        //当节点名为book时,获取book的属性id
        if(qName.equals("book")){
            book = new Book();
            String id = attributes.getValue("id");//System.out.println("id值为"+id);
            book.setId(Integer.parseInt(id));
        }
    }

    /**
     *
     */
    /**
     * @Title： 此方法用来获取节点的值
     * @author fan.yang
     * @date 2019年12月2日21:37:00
     * @param ch  所有的文本内容
     * @param start 起始位置
     * @param length 长度
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        content = new String(ch, start, length);
        //收集不为空白的节点值
        if(!content.trim().equals("")){
            System.out.println("节点值为："+content);
        }
    }

    /**
     *节点解析完毕时调用此方法
     *@param qName 节点名
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        System.out.println("发现节点结束：" +  qName );
        if(qName.equals("name")){
            book.setName(content);
            //System.out.println("书名"+content);
        }else if(qName.equals("author")){
            book.setAuthor(content);
            //	System.out.println("作者"+content);
        }else if(qName.equals("year")){
            book.setYear(Integer.parseInt(content));
            //	System.out.println("年份"+content);
        }else if(qName.equals("price")){
            book.setPrice(Double.parseDouble(content));
            //	System.out.println("价格"+content);
        }else if(qName.equals("book")){			//当结束当前book解析时,将该book添加到数组后置为空，方便下一次book赋值
            list.add(book);
            book = null;
        }
    }

	/**
	 * 文档解析完成后调用此方法
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("xml文件解析完毕");
	}



	public List<Book> getBooks(){
		return list;
	}
	
}

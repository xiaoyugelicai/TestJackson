package testJackson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import com.thoughtworks.xstream.XStream;
import vo.RequestH;
import vo.RequestItem;
import vo.RequestReq;

/**
 * This class was used to test xstream converter, xstream was used to convert javabean to xml or convert xml to javabean.
 * @author hualei
 * @date May 3, 2017 9:38:40 AM
 * 
 */
public class TestXstream {
	
	private String xml;
	
	
	/**
	 * convert javabean to xml.
	 * xml 请求数据如下：
	 * <req op="sms_01send">
	 *	  <h>
	 *	    <ver>1.0</ver>
	 *	    <user>test</user>
	 *	    <pass>123</pass>
	 *	  </h>
	 *	  <items>
	 *	    <item>
	 *	      <id></id>
	 *	      <content>短信验证码</content>
	 *	      <tele>12345678901</tele>
	 *	      <model>1</model>
	 *	      <timing>2017-36-03 09:05:25</timing>
	 *	      <reply>1</reply>
	 *	      <priority>0</priority>
	 *	    </item>
	 *	  </items>
	 *	</req>
	 */
	@Test
	public void javabeanToXml(){
		RequestReq requestReq = new RequestReq();
		requestReq.setOp("sms_01send");
		
		RequestH requestH = new RequestH();
		requestH.setVer("1.0");
		requestH.setUser("test");
		requestH.setPass("123");
		
		RequestItem requestItem = new RequestItem();
		requestItem.setContent("短信验证码");
		requestItem.setId("");
		requestItem.setReply("1");
		requestItem.setModel("1");
		requestItem.setPriority("0");
		requestItem.setTele("12345678901");
		requestItem.setTiming(new SimpleDateFormat("yyyy-mm-dd hh:MM:ss").format(new Date()));
		
		List<RequestItem> items = new ArrayList<RequestItem>();
		items.add(requestItem);
		requestReq.setH(requestH);
		requestReq.setItems(items);
		
		XStream xstream = new XStream();
		// 设置 类型 别名
		xstream.alias("req", RequestReq.class);
		xstream.alias("h", RequestH.class);
		xstream.alias("item", RequestItem.class);
		// 设置 子标签 别名
		xstream.aliasField("items", RequestReq.class, "items");
		// 设置 标签属性 别名
		xstream.aliasAttribute(RequestReq.class, "op", "op");
		// javabean to xml
		xml = xstream.toXML(requestReq);
		System.out.println(xml);
	}
	
	/**
	 * convert xml to java bean.
	 */
	@Test
	public void xmlToJavabean(){
		// 给  xml 赋值
		javabeanToXml();
		XStream xStream = new XStream();
		
		// 设置 类型 别名
		xStream.alias("req", RequestReq.class);
		xStream.alias("h", RequestH.class);
		xStream.alias("item", RequestItem.class);
		// 设置 子标签 别名
		xStream.aliasField("items", RequestReq.class, "items");
		// 设置 标签属性 别名
		xStream.aliasAttribute(RequestReq.class, "op", "op");
		
		// xml to javabean
		RequestReq req = (RequestReq)xStream.fromXML(xml);
		System.out.println(req);
		// RequestReq [op=sms_01send, h=RequestH [ver=1.0, user=test, pass=123], items=[RequestItem [id=, content=短信验证码, tele=12345678901, model=1, timing=2017-58-03 09:05:22, reply=1, priority=0]]]

	}
}

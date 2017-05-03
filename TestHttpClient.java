package testJackson;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * 测试 httpClient post相关方法
 * @author hualei
 * @date May 3, 2017 11:10:15 AM
 * 
 */
public class TestHttpClient {
	
	/**
	 * 传递 键值对 数据
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void postNameValuePairData() throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String data = "data";
		String partnerId = "partnerId";
		String password = "password";
		
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("version", "1.0"));
		nameValuePairs.add(new BasicNameValuePair("partnerId", partnerId));
		nameValuePairs.add(new BasicNameValuePair("password", password));
		nameValuePairs.add(new BasicNameValuePair("xmldata", data));
		// validate 为 data + partner + password 进行 md5 加密后的结果
		nameValuePairs.add(new BasicNameValuePair("validate", md5sign(data + partnerId + password)));
		
		HttpPost httpPost = new HttpPost("url");
		UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairs);
		httpPost.setEntity(urlEncodedFormEntity);
		
		// 通过 requestConfig 配置连接超时和socket超时
		// 连接超时指 网络与服务器建立连接 超时时间
		// socket超时指 读数据 超时时间，也就是从 服务器获取响应数据需要等待的时间
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3000).setSocketTimeout(3000).build();
		httpPost.setConfig(requestConfig);
		
		// 发送请求
		CloseableHttpResponse response = httpClient.execute(httpPost);
		
		HttpEntity entity = response.getEntity();
		if(entity != null){
			System.out.println(EntityUtils.toString(entity, "utf-8"));
		}
	}
	
	/**
	 * 传递 值 数据
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@Test
	public void postValueData() throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String data = "data";
		
		HttpPost httpPost = new HttpPost("url");
		StringEntity stringEntity = new StringEntity(data, "utf-8");
		httpPost.setEntity(stringEntity);
		
		CloseableHttpResponse response = httpClient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		
		if(entity != null){
			System.out.println(EntityUtils.toString(entity));
		}
	}
	
	public static char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
	public static String md5sign(String data) {
		try {
			MessageDigest messagedigest = MessageDigest.getInstance("MD5");
			messagedigest.reset();
			messagedigest.update(data.getBytes("UTF8"));
			byte abyte0[] = messagedigest.digest();
			char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
			// 所以表示成 16 进制需要 32 个字符
			int k = 0; // 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
				// 转换成 16 进制字符的转换
				byte byte0 = abyte0[i]; // 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
				// >>> 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("获得密文时出错！");
		}
	}
			
}

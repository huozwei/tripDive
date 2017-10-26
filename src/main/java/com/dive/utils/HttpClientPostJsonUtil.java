package com.dive.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @desc   通过httpclient发送json数据
 * @author HZW
 * @date   2017年6月16日 上午9:05:05
 */
public class HttpClientPostJsonUtil {
	Logger logger = Logger.getLogger(HttpClientPostJsonUtil.class);

	/**
	 * @desc  通过post方式发送json数据
	 * @param url
	 * @param jsonParam
	 * @return
	 */
	public static JSONObject httpPost(String url,JSONObject jsonParam){
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		JSONObject returnJosn = null;
		
		try {
			//解决中文乱码
			if(null!=jsonParam){
				StringEntity entity = new StringEntity(jsonParam.toString(), "UTF-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				post.setEntity(entity);
			}
			
			//发送请求
			HttpResponse result = httpclient.execute(post);
			
			//发送成功，并得到相应
			if(result.getStatusLine().getStatusCode()==200){
				String str = "";
				
				try {
					//读取请求信息
					str = EntityUtils.toString(result.getEntity());
					returnJosn = JSONObject.fromObject(str);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnJosn;
	}
	
	
	public static void main(String[] args) {
		JSONObject jsonData = null;
		JSONArray jsonArray = new JSONArray();
		
		for (int i = 0; i < 3; i++) {
			jsonData = new JSONObject();
			jsonData.put(i, "admin"+i);
			jsonArray.add(jsonData);
		}
		System.out.println("jsonArray:"+jsonArray.toString());
		
		/*for (int j = 0; j < jsonArray.size(); j++) {
			JSONObject jsonData1 = jsonArray.getJSONObject(j);
			System.out.println("循环出来的数据为："+jsonData1);
		}*/
		
		httpPost("http://localhost:8090/tripDive/users/userlist", jsonData);
		
	}
	
}



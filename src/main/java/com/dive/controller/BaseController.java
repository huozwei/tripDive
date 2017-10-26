package com.dive.controller;

import net.sf.json.JSONObject;

/**
 * @desc
 * @author HZW
 * @date   2017年6月21日 下午2:38:46
 */
public class BaseController {
	
	/**
	 * 成功返回json
	 * @return
	 */
	public JSONObject success(){
		JSONObject json = new JSONObject();
		json.put("states", 0);
		json.put("result", "success");
		return json;
	}
}



package com.dive.wechart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dive.controller.BaseController;

/**
 * @desc
 * @author HZW
 * @date   2017年10月25日 下午4:35:18
 */
@Controller
@RequestMapping("/wechart")
public class WeChartController extends BaseController{
	Logger logger = Logger.getLogger(WeChartController.class);
	
    @RequestMapping(value="/dispose",method = RequestMethod.GET)  
    public void dispose(HttpServletRequest request, HttpServletResponse response){  
    	logger.info("进入到了微信信息处理接口。。。。。。。。。");
    	
		try {
			PrintWriter pw = response.getWriter();
			pw.write(success().toString());
		} catch (IOException e) {
			logger.info("微信返回信息失败了。。。。");
			e.printStackTrace();
		}
		
    }  
	
	
}



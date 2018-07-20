package com.lcm.springboot.configservlet;




import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lcm.springboot.servlet.WebServlet1;
/**
 * servlet集成
 * @author aaaaa
 *
 */
@Configuration//标识一个配置文件
public class ServletConfig {
	
	@Bean
	public ServletRegistrationBean<WebServlet1> setServlet()
	{
		String[] s = {"/configservlet"};
		return new ServletRegistrationBean<WebServlet1>(new WebServlet1(),s );
	}
	
}

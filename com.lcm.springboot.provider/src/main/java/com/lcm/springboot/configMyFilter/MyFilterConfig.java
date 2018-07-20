package com.lcm.springboot.configMyFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.lcm.springboot.filter.MyFilter1;


/**
 * filter配置，相当与xml里面配置
 * <bean id ="filterRegistrationBean" class="org.springframework.boot.web.servlet.FilterRegistrationBean">
 * @author aaaaa
 *
 */
@Configuration
public class MyFilterConfig {

	@Bean
	//所有url进行编码处理
	public FilterRegistrationBean<CharacterEncodingFilter> setCharacter()
	{
		
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("GBK", true);
		FilterRegistrationBean<CharacterEncodingFilter> filterRegistrationBean = new FilterRegistrationBean<CharacterEncodingFilter>(characterEncodingFilter);
		filterRegistrationBean.addUrlPatterns("/myfilter1");
	
		return filterRegistrationBean;
	}
	@Bean
	
	public FilterRegistrationBean<MyFilter1> setMyFilter()
	{
		FilterRegistrationBean<MyFilter1> filterRegistrationBean = new FilterRegistrationBean<MyFilter1>(new MyFilter1());
		
		filterRegistrationBean.addUrlPatterns("/myfilter1");
		
		return filterRegistrationBean;
	}
	
	
}

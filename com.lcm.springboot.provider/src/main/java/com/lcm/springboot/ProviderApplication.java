package com.lcm.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * SpringBootServletInitializer 打war包需要
 * @author aaaaa
 *
 */
@SpringBootApplication
@EnableDubboConfiguration

//serverlet集成
@ServletComponentScan(basePackages= {"com.lcm.springboot.servlet","com.lcm.springboot.filter"})
public class ProviderApplication
//extends SpringBootServletInitializer 
{

	/**
	 * 作用：打war包需要重写
	 */
	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(ProviderApplication.class);
	}*/

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(ProviderApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
		//SpringApplication.run(ProviderApplication.class, args);
	}
}

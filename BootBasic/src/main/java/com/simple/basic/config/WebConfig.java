package com.simple.basic.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.simple.basic.controller.TestController;

//스프링부트에서는 설정파일을 자바파일로 사용합니다
@Configuration //스프링설정파일임을 의미
//@PropertySource("classpath:/application.properties") 해당파일을 설정파일에서 참조
public class WebConfig implements WebMvcConfigurer {
	
	//ioc팩토리
	@Autowired
	private ApplicationContext applicationContext;
	
	//application.properties값을 직접 참조
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${server.port}")
	private String port;
	
//	@Bean
//	public void test() {
//		System.out.println("테스트 빈 생성");
//		System.out.println(url);
//		System.out.println(port);
//		
//		//ioc컨테이너 안에 객체수
//		int count = applicationContext.getBeanDefinitionCount();
//		System.out.println("IOC컨테이너 안에 객체수:" + count);
//		
//		//컨트롤러 빈
//		TestController t = applicationContext.getBean(TestController.class);
//		System.out.println("IOC컨테이너 안에 생성된 컨트롤러:" + t);
//		System.out.println(t.test());
//		
//		//내부적으로 만들어진 db커넥션
//		DataSource ds = applicationContext.getBean(DataSource.class);
//		try {
//			System.out.println(ds.getConnection());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}

}

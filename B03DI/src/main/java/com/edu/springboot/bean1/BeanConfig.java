package com.edu.springboot.bean1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 클래스에 설정파일의 역할을 부여하기 위해 @Configuration 어노테이션을 부착
 * 스프링 컨테이너가 구동될때 자동으로 빈이 생성되면서 내부의 코드를 실행.
 */
@Configuration	
public class BeanConfig {
	
	/*
	 * @Bean 어노테이션을 통해 자바빈을 생성한다. 이때 참조변수명은 별도의 설정이
	 * 없으므로 메서드명인 person1으로 생성된다.
	 */
	@Bean //기본 생성자 + setter 방식(자바빈 스타일)
	public Person person1() { 
		System.out.println("person1 생성됨");
		Person person = new Person();
		person.setName("성유겸");
		person.setAge(11);
		person.setNotebook(new Notebook("레노버"));
		
		return person;
	}
	
	/*
	 * 위와 동일하게 자바빈을 생성하되, name속성을 부여했으므로 해당명인
	 * person2로 생성된다.
	 */
	@Bean(name = "person2") //생성자 방식(일반 객체 생성 스타일)
	public Person ptemp() {
		System.out.println("person2 생성됨");
		// 인수생성자를 통해 초기화
		Person person = new Person("알파고", 20, new Notebook("인텔"));
		
		return person;
	}
}

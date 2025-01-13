package org.kjw.springcorebasic.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

	@Test
	void singletonBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
		SingletonBean sg = ac.getBean(SingletonBean.class);
		SingletonBean sg2 = ac.getBean(SingletonBean.class);
		System.out.println("singletonBean1 = " + sg);
		System.out.println("singletonBean2 = " + sg2);
		Assertions.assertThat(sg).isSameAs(sg2);
		ac.close();
	}

	@Scope("singleton")
	static class SingletonBean {
		@PostConstruct
		public void init() {
			System.out.println("SingletonBean.init");
		}

		@PreDestroy
		public void destroy() {
			System.out.println("SingletonBean.destroy");
		}
	}

}

package org.kjw.springcorebasic.scope;

import static org.assertj.core.api.Assertions.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

	@Test
	void prototypeBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
		System.out.println("find prototypeBean1");
		PrototypeBean pt = ac.getBean(PrototypeBean.class);
		System.out.println("find prototypeBean2");
		PrototypeBean pt2 = ac.getBean(PrototypeBean.class);
		System.out.println("prototypeBean1 = " + pt);
		System.out.println("prototypeBean2 = " + pt2);
		assertThat(pt).isNotSameAs(pt2);

		ac.close();
	}

	@Scope("prototype")
	static class PrototypeBean {
		@PostConstruct
		public void init() {
			System.out.println("PrototypeBean.init");
		}

		@PreDestroy
		public void destroy() {
			System.out.println("PrototypeBean.destroy");
		}
	}

}

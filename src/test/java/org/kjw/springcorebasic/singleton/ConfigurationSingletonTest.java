package org.kjw.springcorebasic.singleton;

import org.junit.jupiter.api.Test;
import org.kjw.springcorebasic.AppConfig;
import org.kjw.springcorebasic.member.MemberRepository;
import org.kjw.springcorebasic.member.MemberServiceImpl;
import org.kjw.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderSerivce -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository -> memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository1);

    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());

    }

}

package org.kjw.springcorebasic;

import org.kjw.springcorebasic.discount.DiscountPolicy;
import org.kjw.springcorebasic.discount.RateDiscountPolicy;
import org.kjw.springcorebasic.member.MemberRepository;
import org.kjw.springcorebasic.member.MemberService;
import org.kjw.springcorebasic.member.MemberServiceImpl;
import org.kjw.springcorebasic.member.MemoryMemberRepository;
import org.kjw.springcorebasic.order.OrderService;
import org.kjw.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}

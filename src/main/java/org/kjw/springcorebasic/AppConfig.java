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

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}

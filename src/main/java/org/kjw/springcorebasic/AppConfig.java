package org.kjw.springcorebasic;

import org.kjw.springcorebasic.discount.DiscountPolicy;
import org.kjw.springcorebasic.discount.FixDiscountPolicy;
import org.kjw.springcorebasic.discount.RateDiscountPolicy;
import org.kjw.springcorebasic.member.MemberRepository;
import org.kjw.springcorebasic.member.MemberService;
import org.kjw.springcorebasic.member.MemberServiceImpl;
import org.kjw.springcorebasic.member.MemoryMemberRepository;
import org.kjw.springcorebasic.order.OrderService;
import org.kjw.springcorebasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}

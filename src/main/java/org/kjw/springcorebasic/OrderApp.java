package org.kjw.springcorebasic;

import org.kjw.springcorebasic.member.Grade;
import org.kjw.springcorebasic.member.Member;
import org.kjw.springcorebasic.member.MemberService;
import org.kjw.springcorebasic.order.Order;
import org.kjw.springcorebasic.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());

    }

}

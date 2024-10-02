package org.kjw.springcorebasic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kjw.springcorebasic.member.Grade;
import org.kjw.springcorebasic.member.Member;
import org.kjw.springcorebasic.member.MemberService;
import org.kjw.springcorebasic.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}

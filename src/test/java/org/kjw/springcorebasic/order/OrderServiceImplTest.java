package org.kjw.springcorebasic.order;

import org.junit.jupiter.api.Test;
import org.kjw.springcorebasic.discount.FixDiscountPolicy;
import org.kjw.springcorebasic.member.Grade;
import org.kjw.springcorebasic.member.Member;
import org.kjw.springcorebasic.member.MemberRepository;
import org.kjw.springcorebasic.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}
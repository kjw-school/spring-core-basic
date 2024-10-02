package org.kjw.springcorebasic.order;

import org.kjw.springcorebasic.discount.DiscountPolicy;
import org.kjw.springcorebasic.discount.FixDiscountPolicy;
import org.kjw.springcorebasic.member.Member;
import org.kjw.springcorebasic.member.MemberRepository;
import org.kjw.springcorebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.disCount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}

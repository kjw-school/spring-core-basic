package org.kjw.springcorebasic.order;

import lombok.RequiredArgsConstructor;
import org.kjw.springcorebasic.discount.DiscountPolicy;
import org.kjw.springcorebasic.member.Member;
import org.kjw.springcorebasic.member.MemberRepository;
 import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;

    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.disCount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}

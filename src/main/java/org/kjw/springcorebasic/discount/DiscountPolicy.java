package org.kjw.springcorebasic.discount;

import org.kjw.springcorebasic.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인대상금액
     */
    int disCount(Member member, int price);

}

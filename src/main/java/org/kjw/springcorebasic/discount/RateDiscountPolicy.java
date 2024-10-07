package org.kjw.springcorebasic.discount;

import org.kjw.springcorebasic.member.Grade;
import org.kjw.springcorebasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int disCount(Member member, int price) {

        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}

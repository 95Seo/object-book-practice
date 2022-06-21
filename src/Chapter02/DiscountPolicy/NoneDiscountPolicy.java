package Chapter02.DiscountPolicy;

import Chapter02.Money;
import Chapter02.Screening;

// 할인 정책이 없을 시 클래스
public class NoneDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}

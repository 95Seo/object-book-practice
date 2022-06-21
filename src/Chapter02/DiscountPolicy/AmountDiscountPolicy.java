package Chapter02.DiscountPolicy;

import Chapter02.DiscountCondition.DiscountCondition;
import Chapter02.Money;
import Chapter02.Screening;

// 고정 할인 정책 클래스
public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}

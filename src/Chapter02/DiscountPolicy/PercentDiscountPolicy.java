package Chapter02.DiscountPolicy;

import Chapter02.DiscountCondition.DiscountCondition;
import Chapter02.Money;
import Chapter02.Screening;

// 비율 할인 정책 클래스
public class PercentDiscountPolicy extends DiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}

package Chapter02.DiscountPolicy;

import Chapter02.DiscountCondition.DiscountCondition;
import Chapter02.Money;
import Chapter02.Screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// DiscountPolicy들의 부모가 되는 추상 클래스(abstract class)
// 이와같이 부모 클래스에 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에게 위임하는 디자인 패턴을 TEMPLATE METHOD 패턴이라 부른다.
public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            // screening이 할인조건을 만족하면 true
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        // 만족하는 할인 조건이 없으면 0원을 반환
        return Money.ZERO;
    }

    // 추상 메서드
    abstract protected Money getDiscountAmount(Screening screening);
}

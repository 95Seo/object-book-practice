package Chapter02.DiscountCondition;

import Chapter02.Screening;

// 할인 조건 인터페이스
public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}

package Chapter05;

import java.math.BigDecimal;

// 정보 전문가(INFORMATION EXPERT) 패턴
// INFORMATION EXPERT 패턴 즉, 정보 전문가 패턴은 객체란 상태와 행동을 함께 가지는 단위라는 객체지향의 가장 기본적인 원리를 책임 할당의 관점에서 표현한 것이다.
// - 객체란 상태와 행동을 통합한 캡슐화의 단위
// - 객체의 책임과 책임을 수행하는 데 필요한 상태는 동일한 객체 안에 존재해야 한다.
// - 객체가 자신이 소유하고 있는 정보와 관련된 작업을 수행한다.
// - 정보와 행동을 최대한 가까운 곳에 위치시키기 때문에 캡슐화를 유지할 수 있다.

// 금액과 관련된 정보를 다루는 전문가 클래스
public class Money {
    public static final Money ZERO = Money.wons(0);

    private final BigDecimal amount;

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(
                BigDecimal.valueOf(percent)
        ));
    }

    public boolean isLessThan(Money other) {
        return amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }
}

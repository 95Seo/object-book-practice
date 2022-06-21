package Chapter02;

import java.math.BigDecimal;

// 금액과 관련된 다양한 계산을 구현한 클래스
public class Money {
    public static final Money ZERO = Money.wons(0);

    // 자바에서 숫자를 정밀하게 저장하고 표현하는 방법, 돈과 소수점을 다루는데 필수
    // 단점 - 느린 속도, 기본 타입보다 조금 불편한 사용법
    private final BigDecimal amount;

    public static Money wons(long amount) {
        // BigDecimal 타입을 초기화 하는데 숫자 타입을 그냥 넣으면 다른 값을 가진다.
        // new BigDecimal("0.01"); 와 같이 문자열의 형태로 넣든,
        // BigDecimal.valueOf(0.01); valueOf메서드를 사용해야 한다.
        return new Money(BigDecimal.valueOf(amount));
    }

    Money(BigDecimal amount) {
        this.amount = amount;
    }

    // BigDecimal 사칙연산이 기본타입보다 귀찮다.
    public Money plus(Money amount) {
        // 더하기 .add
        return new Money(this.amount.add(amount.amount));
    }

    public Money minus(Money amount) {
        // 빼기 .subtract
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money times(double percent) {
        // 곱하기 .multiply
        return new Money(this.amount.multiply(
                BigDecimal.valueOf(percent)
        ));
    }

    public boolean isLessThan(Money other) {
        // compareTo 두 값을 비교하여 int 값으로 반환 - 추가적으로 공부해 보자
        // 숫자 - 크다(1), 같다(0), 작다(-1)
        // 문자 - 같다(0), 그외 양/음수
        return amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }
}

package Chapter05.Movie;

import Chapter05.DiscountCondition.DiscountCondition;
import Chapter05.Money;
import Chapter05.Screening;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

// 상속을 이용한 구현
// 변경에 취약하고, 확장에 닫혀있다.
// 다형성(POLYMORPHISM) 패턴을 이용한 합성으로 리팩토링 할 수 있다. -> Chapter02의 예제

// 낮은 결합도(LOW COUPLING) 패턴
// - 변화의 영향을 줄이며 재사용성을 증가시키는 설계 패턴
// - 설계의 결정을 평가할 때 적용할 수 있는 평가 원리.
// - 불필요한 협력을 없애는 방향으로 설계를 결정해야 한다.
// - 현재의 책임 할당을 검토하거나 여러 설계 대안들이 있을 때 낮은 결합도를 유지할 수 있는 설계를 선택하라.
// Movie와 DiscountCondition은 이미 결합돼 있기 때문에 협력하게 되면 설계 전체적으로 결합도를 추가하지 않고도 협력을 완성할 수 있다.
// DiscountCondition이 Movie 이외에 다른 객체와 결합되지 않고 역할을 수행중이기 때문에 결합도가 낮다고 할 수 있다.

// 높은 응집도(HIGH COHESION) 패턴
//
// - 복잡성을 관리할 수 있는 설계 패턴, 설계를 평가할 때 적용할 수 있는 평가 원리이다.
// - 클래스가 **하나 이상의 이유로 변경**돼야 한다면 **변경의 이유를 기준으로 클래스를 분리**하라.
// - 클래스의 속성(인스턴스)을 초기화하는 시점에 **속성의 일부만 초기화** 한다면, **함께 초기화 되는 인스턴스를 기준으로 코드를 분리**하라.
// - 메서드들이 **사용하는 속성에 따라 그룹이 나뉜다면,** 이들 **그룹을 기준으로 클래스를 분리**하라.
// - 현재의 책임 할당을 검토하거나 여러 설계 대안들이 있을 때 높은 응집도를 유지할 수 있는 설계를 선택하라.
// Movie의 주된 책임은 영화 요금을 계산하는 것이다. 따라서 영화 요금을 계산하는 데 필요한 할인 조건을 판단하기 위해 Movie가 DiscountCondition과 협력하는 것은 응집도에 아무런 해도 되지 않는다.

// 항상 명심하라 설계에 정답은 없다. 더 나은 대안을 찾는다면 망설이지 말고 변경하라.
public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition ... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    abstract protected Money calculateDiscountAmount();

    protected Money getFee() {
        return fee;
    }
}

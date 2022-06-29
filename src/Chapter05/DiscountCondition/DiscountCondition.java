package Chapter05.DiscountCondition;

import Chapter05.Screening;

// 다형성(POLYMORPHISM) 패턴
// - 객체의 역할의 개념에 해당한다. 역할이란 협력 안에서 이루어 질 수 있는 대체 가능성을 의미.
// - 역할을 사용하면 객체의 구체적인 타입을 추상적으로 표현 할 수 있다.
// - 객체의 타입에 따라 변하는 행동이 있다면 타입을 분리하고 변화하는 행동을 각 타입의 책임으로 할당하라.
// - 조건적인 논리(if ~ else, switch ~ case) 대신 다형성을 이용하면 새로운 변화를 다루기 쉽게 확장에 열려 있다고 말할 수 있다.
public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}

package Chapter02;

import Chapter02.DiscountPolicy.DiscountPolicy;

import java.time.Duration;

// 영화 클래스
public class Movie {
    private String title;
    // Duration - 시간의 길이를 나타내기 위한 타입
    // Duration - 두 "시간" 사이의 길이, Period - 두 "날짜" 사이의 길이
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}

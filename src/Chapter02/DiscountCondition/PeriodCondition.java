package Chapter02.DiscountCondition;

import Chapter02.Screening;

import java.time.DayOfWeek;
import java.time.LocalTime;

// 기간 조건
public class PeriodCondition implements DiscountCondition {

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        // LocalTime과 LocalDateTime의 차이를 알아보자
        // 기간 조건과 같은요일 & 상영 시작 시간이 startTime과 비교했을때 같거나 크야 하고 & 상영 종료 시간이 endTime과 비교했을때 같거나 작아야 한다.
        // 즉, 같은 요일 & startTime <= 상영시간 <= endTime 이어야 true
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}

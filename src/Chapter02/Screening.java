package Chapter02;

import java.time.LocalDateTime;

// 영화 "상영"을 구현한 클래스
public class Screening {
    private Movie movie;
    // 순번
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    // 사영 시작 시간 반환
    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    // 순번의 일치 여부 검사
    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    // 기본 요금 반환
    public Money getMovieFee() {
        return movie.getFee();
    }
}

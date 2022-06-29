package Chapter05;

import Chapter05.Movie.Movie;

import java.time.LocalDateTime;

// 창조자(CREATOR) 패턴
// 객체를 생성할 책임을 어떤 객체에게 할당할지에 대한 지침. 어떠한 객체 A의 창조자 객체 B가 있다고 가정해 보자.
// - B가 A객체를 포함하거나 참조한다.
// - B가 A객체를 기록한다.
// - B가 A객체를 긴밀하게 사용한다.
// - B가 A객체를 초기화하는 데 필요한 데이터를 가지고 있다. (이 경우 B는 A에 대한 정보 전문가다)
// 즉, **CREATOR 패턴의 의도**는 어떤 방식으로든 생성되는 객체와 연결되거나 관련될 필요가 있는 객체에 해당 객체를 생성할 책임을 맡기는 것.

// Screening은 Reservation의 창조자 객체라 할 수 있다.
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Reservation reserve(Customer customer,int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence() {
        return sequence;
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}

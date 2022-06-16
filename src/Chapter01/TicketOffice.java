package Chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 티켓 매표소 클래스
// 티켓을 사고 팔때 쓰일 돈과 티켓들을 변수로 가짐
// getTicket() 수행 시 가장 위의 티켓 한장을 꺼내 줌
public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    // 캡슐화를 통해 TicketOffice의 자율성이 보장 되었지만
    // 전에 없던 TicketOffice와 Audience의 의존성이 추가되었다.
    // TicketOffice의 자율성을 보장할지, TicketOffice와 Audience 사이의 의존성을 제거할지 선택해야 한다.
    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

    // ... 가변인자. 즉, 여러개의 매개변수를 받을 수 있다는 것
    // 주의) 다른 파라미터와 같이 사용하는 경우 가변인자를 마지막에 작성한다.
    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    // public -> private
    private Ticket getTicket() {
        return tickets.remove(0);
    }

    // public -> private
    private void plusAmount(Long amount) {
        this.amount += amount;
    }

//    public void minusAmount(Long amount) {
//        this.amount -= amount;
//    }
}

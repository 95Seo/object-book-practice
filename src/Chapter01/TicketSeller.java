package Chapter01;

// 티켓 판매원 클래스
// 자신이 일하는 매표소를 알아야 한다.
public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    // 삭제 후 sellTo메서드 추가
//    public TicketOffice getTicketOffice() {
//        return ticketOffice;
//    }

    // 이제 더이상 Theater클래스는 TicketOffice에 접근 할 수 없다. 오직 TicketSeller만이 접근 가능하다.
    // 이처럼 개념적이나 물리적으로 객체 내부의 세부적인 사항을 감추는 것을 캡슐화 라고 한다.
    public void sellTo(Audience audience) {
        // audience 내부의 bag에 접근하지 못하게 수정해야 한다.

//        if (audience.getBag().hasInvitation()) {
//            Ticket ticket = ticketOffice.getTicket();
//            audience.getBag().setTicket(ticket);
//        } else {
//            Ticket ticket = ticketOffice.getTicket();
//            audience.getBag().minusAmount(ticket.getFee());
//            ticketOffice.plusAmount(ticket.getFee());
//            audience.getBag().setTicket(ticket);
//        }

        // 이제 TicketSeller는 Audience의 인터페이스에만 의존한다.
//        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
        // TicketOffice에 대한 의존성 제거
        ticketOffice.sellTicketTo(audience);
    }
}

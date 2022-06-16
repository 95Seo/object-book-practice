package Chapter01;

// 소극장 클래스
public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    // 티켓 판매 로직
    public void enter(Audience audience) {
        // TicketSeller와 Audience의 자율성을 높혀야 한다.
        // TicketSeller 안에 sellTo 메서드로 구현

//        if (audience.getBag().hasInvitation()) {
//            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
//            audience.getBag().setTicket(ticket);
//        } else {
//            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
//            audience.getBag().minusAmount(ticket.getFee());
//            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
//            audience.getBag().setTicket(ticket);
//        }

        // 이제 Theater는 TicketSeller의 인터페이스에만 의존한다.
        ticketSeller.sellTo(audience);
    }
}

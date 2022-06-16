package Chapter01;

// 관람객이 지닐 가방 클래스
// 가방에는 현금, 초대장, 티켓 3가지가 존재하며
// 초대장을 가진 고객은 초대장과 현금 모두를,
// 티켓을 구매해야 하는 고객은 현금만 가지고 시작한다.
public class Bag {
    public Bag(long amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    // 내부 데이터 접근 메소드를 public -> private로 변경
    private boolean hasInvitation() {
        return invitation != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

//    public boolean hasTicket() {
//        return ticket != null;
//    }

//    public void plusAmount(Long amount) {
//        this.amount += amount;
//    }
}

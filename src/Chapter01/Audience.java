package Chapter01;

// 관람객 클래스
public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    // bag에 접근 하는 메서드 삭제
//    public Bag getBag() {
//        return bag;
//    }

    public Long buy(Ticket ticket) {
//        if (bag.hasInvitation()) {
//            bag.setTicket(ticket);
//            return 0L;
//        } else {
//            bag.setTicket(ticket);
//            bag.minusAmount(ticket.getFee());
//            return ticket.getFee();
//        }

        return bag.hold(ticket);
    }
}

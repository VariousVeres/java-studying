package training.tries;

import org.junit.Test;

class Order {
    private String firstName, lastName, email;
    int orderId, eventId, ticketId;
    VaccinationStatus vacStatus;
    boolean isMapIncluded;

    private enum VaccinationStatus {
        VACCINATED, TESTED, RECOVERED;
    }

    private Order(OrderBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.eventId = builder.eventId;
        this.orderId = builder.orderId;
        this.ticketId = builder.ticketId;
        this.vacStatus = builder.vacStatus;
        this.isMapIncluded = builder.isMapIncluded;
    }

    public String getEmail() {
        return this.email;
    }

    static class OrderBuilder {
        private String firstName, lastName, email;
        int orderId, eventId, ticketId;
        VaccinationStatus vacStatus;
        boolean isMapIncluded;

        public OrderBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Order buildOrder() {
            return new Order(this);
        }

    }

}

public class BuilderTry {
    Order order = new Order.OrderBuilder()
            .setEmail("sadasd").buildOrder();
    @Test
    public void main() {
        System.out.println(order.getEmail());
    }

}

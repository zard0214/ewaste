package uk.shef.msc8.ewaste.domain.order.statemachine.core;

import org.springframework.context.ApplicationContext;
import org.squirrelframework.foundation.fsm.annotation.*;
import uk.shef.msc8.ewaste.domain.order.entity.valueobject.Order;
import uk.shef.msc8.ewaste.domain.order.entity.valueobject.OrderEvent;
import uk.shef.msc8.ewaste.domain.order.entity.valueobject.OrderState;
import uk.shef.msc8.ewaste.domain.order.statemachine.fsm.OrderContext;

/**
 * @author Zhecheng Zhao
 * @RegistrationNo 220186627
 * @date Created in 24/02/2024 23:13
 */
@States({
        @State(name = "INIT", entryCallMethod = "entryStateInit", exitCallMethod = "exitStateInit", initialState = true),
        @State(name = "WAIT_PAY", entryCallMethod = "entryStateWaitPay", exitCallMethod = "exitStateWaitPay"),
        @State(name = "PAID", entryCallMethod = "entryStatePaid", exitCallMethod = "exitStatePaid"),
        @State(name = "SHIPPED", entryCallMethod = "entryStateShipped", exitCallMethod = "exitStateShipped"),
        @State(name = "SUCCESS", entryCallMethod = "entryStateSuccess", exitCallMethod = "exitStateSuccess"),
        @State(name = "COMPLETE", entryCallMethod = "entryStateComplete", exitCallMethod = "exitStateComplete")
})
@Transitions(value = {
        @Transit(from = "INIT", to = "WAIT_PAY", on = "CREATE", callMethod = "create"),
        @Transit(from = "WAIT_PAY", to = "PAID", on = "PAY", callMethod = "pay"),
        @Transit(from = "PAID", to = "SHIPPED", on = "DELIVERY", callMethod = "delivery"),
        @Transit(from = "SHIPPED", to = "SUCCESS", on = "RECEIVED", callMethod = "receive"),
        @Transit(from = "SUCCESS", to = "COMPLETE", on = "COMPLETE", callMethod = "complete")
})
@StateMachineParameters(stateType = OrderState.class, eventType = OrderEvent.class, contextType = OrderContext.class)
public class OrderStateMachine extends BaseOrderStateMachine  {


    public OrderStateMachine(ApplicationContext applicationContext) {
        super(applicationContext);
    }

    @Override
    protected void afterTransitionCompleted(Object fromState, Object toState, Object event, Object context) {
        if (fromState instanceof OrderState && toState instanceof OrderState) {
            OrderContext orderContext = (OrderContext) context;
            Order order = orderContext.getOrder();
            order.setStatus(((OrderState) toState).getCode());
//            orderDTOMapper.updateById(order);
        }
    }

    public void create(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
        System.out.println("create");
    }

    public void pay(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
        System.out.println("pay");
    }

    public void delivery(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
        System.out.println("delivery");
    }

    public void receive(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
        System.out.println("receive");
    }

    public void complete(OrderState fromState, OrderState toState, OrderEvent orderEvent, OrderContext orderContext) {
        System.out.println("complete");
    }

}

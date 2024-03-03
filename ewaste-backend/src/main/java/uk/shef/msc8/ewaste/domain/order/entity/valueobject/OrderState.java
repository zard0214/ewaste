package uk.shef.msc8.ewaste.domain.order.entity.valueobject;

/**
 * @author Zhecheng Zhao
 * @RegistrationNo 220186627
 * @date Created in 24/02/2024 23:16
 */
public enum OrderState {

    /**
     * cancel
     */
    CANCEL("CANCEL", -10),

    /**
     * init
     */
    INIT("INIT", 0),

    /**
     * WAIT_PAY
     */
    WAIT_PAY("WAIT_PAY", 10),

    /**
     * paid
     */
    PAID("PAID", 20),

    /**
     * shipped
     */
    SHIPPED("SHIPPED", 40),

    /**
     * success
     */
    SUCCESS("SUCCESS", 50),

    /**
     * complete
     */
    COMPLETE("COMPLETE", 60);

    /**
     * name
     */
    final String State;

    /**
     * type
     */
    final Integer code;

    public static OrderState getState(Integer code) {
        for (OrderState ele : OrderState.values()) {
            if (code == ele.getCode()) {
                return ele;
            }
        }
        return null;
    }

    OrderState(String state, Integer code) {
        State = state;
        this.code = code;
    }

    public String getState() {
        return State;
    }

    public Integer getCode() {
        return code;
    }
}
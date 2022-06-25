package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCommon<T> {
    private Integer code;
    private String msg;
    private T data;
    public PaymentCommon(Integer code,String msg){
        this.code=code;
        this.msg=msg;
        this.data=null;
    }
}

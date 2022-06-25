package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderCommon <T>{
    private Integer code;
    private String msg;
    private T data;
    public OrderCommon(Integer code,String msg){
        this.code=code;
        this.msg=msg;
        this.data=null;
    }
}

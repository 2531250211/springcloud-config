package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private Double money;
    private Integer status;
}

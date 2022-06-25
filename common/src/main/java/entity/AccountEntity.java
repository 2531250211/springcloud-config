package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {
    private Long id;
    private Long userId;
    private Double total;
    private Double used;
    private Double residue;


}

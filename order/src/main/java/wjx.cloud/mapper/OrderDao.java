package wjx.cloud.mapper;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import entity.OrderEntity;


import java.util.List;

public interface OrderDao {
    List<OrderEntity> queryAll();

}

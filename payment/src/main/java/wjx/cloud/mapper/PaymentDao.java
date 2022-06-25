package wjx.cloud.mapper;

import entity.PaymentEntity;

public interface PaymentDao {
    int addMsg(PaymentEntity paymentEntity);
    PaymentEntity queryById(Long id);
}

package wjx.cloud.mapper;

import entity.AccountEntity;


import java.util.List;

public interface AccountDao {
    List<AccountEntity> queryAll();
}

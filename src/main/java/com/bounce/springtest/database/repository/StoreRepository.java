package com.bounce.springtest.database.repository;

import com.bounce.springtest.database.domain.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreRepository {

    // 레파지토리에 만든 이름을 그대로 xml 파일로 가져가서 사용해야 서로 인식하여 연결가능
    // 한글자라도 다르거나 할 시 연결이 불가능해진다
    public List<Store> selectStoreList();

}

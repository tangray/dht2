package bupt.fnl.dht.dao;

import bupt.fnl.dht.pojo.Identity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IdentityMapper {

    int deleteByIdentity(Identity identity);

    int insert(Identity record);

    Identity queryByIdentity(Identity record);

    List<Identity> queryAll();

    int updateByIdentity(Identity record);


}
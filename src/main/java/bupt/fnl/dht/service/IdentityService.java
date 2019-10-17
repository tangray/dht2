package bupt.fnl.dht.service;

import bupt.fnl.dht.pojo.Identity;
import bupt.fnl.dht.service.serviceModel.IdentityServiceModel;

import java.util.List;

public interface IdentityService {

    public IdentityServiceModel queryByIdentity(Identity record);

    List<IdentityServiceModel> queryAll();

    int deleteByIdentity(Identity identity);

    int insert(Identity record);

    int updateByIdentity(Identity record);
}

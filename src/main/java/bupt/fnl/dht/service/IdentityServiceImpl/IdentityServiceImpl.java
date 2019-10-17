package bupt.fnl.dht.service.IdentityServiceImpl;

import bupt.fnl.dht.SelfDefinedException.DoubleInsertException;
import bupt.fnl.dht.SelfDefinedException.InputNullException;
import bupt.fnl.dht.SelfDefinedException.QueryNotExistException;
import bupt.fnl.dht.dao.IdentityMapper;
import bupt.fnl.dht.pojo.Identity;
import bupt.fnl.dht.service.IdentityService;
import bupt.fnl.dht.service.serviceModel.IdentityServiceModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//用AOP处理判空
@Service
public class IdentityServiceImpl implements IdentityService {
    @Autowired
    private IdentityMapper identityMapper;

    public IdentityServiceModel convertFromPojo(Identity identity) {
        IdentityServiceModel result = new IdentityServiceModel();
        BeanUtils.copyProperties(identity, result);
        return result;
    }

    public List<IdentityServiceModel> convertFromPojoList(List<Identity> list) {
        List<IdentityServiceModel> result = new ArrayList<IdentityServiceModel>();
        for (Identity i : list) {
            IdentityServiceModel temp = new IdentityServiceModel();
            BeanUtils.copyProperties(i, temp);
            result.add(temp);
        }
        return result;
    }

    public List<IdentityServiceModel> queryAll() {
        List<Identity> list = identityMapper.queryAll();
        if (list.size() == 0)
            throw new QueryNotExistException("DHT节点为空");
        return convertFromPojoList(list);
    }

    public int deleteByIdentity(Identity record) {
        isNull(record);
        return identityMapper.deleteByIdentity(record);
    }

    public int insert(Identity record) {
        isNull(record);
        if (record.getUrl() == null || "".equals(record.getUrl()))
            throw new InputNullException("映射为空");
        try {
            int result = identityMapper.insert(record);
            return result;
        } catch (Exception e) {
            throw new DoubleInsertException("标识已经存在，不可重复插入", e.getCause());
        }
    }

    public IdentityServiceModel queryByIdentity(Identity record) {
        isNull(record);
        Identity identity = identityMapper.queryByIdentity(record);
        if (identity == null || "".equals(identity.getUrl()) || identity.getUrl() == null)
            throw new QueryNotExistException("标识不存在");
        return convertFromPojo(identity);
    }

    public int updateByIdentity(Identity record) {
        isNull(record);
        if (record.getUrl() == null || "".equals(record.getUrl()))
            throw new InputNullException("更新映射为空");
        return identityMapper.updateByIdentity(record);
    }

    public void isNull(Identity record) {
        if (record.getTop() == null || record.getTop().equals("")) {
            throw new InputNullException("一级域为空");
        } else if (record.getSecond() == null || record.getSecond().equals("")) {
            throw new InputNullException("二级域为空");
        }
    }
}

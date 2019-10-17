package bupt.fnl.dht.service.IdentityServiceImpl;

import bupt.fnl.dht.dao.NodeAliveMapper;
import bupt.fnl.dht.pojo.NodeAlive;
import bupt.fnl.dht.service.NodeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NodeAliveImpl implements NodeListService {
    @Autowired
    private NodeAliveMapper nodeAliveMapper;

    @Override
    public int deleteByNodeID(NodeAlive node) {
        return nodeAliveMapper.deleteByID(node);
    }

    @Override
    public List<NodeAlive> selectAll() {
        List<NodeAlive> list = new ArrayList<NodeAlive>();
        list = nodeAliveMapper.selectAll();
        return list;
    }

    @Override
    public int insertNode(NodeAlive node) {
        return nodeAliveMapper.insert(node);
    }
}

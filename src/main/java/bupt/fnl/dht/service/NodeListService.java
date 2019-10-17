package bupt.fnl.dht.service;

import bupt.fnl.dht.pojo.NodeAlive;

import java.util.List;

public interface NodeListService {
    int deleteByNodeID(NodeAlive node);

    List<NodeAlive> selectAll();

    int insertNode(NodeAlive node);

}

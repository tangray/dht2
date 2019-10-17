package bupt.fnl.dht.service;

import bupt.fnl.dht.pojo.Identity;
import bupt.fnl.dht.utils.Node;

import java.util.List;

public interface DhtService {
    public int insert(Identity identity);

    public Identity resolve(Identity identity);

    public List<Node> queryCurrentNodeList();
}

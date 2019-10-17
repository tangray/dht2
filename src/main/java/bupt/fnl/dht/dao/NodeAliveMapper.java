package bupt.fnl.dht.dao;

import bupt.fnl.dht.pojo.NodeAlive;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NodeAliveMapper {
    int deleteByPrimaryKey(String ip);

    int deleteByID(NodeAlive node);

    int insert(NodeAlive record);

    int insertSelective(NodeAlive record);

    NodeAlive selectByPrimaryKey(String ip);

    List<NodeAlive> selectAll();

    int updateByPrimaryKeySelective(NodeAlive record);

    int updateByPrimaryKey(NodeAlive record);
}
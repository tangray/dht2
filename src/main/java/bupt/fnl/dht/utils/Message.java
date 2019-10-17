package bupt.fnl.dht.utils;

import java.io.Serializable;

// 【注意】控制组件 和 DHT节点 中的 Message类 所在的目录名必须 相同
public class Message implements Serializable {
    private static final long serialVersionUID = -5373105239993408746L;
    // 节点配置标志位（ 设置为 1 则是传输节点的初始化信息）
    private int initNode_flag;
    // 节点配置信息
    private String initInfo;
    // 五种类型：getNodeList, register, delete, modify, resolve
    private String type;
    // 标识
    private String identity;
    // 映射数据
    private String mappingData;
    // dht节点信息
    private Node[] nodeList;
    // 反馈信息
    private String feedback;

    public void setInitNode_flag(int initNode_flag) {
        this.initNode_flag = initNode_flag;
    }

    public void setInitInfo(String initInfo) {
        this.initInfo = initInfo;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setMappingData(String mappingData) {
        this.mappingData = mappingData;
    }

    public void setNodeList(Node[] nodeList) {
        this.nodeList = nodeList;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getInitNode_flag() {
        return initNode_flag;
    }

    public String getInitInfo() {
        return initInfo;
    }

    public String getType() {
        return type;
    }

    public String getIdentity() {
        return identity;
    }

    public String getMappingData() {
        return mappingData;
    }

    public Node[] getNodeList() {
        return nodeList;
    }

    public String getFeedback() {
        return feedback;
    }

}


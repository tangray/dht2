package bupt.fnl.dht.pojo;

public class NodeAlive {
    private String ip;
    private Integer nodeId;
    private String port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getNode_id() {
        return nodeId;
    }

    public void setNode_id(Integer node_id) {
        this.nodeId = node_id;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    @Override
    public String toString() {
        return "NodeID: " + nodeId +
                "  IP: " + ip +
                "  port: " + port;
    }
}
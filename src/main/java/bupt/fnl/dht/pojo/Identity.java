package bupt.fnl.dht.pojo;

import java.io.Serializable;
import java.util.Date;

public class Identity implements Serializable {
    private static final long serialVersionUID = -4435051936554426517L;
    private String top;
    private String second;
    private Date createDate;
    private Date updateDate;
    private String url;

    public String getTop() {
        return top;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setTop(String top) {
        this.top = top == null ? null : top.trim();
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second == null ? null : second.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}
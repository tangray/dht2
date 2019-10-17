package bupt.fnl.dht.controller.ViewModel;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class IdentityViewModel {
    private String url;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "解析结果[" +
                "url: " + url +
                " 创建时间：" + createDate +
                " 更新时间：" + updateDate +
                "]";
    }
}

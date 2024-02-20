package week3.entity;

import java.time.LocalDateTime;

/**
 * @author fz
 */
public class Todo {
    private int tId;        //待办事项id
    private int userId;     //用户id
    private String title;   //标题
    private String content; //内容
    private LocalDateTime ddl;    //截止日期
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //更新时间

    public Todo() {
    }

    public Todo(int userId, String title, String content, LocalDateTime ddl, LocalDateTime createTime, LocalDateTime updateTime) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.ddl = ddl;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDdl() {
        return ddl;
    }

    public void setDdl(LocalDateTime ddl) {
        this.ddl = ddl;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "tId=" + tId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", ddl=" + ddl +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

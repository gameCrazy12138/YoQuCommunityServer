package net.gupt.community.service;

import com.github.pagehelper.PageInfo;
import net.gupt.community.entity.Notification;

/**
 * ClassName  NotificationService <br/>
 * Description 通知业务成 <br/>
 *
 * @author YG
 * @version 1.0
 * @date 2019/10/20 10:49<br/>
 * @since JDK 1.8
 */
public interface NotificationService {
    /**
     * 查询通知
     *
     * @param pageNum  页码
     * @param pageSize 页面数据量
     * @param type     通知类型
     * @return type
     */
    PageInfo<Notification> getNotifications(Integer pageNum, Integer pageSize, Byte type);

    /**
     * 发送通知
     *
     * @param notification 通知实体类
     * @return int
     */
    int postNotification(Notification notification);

    /**
     * 更新通知
     *
     * @param notification 通知对象
     * @return int
     */
    int updateNotification(Notification notification);

    /**
     * 删除通知
     *
     * @param id 主键ID
     * @return int
     */
    int deleterNotification(Integer id);
}

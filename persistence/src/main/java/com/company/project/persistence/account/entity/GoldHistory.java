package com.company.project.persistence.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 金币流水表
 * </p>
 *
 * @author nickChen
 * @since 2020-02-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoldHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户标识
     */
    private Long userPid;

    /**
     * 金币
     */
    private Integer gold;

    /**
     * business_id
     */
    private String businessId;

    /**
     * 事件
     */
    private String event;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 类型
     */
    private String type;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;


}

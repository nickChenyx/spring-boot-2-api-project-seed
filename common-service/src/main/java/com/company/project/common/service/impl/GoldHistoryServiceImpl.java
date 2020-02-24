package com.company.project.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.project.common.service.IGoldHistoryService;
import com.company.project.persistence.account.entity.GoldHistory;
import com.company.project.persistence.account.mapper.GoldHistoryMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 金币流水表 服务实现类
 * </p>
 *
 * @author nickChen
 * @since 2020-02-23
 */
@Service
public class GoldHistoryServiceImpl extends ServiceImpl<GoldHistoryMapper, GoldHistory> implements
        IGoldHistoryService {

}

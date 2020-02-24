CREATE TABLE `gold_history` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_pid` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户标识',
  `gold` int(10) NOT NULL DEFAULT '0' COMMENT '金币',
  `business_id` varchar(150) NOT NULL DEFAULT '' COMMENT '业务id',
  `event` varchar(255) NOT NULL DEFAULT '' COMMENT '事件',
  `order_id` varchar(150) NOT NULL DEFAULT '' COMMENT '订单号',
  `type` varchar(50) NOT NULL DEFAULT '' COMMENT '类型',
  `status` varchar(50) NOT NULL DEFAULT '' COMMENT '状态',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='金币流水表';

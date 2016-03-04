CREATE TABLE `treasure_card` (
  `id` bigint(20) unsigned NOT NULL,
  `item_id` bigint(20) unsigned NOT NULL COMMENT '夺宝项id',
  `vender_id` bigint(20) unsigned NOT NULL COMMENT '商家id',
  `sort_id` tinyint(4) NOT NULL COMMENT '分类id',
  `unique_id` varchar(200) NOT NULL COMMENT '唯一编码  商家id_卡号_密码',
  `card_number` varchar(50) DEFAULT NULL COMMENT '卡号',
  `card_password` varchar(50) DEFAULT NULL COMMENT '卡密',
  `status` tinyint(4) NOT NULL COMMENT '状态 1:未使用  2：已使用',
  `item_type` tinyint(4) NOT NULL COMMENT '夺宝分类 2. 充值卡',
  `yn` tinyint(4) NOT NULL,
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_uuid` (`unique_id`),
  KEY `idx_item_vender` (`item_id`,`vender_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='卡密表';
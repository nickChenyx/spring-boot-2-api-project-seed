package com.company.project.persistence.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.google.common.base.CaseFormat;
import javax.annotation.PostConstruct;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 此配置类负责忽略 updated_at 字段的更新，替换所有的 updated_at 的字段值为 null，然后执行 SQL。 目的是为了让 updated_at 字段完全符合其 on
 * update CURRENT_TIMESTAMP 的语义
 *
 * @author nickChen
 * @date 2019-08-10
 */
@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

    private Logger logger = LoggerFactory.getLogger(MybatisPlusMetaObjectHandler.class);

    @PostConstruct
    public void init() {
        logger.info(
                "mybatis-plus meta object handler init. while update entity, `updated_at` field will ignore");
    }

    @Override
    public void insertFill(MetaObject metaObject) {
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新时 updated_at 是由数据库填充的值
        setFieldValByName("updated_at", null, metaObject);
    }

    @Override
    public MetaObjectHandler setFieldValByName(String fieldName, Object fieldVal,
            MetaObject metaObject) {
        if (metaObject.hasSetter(fieldName) && metaObject.hasGetter(fieldName)) {
            metaObject.setValue(fieldName, fieldVal);
        } else if (metaObject.hasGetter("et")) {
            Object et = metaObject.getValue("et");
            if (et != null) {
                MetaObject etMeta = SystemMetaObject.forObject(et);
                String lowerCamelFieldName = CaseFormat.LOWER_UNDERSCORE
                        .to(CaseFormat.LOWER_CAMEL, fieldName);
                if (etMeta.hasSetter(fieldName)) {
                    etMeta.setValue(fieldName, fieldVal);
                } else if (etMeta.hasSetter(lowerCamelFieldName)) {
                    etMeta.setValue(lowerCamelFieldName, fieldVal);
                }
            }
        }

        return this;
    }
}

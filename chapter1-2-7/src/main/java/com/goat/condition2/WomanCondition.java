package com.goat.condition2;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by 64274 on 2019/2/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/4---18:45
 */
public class WomanCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return true;
    }
}

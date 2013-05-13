package com.preserve.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.sql.Types;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
public @interface Id {
	String name();
	int length() default 11;
	boolean notNull() default true;
	int dataType() default Types.INTEGER ;
	int IDStrategy() default IDStrategy.IN_CREMENT;// 默认自增长
}

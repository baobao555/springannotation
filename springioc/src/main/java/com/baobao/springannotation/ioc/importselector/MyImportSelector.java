package com.baobao.springannotation.ioc.importselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author baobao
 * @create 2020-02-09 12:02
 * @description
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 自定义逻辑返回需要导入的组件
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return 需要注册到容器中的组件全类名数组
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //不要返回null，否则会导致空指针异常
        return new String[]{"com.baobao.springannotation.ioc.bean.Blue","com.baobao.springannotation.ioc.bean.Yellow"};
    }
}

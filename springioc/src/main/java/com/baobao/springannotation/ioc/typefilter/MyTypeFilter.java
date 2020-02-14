package com.baobao.springannotation.ioc.typefilter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author baobao
 * @create 2020-02-09 11:31
 * @description 演示自定义组件扫描过滤规则
 */
public class MyTypeFilter implements TypeFilter {
    /**
     * 自定义包扫描过滤规则
     * @param metadataReader 读取到的当前正在扫描的类的信息
     * @param metadataReaderFactory 可以获取到其他任何类的信息
     * @return true表示匹配成功，需要加入到ioc容器；false表示匹配失败，不加入容器
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源（类的路径）
        Resource resource = metadataReader.getResource();

        //获取当前扫描类的类名
        String className = classMetadata.getClassName();
        System.out.println("当前扫描到的类名：" + className);
        //如果类名中包含Dao，则加入到容器中
        if (className.contains("Dao")){
            return true;
        }
        return false;
    }
}

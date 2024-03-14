package com.aks.mydefinition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Auther: zms
 * @Date: 2024/3/2 - 03 - 02 - 13:26
 * @Description: com.aks.mydefinition
 * @version: 1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition a = beanFactory.getBeanDefinition("a");
        System.out.println("设置BeanDefinition");
    }
}

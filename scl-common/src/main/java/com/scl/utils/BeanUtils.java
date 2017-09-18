package com.scl.utils;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.expression.Expression;

import java.util.HashMap;
import java.util.Map;

/**
 *  bean拷贝util
 *
 *  (1)类型不匹配，具有相同属性名，可以复制，但是不同属性不拷贝；
 *  (2)get和set方法不匹配的处理，创建拷贝的时候报错，无法拷贝任何属性(当且仅当sourceClass的get方法超过set方法时出现)
 *
 * Created by shengchenglong on 17/4/11.
 */
public class BeanUtils {

    public static Map<String, BeanCopier> map = new HashMap<String, BeanCopier>();

    public static void copyProperties(Object origin, Object destination) {
        String beanKey = generateKey(origin.getClass(), destination.getClass());

        BeanCopier copier = null;

        if(!map.containsKey(beanKey)) {
            copier = BeanCopier.create(origin.getClass(), destination.getClass(), false);
            map.put(beanKey, copier);
        } else {
            copier = map.get(beanKey);
        }

        try {
            copier.copy(origin, destination, null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static String generateKey(Class<?>class1, Class<?>class2){
        return class1.toString() + class2.toString();
    }
}

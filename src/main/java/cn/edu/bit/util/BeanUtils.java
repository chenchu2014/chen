package cn.edu.bit.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtils implements ApplicationContextAware {
	public static <T> T toBean(Class<T> tClass, Map<String, Object> map) {
		T object = null;
		try {
			object = tClass.newInstance();
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				try {
					Field field = tClass.getDeclaredField(entry.getKey()
							.toLowerCase());
					field.setAccessible(true);
					if (entry.getValue().getClass() == BigDecimal.class) {
						entry.setValue(((BigDecimal) (entry.getValue()))
								.intValue());
					}
					field.set(object, entry.getValue());
				} catch (Exception e) {
					continue;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(tClass.getSimpleName() + "实例化失败!");
		}
		return object;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		BeanUtils.applicationContext = applicationContext;
	}
}

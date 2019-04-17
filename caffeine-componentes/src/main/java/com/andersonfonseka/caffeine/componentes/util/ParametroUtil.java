package com.andersonfonseka.caffeine.componentes.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.andersonfonseka.caffeine.componentes.IComponente;
import com.andersonfonseka.caffeine.componentes.IEntrada;
import com.andersonfonseka.caffeine.componentes.IEntradaCheckbox;

public class ParametroUtil {
	
	public void atribuirParametros(IComponente componente, Map<String, String> parametros) {
		
		Field[] campos = componente.getClass().getDeclaredFields();
		
		for (Field field : campos) {
			try {
				
				List<Class> list = Arrays.asList(field.getType().getInterfaces());	
				
				if (field.getType().equals(IEntradaCheckbox.class)) {
				
					field.setAccessible(true);;
					IEntradaCheckbox obj = (IEntradaCheckbox) field.get(componente);
					Method metodoValor = obj.getClass().getMethod("setChecked", boolean.class);
					
					if (parametros.get(obj.getId()) != null) {
						metodoValor.invoke(obj, true);
					}
				
				} else if (list.contains(IEntrada.class)) {
					
					field.setAccessible(true);;
					IEntrada obj = (IEntrada) field.get(componente);
					Method metodoValor = obj.getClass().getMethod("setValor", String.class);
					
					if (parametros.get(obj.getId()) != null) {
						metodoValor.invoke(obj, parametros.get(obj.getId()));
					} else {
						metodoValor.invoke(obj, "");
					}
				}
				
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}

package com.andersonfonseka.caffeine.componentes.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.andersonfonseka.caffeine.IComponente;
import com.andersonfonseka.caffeine.IEntrada;
import com.andersonfonseka.caffeine.IEntradaCheckbox;

public class ParametroUtil {
	
	private static final Logger log = Logger.getLogger(ParametroUtil.class.getName());
	
	public void atribuirParametros(IComponente componente, Map<String, Object> parametros) {
		
		Field[] campos = componente.getClass().getDeclaredFields();
		
		for (Field field : campos) {
			try {
				
				List<Class<?>> list = Arrays.asList(field.getType().getInterfaces());	

				field.setAccessible(true);;
				
				if (field.getType().equals(IEntradaCheckbox.class)) {
					trataEntradaCheckbox(componente, parametros, field);
				} else if (list.contains(IEntrada.class)) {
					trataEntradaGenerica(componente, parametros, field);
				}
				
			} catch (Exception e) {
				log.log(Level.WARNING, e.getMessage());
			}
		}
		
		
	}

	private void trataEntradaGenerica(IComponente componente, Map<String, Object> parametros, Field field)
			throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		IEntrada obj = (IEntrada) field.get(componente);
		Method metodoValor = obj.getClass().getMethod("setValor", String.class);
		
		if (parametros.get(obj.getId()) != null) {
			metodoValor.invoke(obj, parametros.get(obj.getId()));
		} else {
			metodoValor.invoke(obj, "");
		}
	}

	private void trataEntradaCheckbox(IComponente componente, Map<String, Object> parametros, Field field)
			throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		IEntradaCheckbox obj = (IEntradaCheckbox) field.get(componente);
		Method metodoValor = obj.getClass().getMethod("setChecked", boolean.class);
		
		if (parametros.get(obj.getId()) != null) {
			metodoValor.invoke(obj, true);
		}
	}

}

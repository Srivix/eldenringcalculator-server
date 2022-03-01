package com.eldenringcalculator.config.mapper;

import org.springframework.data.domain.Page;

public interface BeanMapper extends com.devonfw.module.beanmapping.common.api.BeanMapper{

	/**
	 * Mapea el genérico de un Page en otro tipo de generico
	 * @param <T>
	 * @param source
	 * @param targetClass
	 * @return
	 */
	<T> Page<T> mapPage(Page<?> source, Class<T> targetClass);
	
}

package com.luv2code.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.HttpMethods;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

		HttpMethod[] theUnsupportedActions = { HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE };
		
		//disable HttpMethods for Product repository : PUT,POST,DELETE
		config.getExposureConfiguration().forDomainType(Product.class)
				.withItemExposure((metaData, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metaData, httpMethods) -> httpMethods.disable(theUnsupportedActions));
		
		
		//disable HttpMethods for ProductCategory repository : PUT,POST,DELETE
				config.getExposureConfiguration().forDomainType(ProductCategory.class)
						.withItemExposure((metaData, httpMethods) -> httpMethods.disable(theUnsupportedActions))
						.withCollectionExposure((metaData, httpMethods) -> httpMethods.disable(theUnsupportedActions));
				
	}
}

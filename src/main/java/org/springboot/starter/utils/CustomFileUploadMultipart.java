package org.springboot.starter.utils;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 
 * @author sandeep For large files, we cannot use Spring Boot’s default
 *         StandardServletMultipartResolver or CommonsMultipartResolver, since
 *         the server has limited resources (disk space) or memory for
 *         buffering. So we need to disable the default MultipartResolverand
 *         define our ownMultipartResolver
 *
 */

@EnableAutoConfiguration
public class CustomFileUploadMultipart {

	@Bean(name = "multipartResolver")
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(-1);
		return multipartResolver;

	}
}

package com.namix.LearningBaduk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.namix.LearningBaduk.ckeditor.Consts;

@Configuration
public class CkeditorConfig extends WebMvcConfigurationSupport {

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(600000000);
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("/WEB-INF/uploads/");
                // .addResourceLocations("file:"+ Consts.FILE_STORAGE_ROOT+"/images/");
        super.addResourceHandlers(registry);
    }

}

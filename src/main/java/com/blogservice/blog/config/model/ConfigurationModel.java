package com.blogservice.blog.config.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import lombok.Data;

@ConfigurationProperties(prefix = "blog")
@Component
@Data
public class ConfigurationModel {
	public String mail;
	public String mobile ;
}

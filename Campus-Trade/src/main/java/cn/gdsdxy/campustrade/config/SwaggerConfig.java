package cn.gdsdxy.campustrade.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// ❌ 删除 @EnableSwagger2
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi apiGroup() {
        return GroupedOpenApi.builder()
                .group("default")  // 分组名称
                .packagesToScan("cn.gdsdxy.tradingserver.controller")  // 扫描的包路径
                // .pathsToMatch("/api/**")  // 路径匹配（可选）
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        // ✅ 新版 Contact 构造方式
        Contact contact = new Contact()
                .name("加洛斯")
                .email("xxxxx@qq.com")
                .url("https://666.com");  // 建议填实际URL

        return new OpenAPI()
                .info(new Info()
                        .title("文档标题")
                        .description("文档标题的描述")
                        .version("版本1.0")
                        .contact(contact)
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0")));
    }
}
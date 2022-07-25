package com.reactor.demo.ext;

import java.util.Collections;
import java.util.Date;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * @author romic
 * @date 2022/7/25
 * 自定义构建信息
 */
@Component
public class CustomBuildInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("build", Collections.singletonMap("timestamp", new Date()));
    }
}

package com.jiema.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@ConfigurationProperties(prefix = "system")
public class SystemConfig {

    private String yimaUrl;

    public String getYimaUrl() {
        return yimaUrl;
    }

    public void setYimaUrl(String yimaUrl) {
        this.yimaUrl = yimaUrl;
    }

    @Override
    public String toString() {
        return "SystemConfig{" +
                "yimaUrl='" + yimaUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemConfig that = (SystemConfig) o;
        return Objects.equals(yimaUrl, that.yimaUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yimaUrl);
    }
}

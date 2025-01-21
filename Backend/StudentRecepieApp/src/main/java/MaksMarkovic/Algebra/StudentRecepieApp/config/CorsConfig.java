package MaksMarkovic.Algebra.StudentRecepieApp.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig {


    private static CorsConfig instance;
    private CorsConfig() {}

    public static CorsConfig getInstance() {
        if (instance == null) {
            synchronized (CorsConfig.class) {
                if (instance == null) {
                    instance = new CorsConfig();
                }
            }
        }
        return instance;
    }

    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:5173") // Reactooo portooo conectooo
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowCredentials(true);
            }
        };
    }
}

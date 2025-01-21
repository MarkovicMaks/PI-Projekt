package Config;

import MaksMarkovic.Algebra.StudentRecepieApp.config.CorsConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@DisplayName("CorsConfig Test")
public class CorsConfigTest {

    private CorsConfig corsConfig;

    @BeforeEach
    public void setUp() {
        corsConfig = CorsConfig.getInstance();
    }

    @Test
    @DisplayName("Test Singleton instance")
    public void testSingletonInstance() {
        // Given & When
        CorsConfig firstInstance = CorsConfig.getInstance();
        CorsConfig secondInstance = CorsConfig.getInstance();

        // Then
        Assertions.assertNotNull(firstInstance, "The first instance should not be null.");
        Assertions.assertNotNull(secondInstance, "The second instance should not be null.");
        Assertions.assertSame(firstInstance, secondInstance, "Both instances should be the same.");
    }

    @Test
    @DisplayName("Test corsConfigurer configuration")
    public void testCorsConfigurerConfiguration() {
        // Given
        WebMvcConfigurer configurer = corsConfig.corsConfigurer();

        // When
        CorsRegistry registry = new CorsRegistry();
        configurer.addCorsMappings(registry);

        // Then
        Assertions.assertNotNull(configurer, "The WebMvcConfigurer should not be null.");
        Assertions.assertDoesNotThrow(() -> configurer.addCorsMappings(registry), "The CORS configuration should execute without exceptions.");
    }
}

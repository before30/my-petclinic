package cc.before30.petclinic.backendservice.system


import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import javax.cache.configuration.Configuration
import javax.cache.configuration.MutableConfiguration

@org.springframework.context.annotation.Configuration(proxyBeanMethods = false)
@EnableCaching
class CacheConfig {

    @Bean
    fun cacheManagerCustomizer(): JCacheManagerCustomizer {
        return JCacheManagerCustomizer {
            it.createCache("vets", createCacheConfiguration())
        }
    }

    /**
     * Create a simple configuration that enable statistics via the JCache programmatic configuration API.
     * <p>
     * Within the configuration object that is provided by the JCache API standard, there is only a very limited set of
     * configuration options. The really relevant configuration options (like the size limit) must be set via a
     * configuration mechanism that is provided by the selected JCache implementation.
     */
    private fun createCacheConfiguration(): Configuration<Any, Any> =
            MutableConfiguration<Any, Any>().setStatisticsEnabled(true)
}

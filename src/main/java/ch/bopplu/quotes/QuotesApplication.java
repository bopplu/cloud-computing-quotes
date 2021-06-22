package ch.bopplu.quotes;

import com.google.api.gax.core.CredentialsProvider;
import com.google.cloud.spring.autoconfigure.core.GcpContextAutoConfiguration;
import com.google.cloud.spring.autoconfigure.firestore.FirestoreRepositoriesAutoConfiguration;
import com.google.cloud.spring.autoconfigure.firestore.FirestoreRepositoriesAutoConfigureRegistrar;
import com.google.cloud.spring.autoconfigure.firestore.GcpFirestoreAutoConfiguration;
import com.google.cloud.spring.core.GcpEnvironmentProvider;
import com.google.cloud.spring.core.GcpProjectIdProvider;
import com.google.cloud.spring.data.firestore.FirestoreTemplate;
import com.google.cloud.spring.data.firestore.mapping.FirestoreMappingContext;
import com.google.cloud.spring.data.firestore.repository.config.EnableReactiveFirestoreRepositories;
import com.google.cloud.spring.data.firestore.repository.config.FirestoreRepositoryConfigurationExtension;
import com.google.cloud.spring.data.firestore.repository.support.FirestoreRepositoryFactoryBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.nativex.hint.JdkProxyHint;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeHint;
import org.springframework.nativex.hint.TypeHints;

@NativeHint(types = @TypeHint(types = {
    CredentialsProvider.class,
    GcpProjectIdProvider.class,
    GcpEnvironmentProvider.class
}),
    options = "--enable-url-protocols=http,https"
)
@SpringBootApplication
public class QuotesApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(QuotesApplication.class, args);
    }
    
}

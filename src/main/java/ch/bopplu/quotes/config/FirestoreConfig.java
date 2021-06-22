package ch.bopplu.quotes.config;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.spring.autoconfigure.firestore.GcpFirestoreAutoConfiguration;
import com.google.cloud.spring.autoconfigure.firestore.GcpFirestoreProperties;
import com.google.cloud.spring.core.DefaultCredentialsProvider;
import com.google.cloud.spring.core.GcpProjectIdProvider;
import com.google.cloud.spring.core.UserAgentHeaderProvider;
import com.google.cloud.spring.data.firestore.FirestoreTemplate;
import com.google.cloud.spring.data.firestore.mapping.FirestoreClassMapper;
import com.google.cloud.spring.data.firestore.mapping.FirestoreDefaultClassMapper;
import com.google.cloud.spring.data.firestore.mapping.FirestoreMappingContext;
import com.google.cloud.spring.data.firestore.transaction.ReactiveFirestoreTransactionManager;
import com.google.firestore.v1.FirestoreGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.auth.MoreCallCredentials;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.io.IOException;

@Configuration
@EnableConfigurationProperties(GcpFirestoreProperties.class)
public class FirestoreConfig {
    
    private final CredentialsProvider credentialsProvider;
    
    private static final String ROOT_PATH_FORMAT = "projects/%s/databases/(default)/documents";
    
    private static final UserAgentHeaderProvider USER_AGENT_HEADER_PROVIDER =
        new UserAgentHeaderProvider(GcpFirestoreAutoConfiguration.class);
    
    private final String projectId;
    
    private final String hostPort;
    
    private final String firestoreRootPath;
    
    public FirestoreConfig(GcpFirestoreProperties gcpFirestoreProperties, GcpProjectIdProvider projectIdProvider, CredentialsProvider credentialsProvider) throws IOException {
        this.projectId = (gcpFirestoreProperties.getProjectId() != null)
            ? gcpFirestoreProperties.getProjectId()
            : projectIdProvider.getProjectId();
    
        this.credentialsProvider = (gcpFirestoreProperties.getCredentials().hasKey()
            ? new DefaultCredentialsProvider(gcpFirestoreProperties)
            : credentialsProvider);
    
        this.hostPort = gcpFirestoreProperties.getHostPort();
        this.firestoreRootPath = String.format(ROOT_PATH_FORMAT, this.projectId);
    }
    
    
    @Bean
    public FirestoreOptions firestoreOptions() {
        return FirestoreOptions.getDefaultInstance().toBuilder()
            .setCredentialsProvider(this.credentialsProvider)
            .setProjectId(this.projectId)
            .setHeaderProvider(USER_AGENT_HEADER_PROVIDER)
            .setChannelProvider(
                InstantiatingGrpcChannelProvider.newBuilder()
                    .setEndpoint(this.hostPort)
                    .build())
            .build();
    }
    
    @Bean
    public Firestore firestore(FirestoreOptions firestoreOptions) {
        return firestoreOptions.getService();
    }
    
}

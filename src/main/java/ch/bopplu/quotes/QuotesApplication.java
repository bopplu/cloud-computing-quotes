package ch.bopplu.quotes;

import ch.bopplu.quotes.firestore.QuotesRepository;
import com.google.cloud.spring.autoconfigure.firestore.FirestoreRepositoriesAutoConfiguration;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import com.google.cloud.spring.data.firestore.SimpleFirestoreReactiveRepository;
import com.google.cloud.spring.data.firestore.mapping.FirestoreMappingContext;
import com.google.cloud.spring.data.firestore.repository.support.FirestoreRepositoryFactoryBean;
import org.springframework.aop.SpringProxy;
import org.springframework.aop.framework.Advised;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.boot.autoconfigure.data.RepositoryType;
import org.springframework.core.DecoratingProxy;
import org.springframework.nativex.hint.AccessBits;
import org.springframework.nativex.hint.JdkProxyHint;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeHint;


@NativeHint(trigger = FirestoreRepositoriesAutoConfiguration.class, types = @TypeHint(types = {ConditionalOnRepositoryType.class, RepositoryType.class, FirestoreReactiveRepository.class}))
@SpringBootApplication
public class QuotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotesApplication.class, args);
	}

}

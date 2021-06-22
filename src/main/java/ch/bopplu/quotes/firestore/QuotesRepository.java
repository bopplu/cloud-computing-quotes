package ch.bopplu.quotes.firestore;

import ch.bopplu.quotes.model.Quote;
import com.google.cloud.spring.autoconfigure.firestore.FirestoreRepositoriesAutoConfiguration;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import com.google.cloud.spring.data.firestore.FirestoreTemplate;
import com.google.cloud.spring.data.firestore.SimpleFirestoreReactiveRepository;
import com.google.cloud.spring.data.firestore.mapping.FirestoreMappingContext;
import com.google.cloud.spring.data.firestore.repository.support.FirestoreRepositoryFactoryBean;
import org.springframework.aop.SpringProxy;
import org.springframework.aop.framework.Advised;
import org.springframework.context.annotation.Bean;
import org.springframework.core.DecoratingProxy;
import org.springframework.nativex.hint.AccessBits;
import org.springframework.nativex.hint.JdkProxyHint;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeHint;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface QuotesRepository extends FirestoreReactiveRepository<Quote> {

}

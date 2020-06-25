package mx.com.teclo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	// salida de mensajes
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic", "/queue");
		config.setApplicationDestinationPrefixes("/app");
	}

	// entrada de mensajes
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").addInterceptors(getHttpHandshakeInterceptor()).setAllowedOrigins("*").withSockJS()
				.setWebSocketEnabled(false).setSessionCookieNeeded(false);

	}

	@Bean
	public HttpHandshakeInterceptor getHttpHandshakeInterceptor() {
		return new HttpHandshakeInterceptor();
	}

	@Bean
	public AuthChannelInterceptorAdapter addChannelInterceptor() {
		return new AuthChannelInterceptorAdapter();
	}

	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		registration.setInterceptors(addChannelInterceptor());
	}

}

package com.personal.bebankaccount.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TransactionsMQ {
  static final String directExchangeName = "transactions";
  static final String queueName = "transfer";

  @Bean
  DirectExchange directExchange() {
    return new DirectExchange(directExchangeName);
  }

  @Bean
  Queue queue() {
    return new Queue(queueName, false);
  }

  @Bean
  Binding binding(Queue queue, DirectExchange directExchange) {
    return BindingBuilder.bind(queue).to(directExchange).with("transfer");
  }

  @Bean
  SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(queueName);
    container.setMessageListener(listenerAdapter);
    return container;
  }

  @Bean
  MessageListenerAdapter listenerAdapter(TransactionsReceiver transactionsReceiver) {
    return new MessageListenerAdapter(transactionsReceiver, "transfer");
  }
}

package dev.greencashew.springdependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
public class SpringDependencyInjectionInversionApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringDependencyInjectionInversionApplication.class, args);
        var transactionService = applicationContext.getBean(TransactionService.class);
        transactionService.run();
    }

    @Service // Creating bean with annotation
    record TransactionService(List<Transaction> transactions) {
        public void run() {
            transactions.forEach(Transaction::complete);
        }
    }

    interface Transaction {
        void complete();
    }

    @Component // Creating bean with annotation
    record GoldenTransaction(Seller seller, Client client) implements Transaction {
        public void complete() {
            System.out.println("GoldenTransaction between " + client.name() + " and " + seller.name() + " completed!");
        }
    }

    @Component // Creating bean with annotation
    record CryptoCurrencyTransaction(Seller seller, Client client) implements Transaction {
        public void complete() {
            System.out.println("CryptoCurrencyTransaction between " + client.name() + " and " + seller.name() + " completed!");
        }
    }

    @Configuration // Creating beans with configuration class
    static class DependencyInjectionConfiguration {
        @Bean
        Seller getSeller() {
            return new Seller("Maciej");
        }

        @Bean
        Client getClient() {
            return new Client("Wojciech");
        }
    }

    record Client(String name) {
    }

    record Seller(String name) {
    }
}











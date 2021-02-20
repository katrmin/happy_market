package ru.geekbrains.happy.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.geekbrains.happy.market.configs.AppConfig;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@PropertySource("classpath:secured.properties")

@Configuration(value = "AppConfig.class")

public class HappyMarketApplication {
	// Домашнее задание:
	// 1. Сделайте профилировщик, который подсчитывает какой метод в проекте
	// используется чаще всего
	// 2. * Попробуйте подсчитать методы какого контроллера уходит больше всего времени

	public static void main(String[] args) {
		SpringApplication.run(HappyMarketApplication.class, args);
	}
}

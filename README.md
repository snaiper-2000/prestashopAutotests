# README: Автоматизация тестового задания для Интернет-магазина

Этот репозиторий содержит автоматизированные тесты для проверки функциональности Интернет-магазина на примере задачи по разработке функционала корзины. Тесты написаны на Java с использованием фреймворка Selenide и паттерна Page Object.

## Содержание

1. [Требования](#требования)
2. [Установка](#установка)
3. [Запуск тестов](#запуск-тестов)
4. [Отчет](#отчет)

## Требования

Для запуска автотестов вам потребуется следующее:

- Java Development Kit (JDK) версии 17.
- Сборка проекта с помощью системы сборки (например, Maven).
- Установленный браузер (тесты написаны для Chrome).

## Установка

1. Склонируйте этот репозиторий на вашу локальную машину:

        git clone https://github.com/ваш-username/репозиторий.git


2. Установите необходимые зависимости с помощью Maven:

        mvn clean install


## Запуск тестов

Вы можете запустить тесты, используя команду Maven:

    mvn test

## Отчет

Отчет в результатов тестов находится:

      target/surefire-reports/index.html



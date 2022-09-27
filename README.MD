[![Build Status](https://travis-ci.org/VadimShein/job4j_url_shortcut.svg?branch=master)](https://travis-ci.org/VadimShein/job4j_url_shortcut)

# <p align="center">Сервис сокращенных ссылок</p>

## Описание:
Сервис сокращает пользовательские ссылки и обеспечивает безопастный удобный и быстрый доступ к ним. 
Сначала пользователь регистрируется на сайте с использованием Spring Security и получает логин и пароль, затем отправляет ссылки для конвертации. 
Количество переходов по сконвертированной ссылке подсчитывается и отображается в виде статистики.


## Используемые технологии:
* Java 13, Rest API
* Spring Boot (Data, Security, JWT authorization)
* PostgreSQL, Hibernate
* Docker, Kubernetes
* Maven


## Использование REST API
1. Регистрация сайта

![ScreenShot](./images/registration.PNG)

2. Получение токена

![ScreenShot](./images/get_token.PNG)

3. Преобразование ссылки. Необходимо в запрос добавить header
"Authorization: Bearer your_token"

![ScreenShot](./images/convert_link.PNG)

4. Перенаправление. Выполняется без авторизации

![ScreenShot](./images/redirection.PNG)

5. Получение статистики

![ScreenShot](./images/get_statistic.PNG)


## Запуск проекта:
1. Скопировать проект 
```
git clone https://github.com/VadimShein/job4j_url_shortcut
```

2. Создать базу данных urlShortcut и таблицы из файла src/main/resources/db/schema.sql

3. Собрать проект
```
mvn clean package -DskipTests
```

4. Запустить приложение, адрес по умолчанию  [http://localhost:8080/](http://localhost:8080/)
```
mvn spring-boot:run
```


## Запуск проекта с использованием Docker Compose
1. Сборка проекта в Docker image
```
docker build -t shortcut .
```

2. Запуск проекта с использованием docker-compose
```
docker-compose up
```


## Развертывание через k8s
1. Создание Secret
```
kubectl apply -f postgresdb-secret.yml
```

2. Создание deployment для Postgres
```
kubectl apply -f postgesdb-configmap.yml
```

3. Создание deployment для Spring Boot
```
kubectl apply -f spring-boot-deployment.yml
```

4. Запуск приложения
```
minikube service spring-boot-service
```


## Контакты:
[![alt-text](https://img.shields.io/badge/-telegram-grey?style=flat&logo=telegram&logoColor=white)](https://t.me/SheinVadim)
[![alt-text](https://img.shields.io/badge/@%20email-005FED?style=flat&logo=mail&logoColor=white)](mailto:shein.v94@mail.ru)

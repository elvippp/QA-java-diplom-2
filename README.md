## Задание 2: API

**Создание пользователя:**
1. создать уникального пользователя;
2. создать пользователя, который уже зарегистрирован;
3. создать пользователя и не заполнить одно из обязательных полей.
4. 
**Логин пользователя:**
1. логин под существующим пользователем,
2. логин с неверным логином и паролем.
3. 
**Изменение данных пользователя:**
1. с авторизацией,
2. без авторизации,

Для обеих ситуаций нужно проверить, что любое поле можно изменить. Для неавторизованного пользователя — ещё и то, что система вернёт ошибку.

**Создание заказа:**
1. с авторизацией,
2. без авторизации,
3. с ингредиентами,
4. без ингредиентов,
5. с неверным хешем ингредиентов.
6. 
**Получение заказов конкретного пользователя:**
1. авторизованный пользователь,
2. неавторизованный пользователь.
3. 
**Что нужно сделать**
1. Создай отдельный репозиторий для тестов API.
2. Создай Maven-проект.
3. Подключи JUnit 4, RestAssured и Allure.
4. Напиши тесты.
5. Сделай отчёт в Allure.
 
 

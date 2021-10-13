Домашняя работа №5

Схема взаимодействия:
![scheme](https://user-images.githubusercontent.com/87579523/137180824-88456acc-0efb-48fb-a348-4482b34b72a7.png)

Регистрация: Клиент передаёт учётный данные и персональную информацию на сервис users. Сервис users создаёт у себя юзера и вызывает сервис profiles для создания карточки клиента;
Авторизация: Клиент передаёт логин и пароль на сервис users - в ответ получает токен доступа;
Чтение/Изменение: Клиент с ранее полученным токеном делает запрос по id. Валидация токена происходит на сервисе profiles;

Для запуска:
1) Включить ingress: minikube addons enable ingress;
2) Развернуть объекты users: helm install chart1 chart/ --values chart/users-values.yaml;
3) Развернуть объекты profiles: helm install chart2 chart/ --values chart/profiles-values.yaml;
4) Настроить ingress: kubectl apply -f ingress.yaml

Тестирование:
newman run tests.postman_collection.json

Вариант номер 1, хороший:
1.Создаем образ
docker build -f Dockerfile_postgres -t testdoc .

2.Запускаем
docker run --name postgres-0 -e POSTGRES_PASSWORD=password -d -p 5432:5432 testdoc
скрипты на созадние юзеров и таблиц отработают за счет файла init.sql , который будет скопирован в контейнер.
Скорее всего -p 5432:5432 писать не нужно т.к. это прописано в dockerfile.

Вариант номер 2, плохой:
1. Запускаем постгресс на докере:
docker pull postgres:alpine
docker run --name postgres-0 -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine
docker exec -it bash 
su postgres
psql
2. Добавляем таблицы из файла resources/createTables.sql (нужно автоматизировать)
3. Узнаем ip сервера (docker inspect postgres-0) и Меняем ip в конфиге (нужно перенести в ресурсы на компе)
4. Наполняем данными




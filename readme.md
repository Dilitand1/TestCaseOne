1. Запускаем постгресс на докере:

docker pull postgres:alpine
docker run --name postgres-0 -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine

2. Добавляем таблицы из файла resources/createTables.sql (нужно автоматизировать)
3. Узнаем ip сервера (docker inspect postgres-0) и Меняем ip в конфиге (нужно перенести в ресурсы на компе)
4. Наполняем данными


Вариант №1 через композ:
docker-compose up --build

Вариант номер 2 вручную:
0.Компилим:
mvn clean package

1.Создаем образ
docker build -f Dockerfile_postgres -t testdoc .

2.Запускаем постгре
docker run --name postgres-0 -e POSTGRES_PASSWORD=password -d -p 5432:5432 testdoc
скрипты на созадние юзеров и таблиц отработают за счет файла init.sql , который будет скопирован в контейнер.
Скорее всего -p 5432:5432 писать не нужно т.к. это прописано в dockerfile.

3.Запускаем наше приложение и связываем его с нашей бд:
docker build -t myapp .
docker run --rm -p 8888:8888 --name myapp-0 --link postgres-0:postgres-0 myapp

подсказки:
docker pull postgres:alpine
docker run --name postgres-0 -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine
docker exec -it bash 
su postgres
psql
docker inspect postgres-0




FROM maven:3.5-jdk-8-alpine
WORKDIR /app1
COPY . /app1
RUN mvn clean install -DskipTests
EXPOSE 8092
#ADD target/todos-customer-items.jar todos-customer-items.jar
#CMD ["tail","-f","/dev/null"]
CMD [ \
"java","-jar", \
"-Dhibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect", \
"-Ddatasource.hostname=todosdb.c1j8neznq1ig.ap-south-1.rds.amazonaws.com", \
"-Ddatasource.db=todosdb", \
"-Dspring.datasource.username=root", \
"-Dspring.datasource.password=password", \
"target/todos-user-service.jar" \
]
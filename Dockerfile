FROM openjdk:8
EXPOSE 8092
ADD target/todos-customer-items.jar todos-customer-items.jar
CMD ["tail","-f","/dev/null"]
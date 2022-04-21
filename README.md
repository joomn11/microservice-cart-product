# micro-service-cart-product

**micro-service + ActiveMQ + Spring Cloud Gateway + Eureka** </br>
각각의 모듈을 붙이며 전체적인 그림을 완성해가는 프로젝트</br>

</br>

## 목차

- [전체 구조](#전체-구조)
  - [micro-service with ActiveMQ](#micro-service-with-activemq)
  - [micro-service with API Gateway](#micro-service-with-spring-cloud-gateway)
  - [micro-service with Eureka](#micro-service-with-eureka)

</br>

## 전체 구조

![arccc](resources/archi.jpg)

---

## micro-service with ActiveMQ

> 서로 독립적인 서비스들이 요청을 주고 받기 위해 사용

### architecture

<img src = "https://blog.kakaocdn.net/dn/b5o4A7/btryOj61WSw/My4eIgiqDLcK595cMyhWEk/img.png" width="60%" height="60%">

</br>

[ActiveMQ 사용법 및 Producer, Consumer 설정 정리](https://joomn11.tistory.com/122)

</br>

## micro-service with Spring Cloud Gateway

> 사용자에게 서비스 구성을 노출시키지 않고 앞단에 라우팅해주는 gateway 서버를 둔다

### architecture

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbUPDLo%2Fbtry67SKxQh%2FQ7iiDyY80LNGAttNQq0K1k%2Fimg.png)

[Spring Cloud Gateway 사용법 및 설정 정리](https://joomn11.tistory.com/123)

</br>

## micro-service with Eureka

> 물리적 주소가 유동적인 MSA 환경에 ServiceDiscovery, ServiceRegistry 기능을 제공

### architecture

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdLWnt7%2Fbtrzacs8ZEj%2FIqGg7VM5q8R3gVsoGdPkX0%2Fimg.png)

[Spring Cloud Netflix Eureka 사용법 및 설정 정리](https://joomn11.tistory.com/124)

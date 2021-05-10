## 스프링 부트를 공부하면서 발생한 에러와 그 해결법

<br>
<br>

 * > ids for this class must be manually assigned before calling save() hibernate
    * 원인 : jpa는 식별자를 할당하지 않았을 때 어떤 예외를 발생시켜야 할 지 정의하고 있지 않기 때문에
        * 해결법 : @GeneratedValue(strategy =  GenerationType.IDENTITY)


<br>
<br>

 * > <org.springframework.dao.InvalidDataAccessApiUsageException>, IllegalArgumentException
    * 원인 : 재고수량을 초과해서 주문하는 걸로 변경하는 과정에서 item 부분에서 영속성 컨텍스트가 이루어지지 않았다.
        * 해결법 : 주문한 아이템을 설정한 부분에서 em.persist(item) 추가



<br>
<br>

* > 로그 3줄만 뜨고 톰캣이 실행되지 않는 현상(war를 선택했을 때
    * 해결법 : 무료버전 일 경우 그럴 수 있음. gradle을 gradle로 실행

<br>
<br>

* > Caused by: java.lang.ClassNotFoundException: javax.xml.bind.JAXBException
    * 원인 : JAVA 11에서 에러 발생함 
        * 해결법 :  
        ```{.html}
        <dependency>
            <groupId>javax.xml.bind</groupId>
            <artifactId>jaxb-api</artifactId>
            <version>2.3.0</version>
        </dependency> 
        ```

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


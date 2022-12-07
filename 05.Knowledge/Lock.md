# Lock에 대한 이슈 정리

멀티쓰레드, 동시성 프로그래밍에서 가장 중요한 개념은 스레드(Thread)와 락(Lock)의 개념이다.

## 1. Lock이란?
    - 하나의 자원에 대해 여러 Thread가 동시에 접근하는 것을 제한하는 것
    - Synchronized, 동기화, 접근은 직렬화한다 라는 의미로 표현함
    - 멀티쓰레드 환경에서는 여러 스레드가 Heap메모리에 있는 객체나 자원을 접근할 때 동기화를 통해 접근에 제약을 두어야 한다.
        = 이유는 여러 Thread가 어떤 순서로 어떻게 동작할지 보장 할 수 없기 때문이다.
    - 결과적으로 Lock은 공유하는 자원을 잠그는 자물쇠 역할을 한다.
    - 자물쇠가 잠겨있다면 대기해야한다.

    
## 2. Lock의 주요 기능?
    - 특정 조건에 따라서 정확하게 지정한 수의 Thread만 자원에 접근할 수 있다
    - 접근하지 못한 Thread는
        = 1. 줄을 세운다
        = 2. 들어갈 수 있을때 다시 깨운다
        = 3. 깨운 Thread를 통과시킨다.
            - 접근하지 못한 Thread는 Sleep상태이며, 이 상태의 Thread를 어떤 순서로 깨워서(notifity) 통과시켜줄지 구현해야한다!!

## 3. Lock의 두 가지 종류?
    - synchronized의 경우 암묵적 락에 해당한다.
        = 동기화 하고자 하는 블럭이나 메서드를 syncronized로 감싸서 락을 거는 것
        = 어느 부분이 락인지 명확하지 않아 암묵적인 락이라고 부른다.

    - ReentrantLock 은 명시적 락에 해당한다.
        = 다중 스레드가 공유하는 주요 컬렉션 대신에 완전히 독립적인 락을 채택하여 구현하는 것을 의미한다.

## 4. Synchronized 와 ReentrantLock의 비교
    Synchronized의 경우 
    - Thread간의 Lock을 획득하는 순서를 보장해주지 않는다.
        = 이것을 unFair라고 부르며, ReentrantLock은 Fair, unFair 모두 지원한다.
    - 코드가 단일 블록의 형태를 넘어 여러가지 컬렉션이 얽혀 있을 때 명시적으로 락을 실행시킬 수 있다.
    - 대기상태의 락에 대한 인터럽트를 걸어야 할 경우 쓴다.
    - Lock을 획득하려고 대기중인 스레드들의 상태를 받아야 할 경우 사용한다.

    ReentrantLock의 경우
    - Lock을 모니터링 해야 할 경우 사용한다.
    - Lock을 획득하려는 Thread의 갯수가 많을때 사용한다(4개 이상)
    - 복잡한 동기화 코드를 작성해야하는 경우 사용한다.
    - Synchronized는 기본 키워드인 대신에, java.util.concurrent를 import 한 상태로 try/finally 블럭이 무조건 들어가기 때문에 코드가 복잡해진다.



### 번외로 java.utils.concurrent패키지에는 Lock에 대한 인터페이스 구현체가 아래와 같다.
    Interface
    - Lock
        = 1개의 Thread만 공유자원에 접근할 수 있다.
    - Read/WriteLock
        = 여러 Thread가 공유자원에 접근할 수 있다.
    - Condition
    
    Class
    - ReentrantLock
    - ReentrantReadWriteLock

### ReentrantLock 클래스의 구조
    Lock의 기능은 AbsractQueueSynchronizer를 상속받은 Sync클래스에서 확인할 수 있다
        - 이 Sync 클래스를 상속박은 FairSync와 NonFairSync를 통해 수행하게 된다.
    
```java

```

## 3. Lock을 만들어야 할 떄마다 고려해야 하는 사항은 다음과 같다.
    - Thread는 대기시킨다.
    - 대기시킨 Thread는 적절한 떄에 꺠워야한다
    - TimeOut을 어떻게 처리할 것인가
    - 등의 문제는 AbsractQueueSynchronizer가 위의 고려 사항을 모두 처리해준다

## 4. ReentrantLock 클래스 메서드
[ReentrantLock 공식 문서 주소](http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/ReentrantLock.html)

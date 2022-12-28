
![question](..%2Fimages%2F000Question.png)

<details>
<summary>질문 내용</summary>
<div markdown="1">
자바의 모든 클래스는 Object 클래스를 상속받는다. 그리고 Object 클래스에는 equals()와 hashCode()라는 메서드가 선언되어있습니다.
이 메서드들은 각각 어떤 역할일까요? 이 둘의 차이점은 무엇일까요?

</div>
</details>


우선 관련 내용들을 검색하면서 마주한 키워드들을 나열해본다.

[equals()와 hashCode()의 차이](https://youngjinmo.github.io/2021/05/equals-hashcode/)

여기서 더 나아가 equals(), hashCode()가 사용되었던 예시도 알게 되었다.

[DTO,OV의 차이와 Entity](https://youngjinmo.github.io/2021/04/dto-vo-entity/)

---

## 서두
> 내가 읽고 이해하는 과정에서 먼저 떠오른 것은 사람과 컴퓨터의 차이였다. 사람은 나 '윤종섭'을 인식할때 동명이인인지 동일인지를 파악하는게 쉽다.
> 기억, 시각, 청각 등을 활용해 비교할 수 있기 때문이다. 
> 
> 예를 들자면 윤종섭이라는 사람은 '나이가 34세이다', '성별은 남성이다', '특징으로 안경을 끼고 있다', '머리가 길다', '목소리가 가늘다' 등등 다양한 기억상의 정보를 가진 상태로
> 
> 시각, 청각 등의 감각적인 정보와 대화 등을 통한 정성적인 데이터를 비교해 판단할 수 있다. 
> 
> 이것을 컴퓨터는 어떻게 비교할 수 있을까?
> 
> 윤종섭이라는 객체(Entity)는 여러가지 속성이 있다. '이름', '성별', '나이', '외관적 특징-안경, 머리, 목소리'
> 
> 이런 정보를 저장해서 비교를 해야하는데, 우선 Entity는 __(new)__ 라는 키워드로 생성되기 때문에 단순한 '값(value)' 만 가지고 판단할 수 없다.
> 
> 주소값도 필요하기 때문에 hashCode() 메서드가 필요해지는 것.
> 
> 컴퓨터가 동일한 객체임을 인식하기 위해선, 값 뿐만 아니라 주소값도 동일해야한다.


> ## equals()와 hashCode()의 차이?
> > equls() : 객체의 값의 동일 여부(참/거짓-boolean)를 반환한다.
> 
> > hashCode() : 객체의 주소값(int)를 이용하여 객체 고유의 해시코드를 반환한다.
> >
> > equals의 경우에는 해당 값의 특징(데이터 타입, 길이 등을 비교)만 비교하기 때문에 이해하기 쉬웠다면 해시코드의 경우엔 이해가 쉽게 가지 않았다. 해시코드를 반환한다고?
> > 그래서 조금 더 알아봤다.
> >
> > [hashCode()](https://devlog-wjdrbs96.tistory.com/243)
> ![hashCode.png](..%2Fimages%2FhashCode.png)
> [참고용](C:\Users\pc\git\ToDev-TIL\DevYoon.java)
> >
> > [자료구조 해시테이블](https://mangkyu.tistory.com/102)
>![hashTable.png](..%2Fimages%2FhashTable.png)
> > 


> ## 정리
> - equals()는 객체가 가진 값이라는 데이터의 특징(타입, 길이, 값)을 비교해 참 거짓을 반환한다
> - hashCode()는 고유의 메서드 안에 구현해놓은 일련의 과정을 통해 객체의 값을 적용한 해시코드 값을 반환한다.
> - 해당 클래스 안에서 object의 무결성을 유지하기 위해서 equals()와 hashCode() 메서드를 각각 @override 하는 과정이 필요하다.

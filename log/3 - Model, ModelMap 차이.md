model과 modelmap둘다 내부적으로 Map<키와 쌍형식>인터페이스를 사용하기에 큰차이점은 없습니다.

굳이 따지자면 model은 인터페이스로 제공되며 modelmap은 LinkedHashMap을 상속받은 클래스로 제공되기에  

model->MAP인터페이스 구현체(TREEMAP등등)로의 변경이 쉬워서 코드의 유연성이 높습니다.

예)

 Map map = new TreeMap<>();

 map = new HashMap<>();

  

modelmap->LinkedHashMap을 상속받은 클래스로 사용가능합니다.
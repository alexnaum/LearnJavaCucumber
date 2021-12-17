package dictionaries;

public enum SortingEnum {
 Expensive(3),
 Chipest(2),
 Newest(1);
//@Getter
 private int val;
 SortingEnum(int val){
     this.val = val;
 }
 public int getVal(){
  return val;
 }
}

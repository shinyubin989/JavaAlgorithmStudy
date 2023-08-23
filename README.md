# JavaAlgorithmStudy
## 목차
1. [Map.Entry](#mapentry)
2. [List to String Array](#list-to-string-array)
3. [Combination](#combination)



<br><br><br><br><br>
<hr>

### Map.Entry
```java
List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
entryList.sort(((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey())));
```
Map을 keySet, valueSet만 꺼낼 수 있는게아니라, Map key,value set 자체를 담은 객체를 List로 담을수있음

<br><br>
<hr>

### List to String Array
```java
list.toArray(new String[0]);
```
<br><br>
<hr>

### Combination
```java
// 백트래킹 사용
static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
    if(r == 0) {
        print(arr, visited, n);
        return;
    } 

    for(int i=start; i<n; i++) {
        visited[i] = true;
        combination(arr, visited, i + 1, n, r - 1);
        visited[i] = false;
    }
}
```
이때 start 변수는 기준변수이고, start 인덱스를 기준으로 start 보다 작으면 뽑을 후보에서 제외, start 보다 크면 뽑을 후보가 된다.   
또한 n은 배열의 길이, r은 조합의 길이를 나타낸다.

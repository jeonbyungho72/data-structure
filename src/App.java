import learn.list.LinearLinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        LinearLinkedList<String> list = new LinearLinkedList<>();
        list.insert("자바");
        list.insert("프로그래밍");
        list.insert("진행 중");
        list.insert("JAVA", 1);
        list.insert("연결");
        list.insert("HTML", 3);
        list.insert("리스트");

        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }

        int index = list.index("HTML");
        System.out.println("GET : " + list.get(index));

        list.clear();
    }
}

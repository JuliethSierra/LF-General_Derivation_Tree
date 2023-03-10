import java.util.ArrayList;
import java.util.List;

public class Node {
    private String value;
    private List<Node> nodeList;

    public Node(String value){
        this.value = value;
        this.nodeList = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(Node node) {
        this.nodeList.add(node);
    }

    public void show (){
        System.out.println(getValue());
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenerateTree {

    private Node rootNode;
    private int height = 0;

    private String axiomaticSymbol;
    private List<String> terminalSymbolsList;
    private List<String> nonTerminalSymbolsList;

    public GenerateTree(String axiomaticSymbol, String[] terminalSymbolsList, String[] nonTerminalSymbolsList){
        this.terminalSymbolsList = new ArrayList<>();
        this.nonTerminalSymbolsList = new ArrayList<>();
        this.addTerminalSymbolsList(terminalSymbolsList);
        this.addNonTerminalSymbolsList(nonTerminalSymbolsList);
        this.axiomaticSymbol = axiomaticSymbol;
    }
    //S ->a
    //S ->Sa
    public void addTerminalSymbolsList(String[] finalSymbol){
        for (int i = 0; i < finalSymbol.length; i++) {
            terminalSymbolsList.add(finalSymbol[i]);
        }
    }
    public void addNonTerminalSymbolsList(String[] productionSymbol){
        for (int i = 0; i < productionSymbol.length; i++) {
            nonTerminalSymbolsList.add(productionSymbol[i]);
        }
    }
  /*  public void addNode(){
        if(rootNode == null){
            rootNode = new Node(axiomaticSymbol);
        }else
            this.addNode(axiomaticSymbol,rootNode);
    }*/

    public Node addNode(){
           return rootNode = new Node(axiomaticSymbol);
    }


    public void addNewNode(Node node){
        String a = "a";
        while (height <= 5){
            for (int i = 0; i < terminalSymbolsList.size(); i++){
                if(node.getValue().equals(terminalSymbolsList.get(i))){
                    node.setNodeList(new Node(nonTerminalSymbolsList.get(i)));
                    //System.out.println(node.getNodeList().get(i).getValue());
                }else if(node.getValue().contains(terminalSymbolsList.get(i))){
                    node.setNodeList(new Node(nonTerminalSymbolsList.get(i)+ a));
                    a += "a";
                    //System.out.println(node.getNodeList().get(i).getValue());
                }
                else{
                    System.out.println("Producción invalida");
                }
            }
            height++;
            if(validateSymbolNode(node) != -1){
                this.addNewNode(node.getNodeList().get(validateSymbolNode(node)));
            }
        }
        this.showNodeList(node);
    }

    public int validateSymbolNode(Node node) {
        int num =-1;
        for (int i = 0; i < node.getNodeList().size(); i++) {
            if (node.getNodeList().get(i).getValue().contains(axiomaticSymbol)) {
                //System.out.println(node.getNodeList().get(i).getValue());
                num = i;
            }
        }
        return num;
    }

    public void showNodeList(Node node){
        for (int i = 0; i < node.getNodeList().size(); i++) {
            System.out.println(node.getNodeList().get(i).getValue());
        }
    }


}

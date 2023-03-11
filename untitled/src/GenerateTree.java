import java.util.ArrayList;
import java.util.List;

public class GenerateTree {

    public Node rootNode;
    private int height = 0;

    private String axiomaticSymbol;
    private List<String> noTerminalSymbolsList;
    private List<String> terminalSymbolsList;

    public GenerateTree(String axiomaticSymbol, String[] terminalSymbolsList, String[] nonTerminalSymbolsList){
        this.noTerminalSymbolsList = new ArrayList<>();
        this.terminalSymbolsList = new ArrayList<>();
        this.addNoTerminalSymbolsList(terminalSymbolsList);
        this.addTerminalSymbolsList(nonTerminalSymbolsList);
        this.axiomaticSymbol = axiomaticSymbol;
    }

    public GenerateTree(ArrayList<String> terminalSymbolsProductionList, ArrayList<String> nonTerminalSymbolProductionList, Node initialNode){
        this.terminalSymbolsList = terminalSymbolsProductionList;
        this.noTerminalSymbolsList = nonTerminalSymbolProductionList;
        this.rootNode = initialNode;
        this.axiomaticSymbol = rootNode.getValue();
    }

    public void addNoTerminalSymbolsList(String[] finalSymbol){
        for (int i = 0; i < finalSymbol.length; i++) {
            noTerminalSymbolsList.add(finalSymbol[i]);
        }
    }
    public void addTerminalSymbolsList(String[] productionSymbol){
        for (int i = 0; i < productionSymbol.length; i++) {
            terminalSymbolsList.add(productionSymbol[i]);
        }
    }
  /**  public void addNode(){
        if(rootNode == null){
            rootNode = new Node(axiomaticSymbol);
        }else
            this.addNode(axiomaticSymbol,rootNode);
    }**/

    public Node addNode(){
           return rootNode = new Node(axiomaticSymbol);
    }


    public void addNewNode(Node node){
        String a = "a";
        while (height <= 5){
            for (int i = 0; i < noTerminalSymbolsList.size(); i++){
                if(node.getValue().equals(noTerminalSymbolsList.get(i))){
                    node.setNodeList(new Node(terminalSymbolsList.get(i)));
                    //System.out.println(node.getNodeList().get(i).getValue());
                }else if(node.getValue().contains(noTerminalSymbolsList.get(i))){
                    node.setNodeList(new Node(terminalSymbolsList.get(i)+ a));
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

    public void addNewNou(){
        for(int i = 0; i < noTerminalSymbolsList.size(); i++){
            if(rootNode.getValue().contains(noTerminalSymbolsList.get(i))){
                rootNode.setNodeList(new Node(terminalSymbolsList.get(i), 1));
                this.addNewNou(rootNode.getNodeList().get(rootNode.getNodeList().size() - 1));
            }
        }
    }
    private void addNewNou(Node rootNode){
        if(rootNode.getHeight() >= 5){
            return;
        }
        for(int i = 0; i < noTerminalSymbolsList.size(); i++){
            if(rootNode.getValue().contains(noTerminalSymbolsList.get(i))){
                String value = rootNode.getValue();
                String newValue = value.replace(noTerminalSymbolsList.get(i), terminalSymbolsList.get(i));
                rootNode.setNodeList(new Node(newValue, rootNode.getHeight() + 1));
                this.addNewNou(rootNode.getNodeList().get(rootNode.getNodeList().size() - 1));
            }
        }
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

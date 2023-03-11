import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {

        String[] terminalSymbolsList = {"S","S","S"};
        String[] nonTerminalSymbolsList = {"a","Sa","Sb"};

        GenerateTree g = new GenerateTree("S", terminalSymbolsList, nonTerminalSymbolsList);
       // g.addNewNode(g.addNode());

        Node initNode = new Node("S", 1);
        ArrayList<String>  nonTerminalSymbolProductionList = new ArrayList<>();
        nonTerminalSymbolProductionList.add("S");
        nonTerminalSymbolProductionList.add("S");
        nonTerminalSymbolProductionList.add("S");

        ArrayList<String> terminalSymbolsProductionList = new ArrayList<>();
        terminalSymbolsProductionList.add("a");
        terminalSymbolsProductionList.add("aS");
        terminalSymbolsProductionList.add("bS");

        GenerateTree g2 = new GenerateTree(terminalSymbolsProductionList, nonTerminalSymbolProductionList, initNode);
        g2.addNewNou();
        System.out.println(g2.rootNode);


    }
}

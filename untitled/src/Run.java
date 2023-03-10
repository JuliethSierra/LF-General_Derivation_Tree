public class Run {
    public static void main(String[] args) {

        String[] terminalSymbolsList = {"S","S","S"};
        String[] nonTerminalSymbolsList = {"a","Sa","Sb"};

        GenerateTree g = new GenerateTree("S", terminalSymbolsList, nonTerminalSymbolsList);
        g.addNewNode(g.addNode());
    }
}

package Section1;
import java.io.*;
import java.util.*;

/**
 * Created by FI on 11-Apr-16.
 */
public class ShortestReach {
    public static void main(String[] args) {
        InputStream stdin = null;
        try {
            stdin = System.in;
            if (args.length > 0) {
                FileInputStream stream = new FileInputStream(args[0]);
                System.setIn(stream);
            }
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            String input;
            //Scanner s = new Scanner(br.readLine());
            //SherlockAndTheBeast mySolution = new SherlockAndTheBeast(s.nextInt());
            br.readLine();
            while ((input = br.readLine()) != null) {
                ShortestReach mySolution = new ShortestReach(input.trim());
                for(int i = 0; i < mySolution.getEdgeCount();i++){
                    mySolution.addEdge(br.readLine());
                }
                System.out.println(mySolution.calculate(br.readLine()));
                //    mySolution.addValue(input);
            }
            //  System.out.println(mySolution.output().toString());
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            System.setIn(stdin);
        }
    }

    private int dataSize;
    private int nodeCount, edgeCount;
    private int lastAns = 0;

    private ArrayList<String> nodeList = new ArrayList<>();
    private HashMap<String,ArrayList<String>> nodeMap = new HashMap<>();
    private int row = 0;

    public ShortestReach(String input) {
        String dataString[]=input.trim().split("\\s+");
        nodeCount = Integer.valueOf(dataString[0]);
        edgeCount = Integer.valueOf(dataString[1]);
        for (int i = 1; i<=nodeCount ; i++){
            nodeMap.put(String.valueOf(i), new ArrayList<>());
            nodeList.add(String.valueOf(i));
        }
    }

    public void addEdge(String input){
        String dataString[]=input.trim().split("\\s+");
        String node1 = String.valueOf(dataString[0]);
        String node2 = String.valueOf(dataString[1]);
        nodeMap.get(node1).add(node2);
        nodeMap.get(node2).add(node1);
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public String calculate(String input){
        String origin = String.valueOf(input.trim());

        BreadthFirstSearch<String> breadthFirstSearch = new BreadthFirstSearch<>(new Graph<>(nodeList,nodeMap));
        HashMap<String, Integer> result = breadthFirstSearch.doSearch(origin).getDistance();
        String out = "";
        for(String key: nodeList){
            if(key.equals(input)){
                continue;
            }
            Integer distance = result.get(key);
            //out += String.format("%s:",key);
            if(distance==null){
                out += "-1 ";
            }
            else if(distance!=0){
                out += String.format("%s ", 6 * distance);
            }
        }
        return out.trim();
    }

}


class Graph<T> {
    private ArrayList<T> nodeList;
    private Map<T, ArrayList<T>> graphAdj = new HashMap<>();

    Graph(T[][] graphInput) {
        nodeList= new ArrayList<>();
        for(T[] inputRow: graphInput){
            nodeList.add(inputRow[0]);
            ArrayList<T> inputEdges= new ArrayList<>();
            inputEdges.addAll(Arrays.asList(inputRow).subList(1, inputRow.length));
            graphAdj.put(inputRow[0],inputEdges);
        }
    }

    Graph(ArrayList<T> arrayListInput,HashMap<T,ArrayList<T>> hashMapInput){
        nodeList =arrayListInput;
        graphAdj = hashMapInput;
    }

    ArrayList<T> getEdgeList(T key){
        return graphAdj.get(key);
    }

    ArrayList<T> getNodes(){
        return nodeList;
    }

    @Override
    public String toString() {
        return nodeList.toString();
    }
}

class BreadthFirstSearch<T> {
    private Graph<T> graph;


    BreadthFirstSearch(Graph<T> graph) {
        this.graph = graph;
    }

    NodeHash<T> doSearch(T searchKey){
        NodeHash<T> nodeMap = new NodeHash<>(searchKey, graph.getNodes());
        GraphQueue<T> myQueue = new GraphQueue<>();
        myQueue.put(searchKey);
        T currentNode;
        while (myQueue.hasItems()) {
            currentNode = myQueue.pop();
            for (T lookNode : graph.getEdgeList(currentNode)) {
                if (nodeMap.notVisited(lookNode)) {
                    myQueue.put(lookNode);
                }
                nodeMap.addNode(lookNode, currentNode);
            }
        }
        return nodeMap;
    }
}


class GraphQueue<T> {
    private class GraphQueueNode<S> {
        private S key;
        private GraphQueueNode<S> next = null;

        GraphQueueNode(S key) {
            this.key = key;
        }
    }

    private GraphQueueNode<T> head = null;
    private GraphQueueNode<T> tail = null;

    void put(T key) {
        GraphQueueNode<T> newNode = new GraphQueueNode<>(key);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    boolean hasItems() {
        return head != null;
    }

    T pop() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        T poppedNode = head.key;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return poppedNode;
    }
}


class NodeHash<T> {
    private HashMap<T, Node<T>> nodeMap = new HashMap<>();

    NodeHash(T searchKey, ArrayList<T> nodeList) {
        for (T nodeKey : nodeList) {
            if (nodeKey.equals(searchKey)) {
                nodeMap.put(nodeKey, new Node<>(nodeKey, 0, Boolean.TRUE));
            } else {
                nodeMap.put(nodeKey, new Node<>(nodeKey));
            }
        }
    }

    void addNode(T currentKey, T parentKey) {
        nodeMap.get(currentKey).updateNode(nodeMap.get(parentKey));
    }

    boolean notVisited(T key){
        return !nodeMap.get(key).visited;
    }

    public String toString(){
        return nodeMap.toString();
    }

    ArrayList<T> getShortestPath(T destination){
        ArrayList<T> result = new ArrayList<>();
        do {
            result.add(destination);
            destination =  nodeMap.get(destination).parent;
        }while(destination != null);
        Collections.reverse(result);
        return result;
    }

    HashMap<T, Integer> getDistance(){
        HashMap<T,Integer> nodeDistance = new HashMap<>();
        for(T key: nodeMap.keySet()){
            nodeDistance.put(key,nodeMap.get(key).distance);
        }
        return nodeDistance;
    }

    private class Node<S> {
        private S key;
        private Integer distance = null;
        private Boolean visited = false;
        private S parent;

        Node(S key, Integer distance, Boolean visited) {
            this.distance = distance;
            this.key = key;
            this.visited = visited;
        }

        Node(S key) {
            this.key = key;
        }

        void updateNode(Node<S> parentNode) {
            if (!visited) {
                visited = true;
                parent = parentNode.key;
                distance = parentNode.distance + 1;
            }
        }

        public String toString(){
            return String.format("(d %s p %s)",distance,parent);
        }
    }

}

package LeetCode;

import java.util.*;

public class EvaluateDivision {
    HashMap<String, HashMap<String,Double>> equationResults;
    HashSet<String> visited = new HashSet<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] queryResults = new double[queries.size()];
        equationResults = new HashMap<>();
        for (int i=0 ;i<equations.size() ;i++){
            List<String> equation = equations.get(i);
            equationResults.putIfAbsent(equation.get(0),new HashMap<>());
            equationResults.putIfAbsent(equation.get(1), new HashMap<>());
            equationResults.get(equation.get(0)).put(equation.get(1), values[i]);
            equationResults.get(equation.get(1)).put(equation.get(0), 1/values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            queryResults[i] = answerQuery(query.get(0),query.get(1));
        }
        return queryResults;
    }
    private double answerQuery(String A, String B){
        if (!equationResults.containsKey(A) || !equationResults.containsKey(B))return -1.0;
        if (A.equals(B))return 1.0;
        if(equationResults.get(A).containsKey(B))return equationResults.get(A).get(B);
        visited.add(A);
        double result = -1;
        for (Map.Entry<String,Double> entry:equationResults.get(A).entrySet()){
            if (visited.contains(entry.getKey()))continue;
            double subResult = answerQuery(entry.getKey(),B);
            if (subResult!=-1){
                result = entry.getValue()*subResult;
                break;
            }
        }
        visited.remove(A);
        return result;
    }

    public List<List<String>> twoDArrayToList(String[][] twoDArray) {
        List<List<String>> list = new ArrayList<>();
        for (String[] array : twoDArray) {
            list.add(new LinkedList<>(Arrays.asList(array)));
        }
        return list;
    }

    public static void main(String[] args) {
        EvaluateDivision ed = new EvaluateDivision();
        List<List<String>> equations = ed.twoDArrayToList(new String[][] {{"a","b"},{"b","c"},{"bc","cd"}});
        List<List<String>> queries = ed.twoDArrayToList(new String[][] {{"a","c"},{"c","b"},{"bc","cd"},{"cd","bc"}});
        double[] values = {1.5,2.5,5.0};
        System.out.println(Arrays.toString(ed.calcEquation(equations,values,queries)));
    }

}

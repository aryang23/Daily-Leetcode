class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> record = new Stack<>();
        
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            switch(op) {
                case "+":
                    int previous = record.pop();
                    int previousToPrevious = record.pop();
                    int score = previous + previousToPrevious;
                    record.push(previousToPrevious);
                    record.push(previous);
                    record.push(score);
                    break;
                case "D":
                    int last = record.pop();
                    record.push(last);
                    record.push(2 * last);
                    break;
                case "C":
                    record.pop();
                    break;
                default:
                    record.push(Integer.valueOf(op));
                    break;
            }
        }

            int sum = 0;
            while (!record.isEmpty()) {
                sum += record.pop();
            }

        return sum;
    }
}
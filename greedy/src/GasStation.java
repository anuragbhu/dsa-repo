public class GasStation {
    // Circular Tour Problem
    // gas-cost
    // petrol-distance
    // gas = 2 3 5 7 1 12
    // distance = 4 7 2 6 8 4
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, remaining_fuel = 0;
        for(int i = 0; i < n; i++) {
            remaining_fuel += gas[i] - cost[i];
        }
        if(remaining_fuel < 0) return -1;

        remaining_fuel = 0;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            remaining_fuel += gas[i] - cost[i];

            // answer cannot be possible upto the current index
            // as we are getting remaining_fuel as negative
            // so answer must be lies after that

            // what about the index b/w start and the current
            // not possible because from start we are getting some +ve/0 remaining_fuel
            // which would be at least 0.
            if(remaining_fuel < 0) {
                ans = i + 1;
                remaining_fuel = 0;
            }
        }
        return ans;
    }
}

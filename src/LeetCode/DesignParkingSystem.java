package LeetCode;

public class DesignParkingSystem {
    static class ParkingSystem {
        int[] parkingSpaces;
        public ParkingSystem(int big, int medium, int small) {
            parkingSpaces = new int[4];
            parkingSpaces[1] = big;
            parkingSpaces[2] = medium;
            parkingSpaces[3] = small;
        }

        public boolean addCar(int carType) {
            if (parkingSpaces[carType]>0){
                parkingSpaces[carType]--;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {

    }
}

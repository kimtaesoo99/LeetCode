class SeatManager {
    private PriorityQueue<Integer> seat;

    public SeatManager(int n) {
        seat = new PriorityQueue<>();
        for (int seatNumber = 1; seatNumber <= n; ++seatNumber) {
            seat.offer(seatNumber);
        }
    }

    public int reserve() {
        int seatNumber = seat.poll();
        return seatNumber;
    }

    public void unreserve(int seatNumber) {
        seat.offer(seatNumber);
    }
}
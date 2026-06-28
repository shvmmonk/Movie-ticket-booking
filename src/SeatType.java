public enum SeatType {
    REGULAR(300),
    PREMIUM(500);

    private int price;

    SeatType(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
}

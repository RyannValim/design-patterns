public class Order{
    private int id;
    private double weightKg;
    private double distanceKm;

    public int getId(){ return this.id; }
    public void setId(int id){ this.id = id; }

    public double getWeightKg() { return this.weightKg; }
    public void setWeightKg(double value) { this.weightKg = value; }

    public double getDistanceKm() { return this.distanceKm; }
    public void setDistanceKm(double value) { this.distanceKm = value; }
}
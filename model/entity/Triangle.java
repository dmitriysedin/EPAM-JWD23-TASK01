package by.epam.dmitriysedin.task01.model.entity;

/**
 * Created by Dmitriy Sedin on 05.12.2018.
 */
public class Triangle {

    private TwoDimensionsPoint apexA;
    private TwoDimensionsPoint apexB;
    private TwoDimensionsPoint apexC;

    public Triangle() {
    }

    public Triangle(TwoDimensionsPoint apexA, TwoDimensionsPoint apexB, TwoDimensionsPoint apexC) {
        this.apexA = apexA;
        this.apexB = apexB;
        this.apexC = apexC;
    }

    public TwoDimensionsPoint getApexA() {
        return apexA;
    }

    public void setApexA(TwoDimensionsPoint apexA) {
        this.apexA = apexA;
    }

    public TwoDimensionsPoint getApexB() {
        return apexB;
    }

    public void setApexB(TwoDimensionsPoint apexB) {
        this.apexB = apexB;
    }

    public TwoDimensionsPoint getApexC() {
        return apexC;
    }

    public void setApexC(TwoDimensionsPoint apexC) {
        this.apexC = apexC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        if (!apexA.equals(triangle.apexA)) return false;
        if (!apexB.equals(triangle.apexB)) return false;
        return apexC.equals(triangle.apexC);
    }

    @Override
    public int hashCode() {
        int result = apexA.hashCode();
        result = 31 * result + apexB.hashCode();
        result = 31 * result + apexC.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "apexA=" + apexA +
                ", apexB=" + apexB +
                ", apexC=" + apexC +
                '}';
    }
}

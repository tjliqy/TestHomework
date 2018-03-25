/**
 * Created by tjliqy on 2018/3/22
 */
public class Triangle {

    //TriangleType
    public static final int EQUILATERAL = 1;
    public static final int ISOSCELES = 2;
    public static final int SCALENE = 3;

    //The length of three sides of the triangle
    private double sides[] = {0,0,0};

    private int triangleType ;

    /**
     * Construction method of Triangle
     * @param a 1st side length
     * @param b 2nd side length
     * @param c 3rd side length
     */
    public Triangle(double a,double b, double c){
        this.sides[0] = a;
        this.sides[1] = b;
        this.sides[2] = c;
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            int difference = 0;
            boolean getMinuend = false;
            //得出其他两边和或差
            for (int j = 0; j < 3; j++) {
                if (j != i){
                    sum += sides[j];
                    if (!getMinuend){
                        difference += sides[j];
                        getMinuend = true;
                    }else {
                        difference -= sides[j];
                        difference = Math.abs(difference);
                    }
                }
            }
            if (sum <= sides[i] || difference >= sides[i]){
                throw new NotTriangleException();
            }
        }
        initType();
    }

    /**
     * init triangleType
     */
    private void initType(){
        if (sides[0] == sides[1] && sides[1] == sides[2]){
            triangleType = EQUILATERAL;
        }else if (sides[0] == sides[1] || sides[0] == sides[2] || sides[1] ==sides[2]){
            triangleType = ISOSCELES;
        }else {
            triangleType = SCALENE;
        }
    }

    public int getTriangleType() {
        return triangleType;
    }

    /**
     * Equals when two triangles are in same type.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof  Triangle)){
            return false;
        }
        Triangle other = (Triangle)obj;
        return  this.getTriangleType() == other.getTriangleType();
    }
}

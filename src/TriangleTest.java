
import org.junit.Test;
import org.hamcrest.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertEquals;


/**
 * Created by tjliqy on 2018/3/22
 */
public class TriangleTest {

    @Test(expected = NotTriangleException.class)
    public void triangleErrorTest() throws NotTriangleException {
        new Triangle(0, 0, 0);
    }

    @Test
    public void equilateralTest() {
        Triangle triangle = new Triangle(1, 1, 1);
        assertEquals(Triangle.EQUILATERAL, triangle.getTriangleType());
    }

    @Test
    public void isocelesTest() {
        Triangle triangle = new Triangle(2, 2, 3);
        assertEquals(Triangle.ISOSCELES, triangle.getTriangleType());
    }

    @Test
    public void scaleneTest() {
        Triangle triangle = new Triangle(3, 4, 5);
        assertEquals(Triangle.SCALENE, triangle.getTriangleType());
    }

    /**
     * this func use hamcrest
     */
    @Test
    public void sameTypeTest() {
        Triangle t1 = new Triangle(4, 4, 4);
        Triangle t2 = new Triangle(5,5,5);
        assertThat("failure - They are not same!", t1, equalTo(t2));

    }
}
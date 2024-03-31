import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void example() { assertTrue(true); }

  @Test
  public void oneArg()
  {
    assertFalse(c.compute(8));
  }

  @Test
  public void evenArgs()
  {
    assertFalse(c.compute(5, 48, 94, 1));
  }

  @Test
  public void oddFalseCall()
  {
    assertFalse(c.compute(50, 45, 78));
  }

  @Test
  public void trueCall1()
  {
    assertTrue(c.compute(2, 3, 1));
  }
  
  @Test
  public void trueCall2()
  {
    assertTrue(c.compute(23, 10, 7));
  }

  @Test(expected = RuntimeException.class)
  public void zeroRuntimeExc()
  {
    c.compute(2, 4, 0);
  }
}
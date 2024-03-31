import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TestCompute {
  Compute c;
  MessageQueue mq;
  
  @Before
  public void setUp(){
    mq = mock(MessageQueue.class);
    c = new Compute(mq);
  }
  
  @Test
  public void example() {
    assertTrue(true);
  }

  @Test
  public void emptyString()
  {
    when(mq.size()).thenReturn(0);
    assertEquals(-1, c.countNumberOfOccurrences("Message"));
  }

  @Test
  public void notContains()
  {
    String message = "message";
    when(mq.size()).thenReturn(5);
    when(mq.contains(message)).thenReturn(false);
    assertEquals(0, c.countNumberOfOccurrences(message));
  }

  @Test
  public void allOccurences()
  {
    String message = "message";
    when(mq.size()).thenReturn(5);
    when(mq.contains(message)).thenReturn(true);
    when(mq.getAt(anyInt())).thenReturn(message);
    assertEquals(5, c.countNumberOfOccurrences(message));
  }

  @Test
  public void twoOccurence()
  {
    String message = "message";
    when(mq.size()).thenReturn(5);
    when(mq.contains(message)).thenReturn(true);
    when(mq.getAt(anyInt())).thenReturn("nothing",message, "nothing", "nothing",message);
    assertEquals(2, c.countNumberOfOccurrences(message));
  }
}
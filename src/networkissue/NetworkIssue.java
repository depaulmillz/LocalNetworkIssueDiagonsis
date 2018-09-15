
package networkissue;

import java.io.*;
import java.net.*;

/**
 *
 * @author dePaul Miller
 */
public class NetworkIssue
{
  public static boolean pingHost(String host, int port, int timeout) {
    try (Socket socket = new Socket()) {
        socket.connect(new InetSocketAddress(host, port), timeout);
        return true;
    } catch (IOException e) {
        return false; // Either timeout or unreachable or failed DNS lookup.
    }
  }
  public static boolean sendping(String addr, int port)
  {
    return pingHost(addr,port,5000);
  }
  public static boolean internetConnection()
  {
    return sendping("8.8.8.8",53);
  }
  public static boolean localConnection()
  {
    //change this to whatever gateway on network is
    return sendping("192.168.1.1",80);
  }
  public static boolean dnsWorking()
  {
    return sendping("www.google.com",80);
  }
}

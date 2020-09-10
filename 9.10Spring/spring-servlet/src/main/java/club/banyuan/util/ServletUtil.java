package club.banyuan.util;

import com.alibaba.fastjson.JSONObject;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ServletUtil {

  public static void sendSuccess(PrintWriter writer) {
    sendSuccess(writer, new HashMap<>());
  }

  public static void sendSuccess(PrintWriter writer, Map<String, Object> message) {
    message.put("code", 0);
    message.put("message", "");
    writer.println(JSONObject.toJSONString(message));
  }

  public static void sendFail(PrintWriter writer, Object message) {
    Map<String, Object> rlt = new HashMap<>();
    rlt.put("code", 1);
    rlt.put("message", message);
    writer.println(JSONObject.toJSONString(rlt));
  }
}

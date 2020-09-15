package club.banyuan.common;

import java.util.HashMap;
import java.util.List;

public class RespResult extends HashMap<String, Object> {

  public static RespResult success(int total, List<?> rows) {
    RespResult rlt = success();
    rlt.put("rows", rows);
    rlt.put("total", total);
    return rlt;
  }

  public static RespResult success() {
    RespResult rlt = new RespResult();
    rlt.put("code", 0);
    rlt.put("message", "");
    return rlt;
  }

  public static RespResult fail(String message) {
    RespResult rlt = new RespResult();
    rlt.put("code", 1);
    rlt.put("message", message);
    return rlt;
  }


}

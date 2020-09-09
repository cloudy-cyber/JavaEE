package club.banyuan;

import java.util.Objects;

public class MyServlet {

  private String name;
  private String url;
  private String className;

  public MyServlet() {
  }

  public MyServlet(String name, String url, String className) {
    this.name = name;
    this.url = url;
    this.className = className;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  @Override
  public String toString() {
    return "MyServlet{" +
        "name='" + name + '\'' +
        ", url='" + url + '\'' +
        ", className='" + className + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MyServlet myServlet = (MyServlet) o;
    return Objects.equals(name, myServlet.name) &&
        Objects.equals(url, myServlet.url) &&
        Objects.equals(className, myServlet.className);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, url, className);
  }
}

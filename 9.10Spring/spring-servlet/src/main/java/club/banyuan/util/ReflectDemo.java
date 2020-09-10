package club.banyuan.util;

import club.banyuan.admin.entity.Admin;
import club.banyuan.common.DBOrder;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReflectDemo {

  public static void main(String[] args) {
    Class<Admin> adminClass = Admin.class;

    Field[] declaredFields = adminClass.getDeclaredFields();

    List<Field> fieldWithDbOrder = new ArrayList<>();
    for (Field declaredField : declaredFields) {
      System.out.println(declaredField.getName());

      DBOrder dbOrder = declaredField.getDeclaredAnnotation(DBOrder.class);
      if (dbOrder != null) {
        fieldWithDbOrder.add(declaredField);
      }
    }

    fieldWithDbOrder.sort(new Comparator<Field>() {
      @Override
      public int compare(Field o1, Field o2) {
        DBOrder d1 = o1.getDeclaredAnnotation(DBOrder.class);
        DBOrder d2 = o2.getDeclaredAnnotation(DBOrder.class);
        return d1.value() - d2.value();
      }
    });

  }


  public static List<Field> getDbField(Class<?> cls) {
    Field[] declaredFields = cls.getDeclaredFields();

    List<Field> fieldWithDbOrder = new ArrayList<>();
    for (Field declaredField : declaredFields) {
      System.out.println(declaredField.getName());

      DBOrder dbOrder = declaredField.getDeclaredAnnotation(DBOrder.class);
      if (dbOrder != null) {
        fieldWithDbOrder.add(declaredField);
      }
    }

    fieldWithDbOrder.sort(new Comparator<Field>() {
      @Override
      public int compare(Field o1, Field o2) {
        DBOrder d1 = o1.getDeclaredAnnotation(DBOrder.class);
        DBOrder d2 = o2.getDeclaredAnnotation(DBOrder.class);
        return d1.value() - d2.value();
      }
    });

    return fieldWithDbOrder;
  }

}

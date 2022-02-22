package javacore.base.copy_deep_shallow.test4_serialize_deep_copy.util;

import java.io.*;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-29
 */
public class CloneUtils {
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T deepClone(T obj) {
        T cloneObj = null;
        try {
            //写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();

            //分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            //返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }

}

package javacore.baseimpro.jvm.soft_weak_reference;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ByteBean {

    private int size;

    private byte[] bytes;

    public ByteBean(int size) {
        this.size = size;
        this.bytes = new byte[this.size];
    }

    @Override
    public String toString() {
        return "ByteBean[" + this.hashCode() + "]{" +
                "size=" + size +
                ", bytes=" + bytes +
                '}';
    }
}
